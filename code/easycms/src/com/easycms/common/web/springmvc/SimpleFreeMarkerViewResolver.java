package com.easycms.common.web.springmvc;

import org.springframework.web.servlet.view.AbstractTemplateViewResolver;
import org.springframework.web.servlet.view.AbstractUrlBasedView;

public class SimpleFreeMarkerViewResolver extends AbstractTemplateViewResolver {
	/**
	 * Set default viewClass
	 */
	public SimpleFreeMarkerViewResolver() {
		setViewClass(SimpleFreeMarkerView.class);
	}

	/**
	 * if viewName start with / , then ignore prefix.
	 */
	@Override
	protected AbstractUrlBasedView buildView(String viewName) throws Exception {
		AbstractUrlBasedView view = super.buildView(viewName);
		// start with / ignore prefix
		if (viewName.startsWith("/")) {
			String utl = viewName + getSuffix();
			view.setUrl(utl);
		}
		return view;
	}
}
