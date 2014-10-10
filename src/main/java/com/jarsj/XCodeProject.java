package com.jarsj;

import java.io.File;

/**
 * This class represents an entire XCodeProject. It's initialize using a root folder, whose structure is
 * as follows. 
 * 
 * root
 *  - root 
 *   - Header1.h
 *   - Header1.mm
 *   - folder1
 *    - file.png
 *    - file2.png
 * root.xcodeproj   
 *  - project.pbxproj [Important file]
 *  
 * The project.pbxproj file contains the entire structure, groups, frameworks, build settings etc.   
 *  
 * @author harsh
 */
public class XCodeProject {
	
	private File root;
	
	/**
	 * Initialize with a folder. If folder is empty a new project is created with the name of the folder, else
	 * existing project inside the folder is loaded.
	 * 
	 * @param folder
	 */
	public XCodeProject(File folder) {
		this.root = folder;
	}
	
	
	
	
	/**
	 * Return name of this project.
	 * 
	 * @return
	 */
	public String getName() {
		return null;
	}
	
	/**
	 * Change name of this project.
	 * 
	 * @param name
	 */
	public void setName(String name) {
		
	}
	
	public void save() {
		
	}
	
}
