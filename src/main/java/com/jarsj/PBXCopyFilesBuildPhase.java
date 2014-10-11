package com.jarsj;

public class PBXCopyFilesBuildPhase extends PBXBuildPhase {

	/*The destination path*/
	private String dstPath;
	
	private int dstSubfolderSpec;

	public String getDstPath() {
		return dstPath;
	}

	public void setDstPath(String dstPath) {
		this.dstPath = dstPath;
	}

	public int getDstSubfolderSpec() {
		return dstSubfolderSpec;
	}

	public void setDstSubfolderSpec(int dstSubfolderSpec) {
		this.dstSubfolderSpec = dstSubfolderSpec;
	}
}
