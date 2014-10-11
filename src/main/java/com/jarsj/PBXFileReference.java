package com.jarsj;


public class PBXFileReference extends PBXFileElement{

	/* The PBXFileEncoding enumeration. */
	private int fileEncoding;
	
	/* The PBXFileType enumeration. */
	private String explicitFileType;
	
	/* The PBXFileType enumeration. */
	private String lastKnownFileType;
	
	/* The path to the filename. */
	private String path;
	
	public int getFileEncoding() {
		return fileEncoding;
	}
	
	public void setFileEncoding(int fileEncoding) {
		
		this.fileEncoding = fileEncoding;
	}
	public String getExplicitFileType() {
		return explicitFileType;
	}
	
	public void setExplicitFileType(String explicitFileType) {
		this.explicitFileType = explicitFileType;
	}
	
	public String getLastKnownFileType() {
		return lastKnownFileType;
	}
	
	public void setLastKnownFileType(String lastKnownFileType) {
		this.lastKnownFileType = lastKnownFileType;
	}
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}		
}
