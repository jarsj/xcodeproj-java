package com.jarsj;

import java.util.ArrayList;
import java.util.List;

public abstract class PBXTarget extends Element {

	/* The object is a reference to a XCConfigurationList element. */
	private XCConfigurationList buildConfigurationList;
	
	/* The objects are a reference to a PBXBuildPhase element. */
	private List<PBXBuildPhase> buildPhases;
	
	/* The objects are a reference to a PBXTargetDependency element. */
	private List<PBXTargetDependency> dependencies;
	
	/* The name of the target. */
	private String name;
	
	/* The product name. */
	private String productName;

	public PBXTarget(String isa) {
		super(isa);
		this.buildConfigurationList = new XCConfigurationList();
		this.buildPhases = new ArrayList<PBXBuildPhase>();
		this.dependencies = new ArrayList<PBXTargetDependency>();
	}
	
	public XCConfigurationList getBuildConfigurationList() {
		return buildConfigurationList;
	}

	public void setBuildConfigurationList(XCConfigurationList buildConfigurationList) {
		this.buildConfigurationList = buildConfigurationList;
	}

	public List<PBXBuildPhase> getBuildPhases() {
		return buildPhases;
	}

	public void setBuildPhases(List<Object> buildPhases) {
		if(buildPhases != null) {
			for(Object obj : buildPhases) {
				this.buildPhases.add((PBXBuildPhase)obj);
			}
		}
	}

	public List<PBXTargetDependency> getDependencies() {
		return dependencies;
	}

	public void setDependencies(List<Object> dependencies) {
		if(dependencies != null) {
			for(Object obj : dependencies) {
				this.dependencies.add((PBXTargetDependency)obj);
			}
		}
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
