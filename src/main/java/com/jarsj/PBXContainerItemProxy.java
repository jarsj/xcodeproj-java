package com.jarsj;

public class PBXContainerItemProxy extends Element {
	
	/*The object is a reference to a PBXProject element.*/
	private PBXProject containerPortal;
	
	private int proxyType;
	
	/*A unique reference ID.*/
	private PBXTarget remoteGlobalIDString;
	
	private String remoteInfo;

	public PBXProject getContainerPortal() {
		return containerPortal;
	}

	public void setContainerPortal(PBXProject containerPortal) {
		this.containerPortal = containerPortal;
	}

	public int getProxyType() {
		return proxyType;
	}

	public void setProxyType(int proxyType) {
		this.proxyType = proxyType;
	}

	public PBXTarget getRemoteGlobalIDString() {
		return remoteGlobalIDString;
	}

	public void setRemoteGlobalIDString(PBXTarget remoteGlobalIDString) {
		this.remoteGlobalIDString = remoteGlobalIDString;
	}

	public String getRemoteInfo() {
		return remoteInfo;
	}

	public void setRemoteInfo(String remoteInfo) {
		this.remoteInfo = remoteInfo;
	}
}
