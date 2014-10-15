package com.jarsj;

import java.util.ArrayList;
import java.util.List;

public class PBXShellScriptBuildPhase extends PBXBuildPhase {

	/*The input paths.*/
	private List<String> inputPaths;
	
	/*The output paths.*/
	private List<String> outputPaths;
	
	/*The path to the shell interpreter.*/
	private String shellPath;
	
	/*The content of the script shell.*/
	private String shellScript;

	public PBXShellScriptBuildPhase() {
		super("PBXShellScriptBuildPhase");
		this.inputPaths = new ArrayList<String>();
		this.outputPaths = new ArrayList<String>();
		this.shellPath = "";
		this.shellScript = "";
	}
	
	public List<String> getInputPaths() {
		return inputPaths;
	}

	public void setInputPaths(List<Object> inputPaths) {
		if(inputPaths != null) {
			for(Object obj : inputPaths) {
				this.inputPaths.add((String)obj);
			}
		}
	}

	public List<String> getOutputPaths() {
		return outputPaths;
	}

	public void setOutputPaths(List<Object> outputPaths) {
		if(outputPaths != null) {
			for(Object obj : outputPaths) {
				this.outputPaths.add((String)obj);
			}
		}
	}

	public String getShellPath() {
		return shellPath;
	}

	public void setShellPath(String shellPath) {
		this.shellPath = shellPath;
	}

	public String getShellScript() {
		return shellScript;
	}

	public void setShellScript(String shellScript) {
		this.shellScript = shellScript;
	}
}
