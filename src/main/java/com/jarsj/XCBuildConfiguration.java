package com.jarsj;

import java.util.Map;

public class XCBuildConfiguration extends Element {

	/* The path to a xcconfig file. */
	private String baseConfigurationReference;
	
	/* A map of build settings. */
	private Map<String, Object> buildSettings;
	
	/* The configuration name. */
	private String name;

	public String getBaseConfigurationReference() {
		return baseConfigurationReference;
	}

	public void setBaseConfigurationReference(String baseConfigurationReference) {
		this.baseConfigurationReference = baseConfigurationReference;
	}

	public Map<String, Object> getBuildSettings() {
		return buildSettings;
	}

	public void setBuildSettings(Map<String, Object> buildSettings) {
		this.buildSettings = buildSettings;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
