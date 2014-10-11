package com.jarsj;

public abstract class PBXFileElement extends Element {

	/*The filename.*/
	private String name;
	
	/*The PBXSourceTree enumeration.*/
	private String sourceTree;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSourceTree() {
		return sourceTree;
	}

	public void setSourceTree(String sourceTree) {
		this.sourceTree = sourceTree;
	}
}
