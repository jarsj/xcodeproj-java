package com.jarsj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PBXDocument {

	private int archiveVersion;	
	
	private List<Element> classes;
	
	/* XcodeCompatibilityVersion enumeration. */
	private int objectVersion;
	
	/* The map is indexed by the elements identifier. */
	private Map<String, Element> objects;
	
	/* The object is a reference to a PBXProject element. */
	private PBXProject rootObject;
	
	public PBXDocument() {
		this.classes = new ArrayList<Element>();
		this.objects = new HashMap<String, Element>();
		this.archiveVersion = 1;
		this.objectVersion = 46;
	}
	
	public int getArchiveVersion() {
		return archiveVersion;
	}

	public void setArchiveVersion(Object archiveVersion) {
		if(archiveVersion != null) {
			this.archiveVersion = (Integer) archiveVersion;
		}
	}

	public List<Element> getClasses() {
		return classes;
	}

	public void setClasses(List<Element> classes) {
		this.classes = classes;
	}

	public int getObjectVersion() {
		return objectVersion;
	}

	public void setObjectVersion(Object objectVersion) {
		if(objectVersion != null) {
			this.objectVersion = (Integer) objectVersion;
		}
	}

	public Map<String, Element> getObjects() {
		return objects;
	}

	public void setObjects(Map<String, Element> objects) {
		this.objects = objects;
	}

	public PBXProject getRootObject() {
		return rootObject;
	}

	public void setRootObject(PBXProject rootObject) {
		this.rootObject = rootObject;
	}
}
