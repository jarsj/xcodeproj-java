package com.jarsj;

public class PBXNativeTarget extends PBXTarget {
	
	/* The product install path. */
	private String productInstallPath;
	
	/* The object is a reference to a PBXFileReference element. */
	private PBXFileReference productReference;
	
	/* See the PBXProductType enumeration. */
	private String productType;
	
	public PBXNativeTarget() {
		super("PBXNativeTarget");
	}

	public String getProductInstallPath() {
		return productInstallPath;
	}

	public void setProductInstallPath(String productInstallPath) {
		this.productInstallPath = productInstallPath;
	}

	public PBXFileReference getProductReference() {
		return productReference;
	}

	public void setProductReference(PBXFileReference productReference) {
		this.productReference = productReference;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}	
}
