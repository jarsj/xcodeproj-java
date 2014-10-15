package com.jarsj;

import java.util.ArrayList;
import java.util.List;

public class XCConfigurationList extends Element{

	/* The objects are a reference to a XCBuildConfiguration element. */
	private List<XCBuildConfiguration> buildConfigurations;
	
	private int defaultConfigurationIsVisible;
	
	/* The default configuration name. */
	private String defaultConfigurationName;
	
	public XCConfigurationList() {
		super("XCConfigurationList");
		this.defaultConfigurationIsVisible = 0;
		this.buildConfigurations = new ArrayList<XCBuildConfiguration>();
	}

	public List<XCBuildConfiguration> getBuildConfigurations() {
		return buildConfigurations;
	}

	public void setBuildConfigurations(List<Object> buildConfigurations) {
		if(buildConfigurations != null) {
			for(Object obj : buildConfigurations) {
				this.buildConfigurations.add((XCBuildConfiguration)obj);
			}
		}
	}

	public int getDefaultConfigurationIsVisible() {
		return defaultConfigurationIsVisible;
	}

	public void setDefaultConfigurationIsVisible(Object defaultConfigurationIsVisible) {
		if(defaultConfigurationIsVisible != null) {
			this.defaultConfigurationIsVisible = (Integer)defaultConfigurationIsVisible;
		}
	}

	public String getDefaultConfigurationName() {
		return defaultConfigurationName;
	}

	public void setDefaultConfigurationName(String defaultConfigurationName) {
		this.defaultConfigurationName = defaultConfigurationName;
	}	
}
