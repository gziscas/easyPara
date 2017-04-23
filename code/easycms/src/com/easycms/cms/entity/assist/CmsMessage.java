package com.easycms.cms.entity.assist;

import org.json.JSONException;
import org.json.JSONObject;

import com.easycms.cms.entity.assist.base.BaseCmsMessage;
import com.easycms.common.util.DateUtils;
import com.easycms.common.util.StrUtils;



public class CmsMessage extends BaseCmsMessage {
	private static final long serialVersionUID = 1L;
	
	public JSONObject convertToJson() 
			throws JSONException{
		JSONObject json=new JSONObject();
		json.put("id", getId());
		json.put("msgTitle", getMsgTitle());
		json.put("msgContent", getMsgContent());
		json.put("sendTime", DateUtils.parseDateToTimeStr(getSendTime()));
		json.put("msgStatus", getMsgStatus());
		json.put("msgBox", getMsgBox());
		if(getMsgReceiverUser()!=null){
			json.put("msgReceiverUser", getMsgReceiverUser().getUsername());
		}
		if(getMsgSendUser()!=null){
			json.put("msgSendUser", getMsgSendUser().getUsername());
		}
		return json;
	}

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CmsMessage () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CmsMessage (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CmsMessage (
		java.lang.Integer id,
		com.easycms.core.entity.CmsUser msgReceiverUser,
		com.easycms.core.entity.CmsUser msgSendUser,
		com.easycms.core.entity.CmsSite site,
		java.lang.String msgTitle,
		java.lang.Boolean msgStatus,
		java.lang.Integer msgBox) {

		super (
			id,
			msgReceiverUser,
			msgSendUser,
			site,
			msgTitle,
			msgStatus,
			msgBox);
	}
	public String getTitleHtml() {
		return StrUtils.txt2htm(getMsgTitle());
	}
	public String getContentHtml() {
		return StrUtils.txt2htm(getMsgContent());
	}


/*[CONSTRUCTOR MARKER END]*/


}