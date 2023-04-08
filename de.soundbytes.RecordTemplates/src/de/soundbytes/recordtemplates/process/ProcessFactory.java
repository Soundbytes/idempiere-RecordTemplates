package de.soundbytes.recordtemplates.process;

import org.adempiere.base.IProcessFactory;
import org.compiere.process.ProcessCall;

public class ProcessFactory implements IProcessFactory {

	@Override
	public ProcessCall newProcessInstance(String className) {
		switch (className) {
		case "de.soundbytes.recordtemplates.process.AddRecordTemplate":
			return new AddRecordTemplate();	
		case "de.soundbytes.recordtemplates.process.NewRecordFromTemplate":
			return new NewRecordFromTemplate();	
		default:
			return null;
		}
	}
}
