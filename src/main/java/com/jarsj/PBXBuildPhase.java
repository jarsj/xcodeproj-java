package com.jarsj;

import java.util.List;

public abstract class PBXBuildPhase extends Element {
	
	private int buildActionMask;
	
	/*The objects are a reference to a PBXBuildFile element.*/
	private List<PBXBuildFile> files;
	
	private int runOnlyForDeploymentPostprocessing;

	public int getBuildActionMask() {
		return buildActionMask;
	}

	public void setBuildActionMask(int buildActionMask) {
		this.buildActionMask = buildActionMask;
	}

	public List<PBXBuildFile> getFiles() {
		return files;
	}

	public void setFiles(List<PBXBuildFile> files) {
		this.files = files;
	}

	public int getRunOnlyForDeploymentPostprocessing() {
		return runOnlyForDeploymentPostprocessing;
	}

	public void setRunOnlyForDeploymentPostprocessing(
			int runOnlyForDeploymentPostprocessing) {
		this.runOnlyForDeploymentPostprocessing = runOnlyForDeploymentPostprocessing;
	}
}
