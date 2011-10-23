package com.taobao.geek.yacs;

import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

public abstract class YacsClassPathBeanDefinitionScanner extends
		ClassPathBeanDefinitionScanner {

	private static final String YACS_PRIVATE_PKG_NAME = "\0x28";
	
	private Properties properties = new Properties();

	protected String getProperty(String key) {
		return properties.getProperty(key);
	}

	protected void addProperty(String key, String value) {
		properties.put(key, value);
	}

	protected Properties getProperties() {
		return properties;
	}

	public YacsClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry) {
		super(registry);
	}

	public final Set<BeanDefinitionHolder> doScan() {
		return doScan(YACS_PRIVATE_PKG_NAME);
	}

	@Override
	public final Set<BeanDefinition> findCandidateComponents(String basePackage) {
		if (YACS_PRIVATE_PKG_NAME.equals(basePackage)) {
			return generateCandidateComponents();
		}
		return super.findCandidateComponents(basePackage);
	}

	abstract protected Set<BeanDefinition> generateCandidateComponents();
}
