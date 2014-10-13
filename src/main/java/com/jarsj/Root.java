package com.jarsj;

import java.util.List;
import java.util.Map;

public class Root {

	private int archiveVersion = 1;	
	
	private List<Element> classes;
	
	/* XcodeCompatibilityVersion enumeration. */
	private int objectVersion;
	
	/* The map is indexed by the elements identifier. */
	private Map<String, Element> objects;
	
	/* The object is a reference to a PBXProject element. */
	private PBXProject rootObject;

	public int getArchiveVersion() {
		return archiveVersion;
	}

	public void setArchiveVersion(int archiveVersion) {
		this.archiveVersion = archiveVersion;
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

	public void setObjectVersion(int objectVersion) {
		this.objectVersion = objectVersion;
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
