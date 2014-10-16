package com.jarsj;

import java.util.ArrayList;
import java.util.List;

public class PBXVariantGroup extends PBXFileElement {

	/* The objects are a reference to a PBXFileElement element. */
	private List<PBXFileElement> children;

	public PBXVariantGroup() {
		super("PBXVariantGroup");
		this.children = new ArrayList<PBXFileElement>();
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
}
