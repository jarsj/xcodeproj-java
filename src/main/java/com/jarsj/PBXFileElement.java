package com.jarsj;

public abstract class PBXFileElement extends Element {

	/*The filename.*/
	private String name;
	
	/*The path*/
	private String path;
	
	/*The PBXSourceTree enumeration.*/
	private String sourceTree;
	
	protected PBXFileElement(String isa) {
		super(isa);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public String getPath() {
		return path;
	}

	public String getSourceTree() {
		return sourceTree;
	}

	public void setSourceTree(String sourceTree) {
		this.sourceTree = sourceTree;
	}
	
}
