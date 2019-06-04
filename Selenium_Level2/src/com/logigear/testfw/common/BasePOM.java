package com.logigear.testfw.common;

import java.util.Map;

import com.logigear.testfw.conf.Locator;
import com.logigear.testfw.conf.LocatorLoader;

/**
 * 
 * @author ngocquang.tran
 *
 */
public abstract class BasePOM {

	private Map<String, Locator> locators = null;

	public BasePOM(Class<?> derivedClass) {
		String platform = TestExecutor.getInstance().getEnvironmentConf().getPlatform().toString();
		String target = TestExecutor.getInstance().getEnvironmentConf().getRunTarget().toString();
		// load all locators from JSON file, based on the class-name of the derived-class
		locators = LocatorLoader.getLocatorsByClassName(derivedClass, platform, target);
		initPageElements();
	}

	protected Locator getLocator(String elementName) {
		return locators.get(elementName);
	}

	public abstract void initPageElements();
}
