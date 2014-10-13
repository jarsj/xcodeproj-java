package com.jarsj;

import java.util.List;

public class PBXAggregateTarget extends Element{

	/* The object is a reference to a XCConfigurationList element. */
	private XCConfigurationList buildConfigurationList;	
	
	/* The objects are a reference to a PBXBuildPhase element. */
	private List<PBXBuildPhase> buildPhases;
	
	/*The objects are a reference to a PBXTargetDependency element. */
	private List<PBXTargetDependency> dependencies;
	
	/* The name of the target. */
	private String name;
	
	/* The product name. */
	private String productName;

	public XCConfigurationList getBuildConfigurationList() {
		return buildConfigurationList;
	}

	public void setBuildConfigurationList(XCConfigurationList buildConfigurationList) {
		this.buildConfigurationList = buildConfigurationList;
	}

	public List<PBXBuildPhase> getBuildPhases() {
		return buildPhases;
	}

	public void setBuildPhases(List<PBXBuildPhase> buildPhases) {
		this.buildPhases = buildPhases;
	}

	public List<PBXTargetDependency> getDependencies() {
		return dependencies;
	}

	public void setDependencies(List<PBXTargetDependency> dependencies) {
		this.dependencies = dependencies;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
}
