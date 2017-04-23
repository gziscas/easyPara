package com.easycms.cms.entity.assist;

import java.util.Collection;

import org.json.JSONException;
import org.json.JSONObject;

import com.easycms.cms.entity.assist.base.BaseCmsGuestbookCtg;



public class CmsGuestbookCtg extends BaseCmsGuestbookCtg {
	private static final long serialVersionUID = 1L;
	
	public JSONObject convertToJson() 
			throws JSONException{
		JSONObject json=new JSONObject();
		json.put("id", getId());
		json.put("description", getDescription());
		json.put("name", getName());
		json.put("priority", getPriority());
		return json;
	}

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CmsGuestbookCtg () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CmsGuestbookCtg (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CmsGuestbookCtg (
		java.lang.Integer id,
		com.easycms.core.entity.CmsSite site,
		java.lang.String name,
		java.lang.Integer priority) {

		super (
			id,
			site,
			name,
			priority);
	}
	public static Integer[] fetchIds(Collection<CmsGuestbookCtg> guestBookCtgs) {
		if (guestBookCtgs == null) {
			return null;
		}
		Integer[] ids = new Integer[guestBookCtgs.size()];
		int i = 0;
		for (CmsGuestbookCtg c : guestBookCtgs) {
			ids[i++] = c.getId();
		}
		return ids;
	}

/*[CONSTRUCTOR MARKER END]*/


}