package com.jarsj;

import java.util.Map;

public class PBXBuildFile extends Element{
		
	/* The object is a reference to a PBXFileReference element. */
	private PBXFileReference fileRef;
	
	/* A map of key/value pairs for additional settings. */
	private Map<String, Object> settings;

	public PBXFileReference getFileRef() {
		return fileRef;
	}

	public void setFileRef(PBXFileReference fileRef) {
		this.fileRef = fileRef;
	}

	public Map<String, Object> getSettings() {
		return settings;
	}

	public void setSettings(Map<String, Object> settings) {
		this.settings = settings;
	}
	
}
