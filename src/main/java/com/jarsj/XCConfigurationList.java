package com.jarsj;

import java.util.List;

public class XCConfigurationList extends Element{

	/* The objects are a reference to a XCBuildConfiguration element. */
	private List<XCBuildConfiguration> buildConfigurations;
	
	private int defaultConfigurationIsVisible;
	
	/* The default configuration name. */
	private String defaultConfigurationName;

	public List<XCBuildConfiguration> getBuildConfigurations() {
		return buildConfigurations;
	}

	public void setBuildConfigurations(List<XCBuildConfiguration> buildConfigurations) {
		this.buildConfigurations = buildConfigurations;
	}

	public int getDefaultConfigurationIsVisible() {
		return defaultConfigurationIsVisible;
	}

	public void setDefaultConfigurationIsVisible(int defaultConfigurationIsVisible) {
		this.defaultConfigurationIsVisible = defaultConfigurationIsVisible;
	}

	public String getDefaultConfigurationName() {
		return defaultConfigurationName;
	}

	public void setDefaultConfigurationName(String defaultConfigurationName) {
		this.defaultConfigurationName = defaultConfigurationName;
	}	
}
