/******************************************************************************
 * Product: iDempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2012 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
/** Generated Model - DO NOT CHANGE */
package de.soundbytes.recordtemplates.model;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.I_Persistent;
import org.compiere.model.MTable;
import org.compiere.model.PO;
import org.compiere.model.POInfo;
import org.compiere.model.X_AD_Role;
import org.compiere.model.X_AD_Tab;
import org.compiere.model.X_AD_Table;
import org.compiere.model.X_AD_User;

/**
 * Generated Model for table SB_RecordTemplate
 * @author iDempiere (generated)
 * @version Release 8.2 - $Id$
 */
public class X_SB_RecordTemplate extends PO implements I_SB_RecordTemplate, I_Persistent {

	private static final long serialVersionUID = 20230408L;

	/**
	 * Standard Constructor
	 */
	public X_SB_RecordTemplate (Properties ctx, int recordTemplateID, String trxName) {
		super (ctx, recordTemplateID, trxName);
		/** if (recordTemplateID == 0)
		{
			setAD_Tab_ID (0);
			setSB_RecordTemplate_ID (0);
		} */
	}

	/**
	 * Load Constructor
	 */
	public X_SB_RecordTemplate (Properties ctx, ResultSet rs, String trxName) {
		super (ctx, rs, trxName);
	}

	/**
	 * AccessLevel
	 * @return 7 - System - Client - Org 
	 */
	@Override
	protected int get_AccessLevel() {
		return accessLevel.intValue();
	}

	/**
	 * Load Meta Data
	 */
	@Override
	protected POInfo initPO (Properties ctx) {
		POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
		return poi;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder ("X_SB_RecordTemplate[")
			.append(get_ID()).append(",Name=").append(getName()).append("]");
		return sb.toString();
	}

	@Override
	public X_AD_Role getAD_Role() throws RuntimeException {
		return (X_AD_Role)MTable.get(getCtx(), X_AD_Role.Table_Name)
				.getPO(getAD_Role_ID(), get_TrxName());
	}

	/**
	 * Set Role.
	 * @param AD_Role_ID 
	 * Responsibility Role
	 */
	@Override
	public void setAD_Role_ID (int roleID) {
		if (roleID < 0) 
			set_ValueNoCheck (COLUMNNAME_AD_Role_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_AD_Role_ID, Integer.valueOf(roleID));
	}

	/**
	 * Get Role.
	 * @return Responsibility Role
	 */
	@Override
	public int getAD_Role_ID () {
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Role_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	@Override
	public X_AD_Tab getAD_Tab() throws RuntimeException {
		return (X_AD_Tab)MTable.get(getCtx(), X_AD_Tab.Table_Name)
				.getPO(getAD_Tab_ID(), get_TrxName());
	}

	/**
	 * Set Tab.
	 * @param AD_Tab_ID 
	 * Tab within a Window
	 */
	@Override
	public void setAD_Tab_ID (int tabID) {
		if (tabID < 1) 
			set_Value (COLUMNNAME_AD_Tab_ID, null);
		else 
			set_Value (COLUMNNAME_AD_Tab_ID, Integer.valueOf(tabID));
	}

	/**
	 * Get Tab.
	 * @return Tab within a Window
	 */
	@Override
	public int getAD_Tab_ID () {
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Tab_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	@Override
	public X_AD_Table getAD_Table() throws RuntimeException {
		return (X_AD_Table)MTable.get(getCtx(), X_AD_Table.Table_Name)
				.getPO(getAD_Table_ID(), get_TrxName());
	}

	/**
	 * Set Table.
	 * @param AD_Table_ID 
	 * Database Table information
	 */
	@Override
	public void setAD_Table_ID (int tableID) {
		if (tableID < 1) 
			set_Value (COLUMNNAME_AD_Table_ID, null);
		else 
			set_Value (COLUMNNAME_AD_Table_ID, Integer.valueOf(tableID));
	}

	/**
	 * Get Table.
	 * @return Database Table information
	 */
	@Override
	public int getAD_Table_ID () {
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Table_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	@Override
	public X_AD_User getAD_User() throws RuntimeException {
		return (X_AD_User)MTable.get(getCtx(), X_AD_User.Table_Name)
				.getPO(getAD_User_ID(), get_TrxName());
	}

	/**
	 * Set User/Contact.
	 * @param AD_User_ID 
	 * User within the system - Internal or Business Partner Contact
	 */
	@Override
	public void setAD_User_ID (int userID) {
		if (userID < 1) 
			set_ValueNoCheck (COLUMNNAME_AD_User_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_AD_User_ID, Integer.valueOf(userID));
	}

	/**
	 * Get User/Contact.
	 * @return User within the system - Internal or Business Partner Contact
	 */
	@Override
	public int getAD_User_ID () {
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_User_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/**
	 * Set Name.
	 * @param Name 
	 * Alphanumeric identifier of the entity
	 */
	@Override
	public void setName (String name) {
		set_Value (COLUMNNAME_Name, name);
	}

	/**
	 * Get Name.
	 * @return Alphanumeric identifier of the entity
	 */
	@Override
	public String getName () {
		return (String)get_Value(COLUMNNAME_Name);
	}

	/**
	 * Set Record ID.
	 * @param Record_ID 
	 * Direct internal record ID
	 */
	@Override
	public void setRecord_ID (int iD) {
		if (iD < 0) 
			set_ValueNoCheck (COLUMNNAME_Record_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_Record_ID, Integer.valueOf(iD));
	}

	/**
	 * Get Record ID.
	 * @return Direct internal record ID
	 */
	@Override
	public int getRecord_ID () {
		Integer ii = (Integer)get_Value(COLUMNNAME_Record_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/**
	 * Set RecordTemplate.
	 * @param SB_RecordTemplate_ID RecordTemplate
	 */
	@Override
	public void setSB_RecordTemplate_ID (int recordTemplateID) {
		if (recordTemplateID < 1) 
			set_ValueNoCheck (COLUMNNAME_SB_RecordTemplate_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_SB_RecordTemplate_ID, Integer.valueOf(recordTemplateID));
	}

	/**
	 * Get RecordTemplate.
	 * @return RecordTemplate
	 */
	@Override
	public int getSB_RecordTemplate_ID () {
		Integer ii = (Integer)get_Value(COLUMNNAME_SB_RecordTemplate_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/**
	 * Set SB_RecordTemplate_UU.
	 * @param SB_RecordTemplate_UU SB_RecordTemplate_UU
	 */
	@Override
	public void setSB_RecordTemplate_UU (String recordTemplateUU) {
		set_Value (COLUMNNAME_SB_RecordTemplate_UU, recordTemplateUU);
	}

	/**
	 * Get SB_RecordTemplate_UU.
	 * @return SB_RecordTemplate_UU
	 */
	@Override
	public String getSB_RecordTemplate_UU () {
		return (String)get_Value(COLUMNNAME_SB_RecordTemplate_UU);
	}

	/**
	 * Set DB Table Name.
	 * @param TableName 
	 * Name of the table in the database
	 */
	@Override
	public void setTableName (String tableName) {
		set_ValueNoCheck (COLUMNNAME_TableName, tableName);
	}

	/**
	 * Get DB Table Name.
	 * @return Name of the table in the database
	 */
	@Override
	public String getTableName () {
		return (String)get_Value(COLUMNNAME_TableName);
	}
}