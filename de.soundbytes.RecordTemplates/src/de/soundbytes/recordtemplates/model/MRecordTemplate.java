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

package de.soundbytes.recordtemplates.model;

import java.sql.ResultSet;
import java.util.Properties;

/**
 * Custom Model for table SB_RecordTemplate
 * @author Andreas Sumerauer
 * @version Release 8.2 - $Id$
 */
public class MRecordTemplate extends X_SB_RecordTemplate{

	private static final long serialVersionUID = 20230407L;

	/**
	 * Standard Constructor
	 */
	public MRecordTemplate (Properties ctx, int recordTemplateID, String trxName) {
		super (ctx, recordTemplateID, trxName);
	}

	/**
	 * Load Constructor
	 */
	public MRecordTemplate (Properties ctx, ResultSet rs, String trxName) {
		super (ctx, rs, trxName);
	}

	@Override
	public boolean save() {
		return super.save();
	}

	public static MRecordTemplate get(Properties ctx, int recordTemplateID, String trxName) {
		return new MRecordTemplate (ctx, recordTemplateID, trxName);
	}
}