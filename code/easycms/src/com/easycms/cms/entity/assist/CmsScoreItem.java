package com.easycms.cms.entity.assist;

import com.easycms.cms.entity.assist.base.BaseCmsScoreItem;



public class CmsScoreItem extends BaseCmsScoreItem {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CmsScoreItem () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CmsScoreItem (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CmsScoreItem (
		java.lang.Integer id,
		com.easycms.cms.entity.assist.CmsScoreGroup group,
		java.lang.String name,
		java.lang.Integer score,
		java.lang.Integer priority) {

		super (
			id,
			group,
			name,
			score,
			priority);
	}

/*[CONSTRUCTOR MARKER END]*/


}