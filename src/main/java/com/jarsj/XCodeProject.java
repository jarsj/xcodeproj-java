package com.jarsj;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.dd.plist.ASCIIPropertyListParser;
import com.dd.plist.NSArray;
import com.dd.plist.NSDictionary;
import com.dd.plist.NSNumber;
import com.dd.plist.NSObject;
import com.dd.plist.NSString;

/**
 * This class represents an entire XCodeProject. It's initialize using a root
 * folder, whose structure is as follows.
 * 
 * root - root - Header1.h - Header1.mm - folder1 - file.png - file2.png
 * root.xcodeproj - project.pbxproj [Important file]
 * 
 * The project.pbxproj file contains the entire structure, groups, frameworks,
 * build settings etc. http://www.monobjc.net/xcode-project-file-format.html
 * explains the format in more detail.
 * 
 * @author harsh
 */
public class XCodeProject {
	private String name;

	// The root folder
	private File root;
	private File xcodeProjFolder;
	private PBXDocument document;

	/**
	 * Initialize with a folder. If folder is empty a new project is created
	 * with the name of the folder, else existing project inside the folder is
	 * loaded.
	 * 
	 * @param folder
	 * @throws ParseException
	 * @throws IOException
	 */
	public XCodeProject(File folder) throws Exception {
		this.root = folder;
		for (File f : folder.listFiles()) {
			if (f.isDirectory() && f.getName().endsWith(".xcodeproj")) {
				xcodeProjFolder = f;
			}
		}
		if (xcodeProjFolder == null)
			throw new IllegalArgumentException(
					"The folder is not a xcode project");
		name = xcodeProjFolder.getName().replace(".xcodeproj", "");
		document = new PBXParser(new File(xcodeProjFolder, "project.pbxproj"))
				.getDocument();
	}

	/**
	 * Return name of this project.
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Change name of this project.
	 * 
	 * @param name
	 * @throws IOException 
	 */
	public void setName(String name) throws IOException {
		FileUtils.moveDirectory(xcodeProjFolder, new File(root, name + ".xcodeproj"));
		this.name = name;
	}
	
	public void save() {
		
	}

	private static void expand(PBXGroup grp, String indent) {
		System.out.println(indent + grp.getName() + ":" + grp.getPath());
		for (PBXFileElement child : grp.getChildren()) {
			if (child instanceof PBXFileReference) {
				PBXFileReference file = (PBXFileReference) child;
				System.out.println(indent + "  " + file.getName() + ":"
						+ file.getPath());
			}
			if (child instanceof PBXGroup) {
				expand((PBXGroup) child, indent + "  ");
			}
		}
	}

	public static void main(String[] args) throws Exception {
		XCodeProject project = new XCodeProject(new File(
				"/Users/harsh/xcodeproj-java/empty"));
		PBXDocument document = project.getDocument();
		
	}

	public PBXDocument getDocument() {
		return document;
	}
}
