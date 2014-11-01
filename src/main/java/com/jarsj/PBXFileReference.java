package com.jarsj;


public class PBXFileReference extends PBXFileElement {

	/* The PBXFileEncoding enumeration. */
	private long fileEncoding;
	
	/* The PBXFileType enumeration. */
	private String explicitFileType;
	
	/* The PBXFileType enumeration. */
	private String lastKnownFileType;
	
	public PBXFileReference() {
		super("PBXFileReference");
		this.fileEncoding = 0;
	}
	
	public long getFileEncoding() {
		return fileEncoding;
	}
	
	public void setFileEncoding(Object fileEncoding) {
		if(fileEncoding != null) {
			this.fileEncoding = Long.parseLong(String.valueOf(fileEncoding));
		}
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
}
