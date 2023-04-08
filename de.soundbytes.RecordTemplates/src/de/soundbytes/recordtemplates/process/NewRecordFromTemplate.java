package de.soundbytes.recordtemplates.process;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;

import org.adempiere.exceptions.AdempiereException;
import org.adempiere.webui.adwindow.ADWindow;
import org.adempiere.webui.adwindow.ADWindowContent;
import org.adempiere.webui.apps.AEnv;
import org.adempiere.webui.session.SessionManager;
import org.compiere.model.GridTab;
//import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.zkoss.zk.ui.Component;

import de.soundbytes.recordtemplates.model.MRecordTemplate;

public class NewRecordFromTemplate extends SvrProcess {

	private Integer recordTemplateID = 0;

    @Override
    protected void prepare() {
		ProcessInfoParameter[] para = getParameter();
		for (int i = 0; i < para.length; i++)
		{
			String name = para[i].getParameterName();
			if (para[i].getParameter() == null)
				;
			else if (name.equals("SB_RecordTemplate_ID"))
				recordTemplateID = para[i].getParameterAsInt();
			else
				log.log(Level.SEVERE, "Unknown Parameter: " + name);
		}
    }

    @Override
    protected String doIt() throws Exception {
//        int tableID = activeTab.getAD_Table_ID();
//        String whereClause = "AD_Table_ID = ?";
//
//        // Query the template record
//        MRecordTemplate recordTemplate = new Query(getCtx(), MRecordTemplate.Table_Name, whereClause, get_TrxName())
//        	    .setParameters(tableID)
//        	    .first();
    	
    	
        MRecordTemplate recordTemplate = new MRecordTemplate(getCtx(), recordTemplateID, get_TrxName());
        if (recordTemplate.get_ID() == 0) {
        	throw new AdempiereException("Error. No Templates found. ");
        }
        int recordID = recordTemplate.getRecord_ID();  
        
        String err = addNew(recordID);
        if(!err.isEmpty())
        	throw new AdempiereException(err);

        return "Record generated successfully.";
    }

    
	public CountDownLatch latch;
	String err = "";
	
	public String addNew(int recordID) {
		latch = new CountDownLatch(1);
		AEnv.executeAsyncDesktopTask(new Runnable() {
			@Override
			public void run() {
				err = "starting addNew(" + recordID + ")";
				ADWindowContent windowContent = null;
				GridTab activeTab = null;
				activeTab = null;
				Component window = SessionManager.getAppDesktop().getActiveWindow();
				ADWindow adWindow = ADWindow.findADWindow(window);
				if (adWindow != null) {
					windowContent = adWindow.getADWindowContent();
					activeTab = adWindow.getADWindowContent().getActiveGridTab();
				}
				if (activeTab == null)
		        	err = "Error! Active Tab not found.";
		
		        // get template row
		        boolean isTemplateCurrent = false;
		        for(int rowIdx=0; rowIdx<activeTab.getRowCount(); ++rowIdx) {
		        	if(activeTab.getKeyID(rowIdx) == recordID) {
		        		if( rowIdx == activeTab.navigate(rowIdx) ) {
			        		isTemplateCurrent = true;
			        		err = "template Selected";
			        		break;
		        		}
		        		else {
				        	err = "Error: Could not select template.";
				        	latch.countDown();
				        	return;
		        		}
		        	}
		        }
		        if(isTemplateCurrent)	
		        	windowContent.onCopy();
		        else
		        	err = "We have a problem. template not loaded. Case is not yet implemented.";
			}
			
		});
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return err;
	}
 
}

