package com.taobao.geek.yacs;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class YacsNamespaceHandler extends NamespaceHandlerSupport {

	public void init() {
		registerBeanDefinitionParser("scan", new YetAnotherComponentScanBeanDefinitionParser());
	}
}