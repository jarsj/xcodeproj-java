package com.jarsj;

import java.util.Map;

public class PBXBuildFile extends Element{
		
	/* The object is a reference to a PBXFileReference element. */
	//TODO - As per the http://www.monobjc.net/xcode-project-file-format.html : fileRef must be type of PBXFileReference but It is not the case
	private Element fileRef;
	
	/* A map of key/value pairs for additional settings. */
	private Map<String, Object> settings;

	public PBXBuildFile() {
		super("PBXBuildFile");
	}
	
	public Element getFileRef() {
		return fileRef;
	}

	public void setFileRef(Element fileRef) {
		this.fileRef = fileRef;
	}

	public Map<String, Object> getSettings() {
		return settings;
	}

	public void setSettings(Map<String, Object> settings) {
		this.settings = settings;
	}
	
}
