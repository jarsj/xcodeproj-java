package com.jarsj;

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

	public List<String> getInputPaths() {
		return inputPaths;
	}

	public void setInputPaths(List<String> inputPaths) {
		this.inputPaths = inputPaths;
	}

	public List<String> getOutputPaths() {
		return outputPaths;
	}

	public void setOutputPaths(List<String> outputPaths) {
		this.outputPaths = outputPaths;
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
