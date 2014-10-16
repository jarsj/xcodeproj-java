package com.jarsj;

import java.util.ArrayList;
import java.util.List;

public class PBXGroup extends PBXFileElement {

	/* The objects are a reference to a PBXFileElement element. */
	private List<PBXFileElement> children;
	
	public PBXGroup() {
		super("PBXGroup");
		this.children = new ArrayList<PBXFileElement>();
		this.setSourceTree("<group>");
	}
	
	public List<PBXFileElement> getChildren() {
		return children;
	}
	
	public void setChildren(List<Object> children) {
		if(children != null) {
			for(Object obj : children) {
				this.children.add((PBXFileElement)obj);
			}
		}
	}
	
	@Override
	public void setSourceTree(String sourceTree) {
		if(sourceTree != null) {
			super.setSourceTree(sourceTree);
		}
	}
}
