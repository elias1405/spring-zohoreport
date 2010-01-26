package net.jclagache.zohoreport;

import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

public abstract class BaseZohoReportTestCase extends
		AbstractDependencyInjectionSpringContextTests {
	
	protected String[] getConfigLocations() {
        return new String[] { "classpath:applicationContext.xml" };
    }

}
