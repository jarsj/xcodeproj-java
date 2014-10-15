package com.jarsj;

import java.util.ArrayList;
import java.util.List;

public abstract class PBXBuildPhase extends Element {
	
	private int buildActionMask;
	
	/*The objects are a reference to a PBXBuildFile element.*/
	private List<PBXBuildFile> files;
	
	private int runOnlyForDeploymentPostprocessing;

	protected PBXBuildPhase(String isa) {
		super(isa);
		this.buildActionMask = Integer.MAX_VALUE;
		this.runOnlyForDeploymentPostprocessing = 0;
		this.files = new ArrayList<PBXBuildFile>();
	}
	
	public int getBuildActionMask() {
		return buildActionMask;
	}

	public void setBuildActionMask(Object buildActionMask) {
		if(buildActionMask != null) {
			this.buildActionMask = (Integer)buildActionMask;
		}		
	}

	public List<PBXBuildFile> getFiles() {
		return files;
	}

	public void setFiles(List<Object> files) {
		if(files != null) {
			for(Object obj : files) {
				this.files.add((PBXBuildFile)obj);
			}
		}
	}

	public int getRunOnlyForDeploymentPostprocessing() {
		return runOnlyForDeploymentPostprocessing;
	}

	public void setRunOnlyForDeploymentPostprocessing(
			Object runOnlyForDeploymentPostprocessing) {
		if(runOnlyForDeploymentPostprocessing != null) {
			this.runOnlyForDeploymentPostprocessing = (Integer)runOnlyForDeploymentPostprocessing;
		}
	}
}
