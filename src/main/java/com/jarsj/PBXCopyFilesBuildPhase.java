package com.jarsj;

public class PBXCopyFilesBuildPhase extends PBXBuildPhase {

	/*The destination path*/
	private String dstPath;
	
	private int dstSubfolderSpec;

	public PBXCopyFilesBuildPhase() {
		super("PBXCopyFilesBuildPhase");
		this.dstPath = "";
		this.dstSubfolderSpec = 16;
	}
	
	public String getDstPath() {
		return dstPath;
	}

	public void setDstPath(String dstPath) {
		this.dstPath = dstPath;
	}

	public int getDstSubfolderSpec() {
		return dstSubfolderSpec;
	}

	public void setDstSubfolderSpec(Object dstSubfolderSpec) {
		if(dstSubfolderSpec != null) {
			this.dstSubfolderSpec = (Integer) dstSubfolderSpec;
		}	
	}
}
