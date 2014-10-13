package com.jarsj;

import java.util.List;

public class PBXVariantGroup extends PBXFileElement {

	/* The objects are a reference to a PBXFileElement element. */
	private List<PBXFileElement> children;

	public List<PBXFileElement> getChildren() {
		return children;
	}

	public void setChildren(List<PBXFileElement> children) {
		this.children = children;
	}
}
