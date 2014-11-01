package com.jarsj;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PBXProject extends Element {

	/* The object is a reference to a XCConfigurationList element. */
	private XCConfigurationList buildConfigurationList;
	
	/* A string representation of the XcodeCompatibilityVersion. */
	private String compatibilityVersion;
	
	/* The region of development. */
	private String developmentRegion;
	
	/* Whether file encodings have been scanned. */
	private int hasScannedForEncodings;
	
	/* The known regions for localized files. */
	private List<String> knownRegions;
	
	/* The object is a reference to a PBXGroup element. */
	private PBXGroup mainGroup;
	
	/* The object is a reference to a PBXGroup element. */
	private PBXGroup productRefGroup;
	
	/* The relative path of the project. */
	private String projectDirPath;
	
	/* Each map in the array contains two keys: ProductGroup and ProjectRef. */
	private List<Map<String, Element>> projectReferences;
	
	/* The relative root path of the project. */
	private String projectRoot;
	
	/* The objects are a reference to a PBXTarget element. */
	private List<PBXTarget> targets;

	public PBXProject() {
		super("PBXProject");
        this.buildConfigurationList = new XCConfigurationList();
        this.compatibilityVersion = "Xcode 3.2";
        this.developmentRegion = "English";
        this.hasScannedForEncodings = 1;
        this.knownRegions = new ArrayList<String>();
        this.knownRegions.add("en");
        this.mainGroup = new PBXGroup();
        this.projectDirPath = "";
        this.projectReferences = new ArrayList<Map<String, Element>>();
        this.projectRoot = "";
        this.targets = new ArrayList<PBXTarget>();
    }
	
	public XCConfigurationList getBuildConfigurationList() {
		return buildConfigurationList;
	}

	public void setBuildConfigurationList(XCConfigurationList buildConfigurationList) {
		this.buildConfigurationList = buildConfigurationList;
	}

	public String getCompatibilityVersion() {
		return compatibilityVersion;
	}

	public void setCompatibilityVersion(String compatibilityVersion) {
		if(compatibilityVersion != null) {
			this.compatibilityVersion = compatibilityVersion;
		}
	}

	public String getDevelopmentRegion() {
		return developmentRegion;
	}

	public void setDevelopmentRegion(String developmentRegion) {
		this.developmentRegion = developmentRegion;
	}

	public int getHasScannedForEncodings() {
		return hasScannedForEncodings;
	}

	public void setHasScannedForEncodings(Object hasScannedForEncodings) {
		if(hasScannedForEncodings != null) {
			this.hasScannedForEncodings = (Integer) hasScannedForEncodings;
		}
	}

	public List<String> getKnownRegions() {
		return knownRegions;
	}

	public void setKnownRegions(List<Object> knownRegions) {
		if(knownRegions != null) {
			for(Object obj : knownRegions) {
				this.knownRegions.add((String)obj);
			}
		}
	}

	public PBXGroup getMainGroup() {
		return mainGroup;
	}

	public void setMainGroup(PBXGroup mainGroup) {
		this.mainGroup = mainGroup;
	}

	public PBXGroup getProductRefGroup() {
		return productRefGroup;
	}

	public void setProductRefGroup(PBXGroup productRefGroup) {
		this.productRefGroup = productRefGroup;
	}

	public String getProjectDirPath() {
		return projectDirPath;
	}

	public void setProjectDirPath(String projectDirPath) {
		this.projectDirPath = projectDirPath;
	}

	public List<Map<String, Element>> getProjectReferences() {
		return projectReferences;
	}

	public void setProjectReferences(List<Object> projectReferences) {
		if(projectReferences != null) {
			for(Object obj : projectReferences) {
				if(obj instanceof Map) {
					this.projectReferences.add(PBXParser.toElementMap((Map<String, Object>)obj));
				}
			}
		}
	}

	public String getProjectRoot() {
		return projectRoot;
	}

	public void setProjectRoot(String projectRoot) {
		this.projectRoot = projectRoot;
	}

	public List<PBXTarget> getTargets() {
		return targets;
	}

	public void setTargets(List<Object> targets) {
		if(targets != null) {
			for(Object target : targets) {
				this.targets.add((PBXTarget)target);
			}
		}
	}
}
