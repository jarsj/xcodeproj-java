package com.jarsj;

public class PBXTargetDependency extends Element {

	/* The object is a reference to a PBXNativeTarget element. */
	private PBXNativeTarget target;
	
	/* The object is a reference to a PBXContainerItemProxy element. */
	private PBXContainerItemProxy targetProxy;

	public PBXNativeTarget getTarget() {
		return target;
	}

	public void setTarget(PBXNativeTarget target) {
		this.target = target;
	}

	public PBXContainerItemProxy getTargetProxy() {
		return targetProxy;
	}

	public void setTargetProxy(PBXContainerItemProxy targetProxy) {
		this.targetProxy = targetProxy;
	}
}
