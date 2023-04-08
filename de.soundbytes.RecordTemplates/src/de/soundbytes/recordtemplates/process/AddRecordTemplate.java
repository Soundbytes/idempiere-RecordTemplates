package de.soundbytes.recordtemplates.process;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;

import org.adempiere.exceptions.AdempiereException;
import org.adempiere.webui.adwindow.ADWindow;
import org.adempiere.webui.apps.AEnv;
import org.adempiere.webui.session.SessionManager;
import org.compiere.model.GridTab;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.Env;
import org.zkoss.zk.ui.Component;
import de.soundbytes.recordtemplates.model.MRecordTemplate;

public class AddRecordTemplate extends SvrProcess {

    private int recordID = 0;
    private int tableID = 0;
    private int tabID = 0;
	private String templateName;
    
    
    @Override
    protected void prepare() {
    	tabID = getActiveTabID();
    	
        // Get the values of the parameters passed to the process
		ProcessInfoParameter[] para = getParameter();
		for (int i = 0; i < para.length; i++)
		{
			String name = para[i].getParameterName();
			if (para[i].getParameter() == null)
				;
			else if (name.equals("Name"))
				templateName = ((String)para[i].getParameter());
			else
				log.log(Level.SEVERE, "Unknown Parameter: " + name);
		}
		
        recordID = getRecord_ID();
        if (recordID == 0)
        	throw new AdempiereException("Error: A new record can not be added as a template. Please save first.");
        tableID = getTable_ID();
        
    }
    
    @Override
    protected String doIt() throws Exception {
    	int roleID = Env.getAD_Role_ID(getCtx());
    	int userID = Env.getAD_User_ID(getCtx());
    	
        // Check if a record template with the same properties already exists
        String whereClause = "Record_ID=? AND AD_Table_ID=? AND AD_Tab_ID=? AND AD_Role_ID=? AND AD_User_ID=?";
        ArrayList<Object> params = new ArrayList<>();
        params.add(recordID);
        params.add(tableID);
        params.add(tabID);
        params.add(roleID);
        params.add(userID);

//        String whereClause = "Record_ID=? AND AD_Table_ID=?";
//        ArrayList<Object> params = new ArrayList<>();
//        params.add(recordID);
//        params.add(tableID);

    	
        MRecordTemplate recordTemplate = new Query(getCtx(), MRecordTemplate.Table_Name, whereClause, get_TrxName())
                        .setParameters(params)
                        .first();
        if (recordTemplate != null) {
        	recordTemplate.setName(templateName);
        	return "Existing Template renamed.";
        }
    	
        // Instantiate the MRecordTemplate model class
        recordTemplate = new MRecordTemplate(getCtx(), 0, get_TrxName());
        
        // Set the values of the record template fields
    	recordTemplate.setName(templateName);
        recordTemplate.setRecord_ID(recordID);
        recordTemplate.setAD_Table_ID(tableID);
        recordTemplate.setAD_Tab_ID(tabID);
        recordTemplate.setAD_User_ID(userID);
        recordTemplate.setAD_Role_ID(roleID);
        
        // Save the record template to the database
        recordTemplate.saveEx();
        
        return "Record added as template";
    }
    
    
	public CountDownLatch latch;
	
	int getActiveTabID() {
		latch = new CountDownLatch(1);
		AEnv.executeAsyncDesktopTask(new Runnable() {
			@Override
			public void run() {
    			GridTab activeTab = null;
    			Component window = SessionManager
    					.getAppDesktop()
    					.getActiveWindow();
    			ADWindow adwindow = ADWindow.findADWindow(window);
    			if (adwindow != null) {
    				activeTab = adwindow.getADWindowContent().getActiveGridTab();
    			}
    			if (activeTab == null)
    	        	throw new AdempiereException("Error! Active Tab not found.");
    	    	tabID = activeTab.getAD_Tab_ID();

    			latch.countDown();
			}
							
		});
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return tabID;
	}
}
