package com.jarsj;

public class PBXLegacyTarget extends PBXTarget {
	
	/*The build arguments string.*/
    private String buildArgumentsString;

    /*The build tool path.*/
    private String buildToolPath;

    /*The build working directory.*/
    private String buildWorkingDirectory;

    public PBXLegacyTarget() {
    	super("PBXLegacyTarget");
    }
    
    /*The pass build settings in environment.*/
    private int passBuildSettingsInEnvironment;

	public String getBuildArgumentsString() {
		return buildArgumentsString;
	}

	public void setBuildArgumentsString(String buildArgumentsString) {
		this.buildArgumentsString = buildArgumentsString;
	}

	public String getBuildToolPath() {
		return buildToolPath;
	}

	public void setBuildToolPath(String buildToolPath) {
		this.buildToolPath = buildToolPath;
	}

	public String getBuildWorkingDirectory() {
		return buildWorkingDirectory;
	}

	public void setBuildWorkingDirectory(String buildWorkingDirectory) {
		this.buildWorkingDirectory = buildWorkingDirectory;
	}

	public int getPassBuildSettingsInEnvironment() {
		return passBuildSettingsInEnvironment;
	}

	public void setPassBuildSettingsInEnvironment(Object passBuildSettingsInEnvironment) {
		if(passBuildSettingsInEnvironment != null) {
			this.passBuildSettingsInEnvironment =  (Integer)passBuildSettingsInEnvironment;
		}
	}
}
