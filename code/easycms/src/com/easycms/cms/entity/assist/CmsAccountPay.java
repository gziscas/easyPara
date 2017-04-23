package com.easycms.cms.entity.assist;

import com.easycms.cms.entity.assist.base.BaseCmsAccountPay;



public class CmsAccountPay extends BaseCmsAccountPay {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CmsAccountPay () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CmsAccountPay (java.lang.Long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CmsAccountPay (
		java.lang.Long id,
		com.easycms.core.entity.CmsUser payUser,
		com.easycms.core.entity.CmsUser drawUser,
		java.lang.String drawNum,
		java.lang.String payAccount,
		java.lang.String drawAccount,
		java.util.Date payTime) {

		super (
			id,
			payUser,
			drawUser,
			drawNum,
			payAccount,
			drawAccount,
			payTime);
	}

/*[CONSTRUCTOR MARKER END]*/


}