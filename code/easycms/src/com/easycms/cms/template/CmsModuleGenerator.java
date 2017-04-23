package com.easycms.cms.template;


public class CmsModuleGenerator {
	private static String packName = "com.easycms.cms.template";
	private static String fileName = "easycms.properties";

	public static void main(String[] args) {
		new ModuleGenerator(packName, fileName).generate();
	}
}
