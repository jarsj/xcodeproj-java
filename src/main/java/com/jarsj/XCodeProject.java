package com.jarsj;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import com.dd.plist.ASCIIPropertyListParser;
import com.dd.plist.NSDictionary;

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
 * http://www.monobjc.net/xcode-project-file-format.html explains the format in more detail.
 *  
 * @author harsh
 */
public class XCodeProject {
	private String name;
	
	private int archiveVersion;
	private PBXProject rootObject;
	private ArrayList<PBXBuildFile> buildFiles;
	private ArrayList<PBXFileReference> fileReferences;
	
	// The root folder
	private File root;
	
	
	/**
	 * Initialize with a folder. If folder is empty a new project is created with the name of the folder, else
	 * existing project inside the folder is loaded.
	 * 
	 * @param folder
	 * @throws ParseException 
	 * @throws IOException 
	 */
	public XCodeProject(File folder) throws IOException, ParseException {
		this.root = folder;
		this.buildFiles = new ArrayList<>();
		name = folder.getName();
		parse();
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
	
	private void parse() throws IOException, ParseException {
		NSDictionary rootNode = (NSDictionary) ASCIIPropertyListParser.parse(new File(root, name + ".xcodeproj/project.pbxproj"));
		System.out.println(rootNode.toXMLPropertyList());
		
	}
	
	public static void main(String[] args) throws IOException, ParseException {
		XCodeProject project = new XCodeProject(new File("/Users/harsh/xcodeproj-java/empty"));
	}
}
