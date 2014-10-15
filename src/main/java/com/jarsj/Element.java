package com.jarsj;

public class Element {

	private String reference;
	private String isa;
	
	protected Element(String isa) {
		this.isa = isa;
	}
	
	public String getReference() {
		return reference;
	}
	
	public void setReference(String reference) {
		this.reference = reference;
	}
	
	public String isA() {
		return isa;
	}
}
