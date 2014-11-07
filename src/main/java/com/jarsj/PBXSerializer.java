package com.jarsj;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.dd.plist.NSArray;
import com.dd.plist.NSDictionary;
import com.dd.plist.NSObject;

public class PBXSerializer {

	private PBXDocument document;
	private NSDictionary dict;
	private Map<String, NSDictionary> parsedObjects;

	public PBXSerializer(PBXDocument document) throws Exception {
		this.document = document;
		this.dict = new NSDictionary();
		this.parsedObjects = new HashMap<String, NSDictionary>();
		parse();
	}

	public NSDictionary getDictionary() {
		return this.dict;
	}

	private void parse() throws Exception {
		tryPut(this.dict, "archiveVersion", parseToNSObject(this.document.getArchiveVersion(), true));
		tryPut(this.dict, "objectVersion", parseToNSObject(this.document.getObjectVersion(), true));
		tryPut(this.dict, "classes", parseToNSDictionary(this.document.getClasses(), false));
		tryPut(this.dict, "rootObject", parseToNSObject(this.document.getRootObject().getReference(), true));
		tryPut(this.dict, "objects", parseToNSDictionary(this.document.getObjects(), false));
	}

	private NSDictionary parsePBXDocument(Element element) throws Exception {
		if(this.parsedObjects.containsKey(element.getReference())) {
			return this.parsedObjects.get(element.getReference());
		}
		String isA = element.isA();
		if (isA != null) {
			switch (isA) {
			case "PBXBuildFile":
				return processPBXBuildFile((PBXBuildFile) element);

			case "PBXContainerItemProxy":
				return processPBXContainerItemProxy((PBXContainerItemProxy) element);

			case "PBXFileReference":
				return processPBXFileReference((PBXFileReference) element);

			case "PBXFrameworksBuildPhase":
				return processPBXFrameworksBuildPhase((PBXFrameworksBuildPhase) element);

			case "PBXGroup":
				return processPBXGroup((PBXGroup) element);

			case "PBXNativeTarget":
				return processPBXNativeTarget((PBXNativeTarget) element);

			case "PBXProject":// attributes missing
				return processPBXProject((PBXProject) element);

			case "PBXResourcesBuildPhase":
				return processPBXResourcesBuildPhase((PBXResourcesBuildPhase) element);

			case "PBXSourcesBuildPhase":
				return processPBXSourcesBuildPhase((PBXSourcesBuildPhase) element);

			case "PBXTargetDependency":
				return processPBXTargetDependency((PBXTargetDependency) element);

			case "PBXVariantGroup":
				return processPBXVariantGroup((PBXVariantGroup) element);

			case "XCBuildConfiguration":
				return processXCBuildConfiguration((XCBuildConfiguration) element);

			case "XCConfigurationList":
				return processXCConfigurationList((XCConfigurationList) element);

			case "PBXCopyFilesBuildPhase":
				return processPBXCopyFilesBuildPhase((PBXCopyFilesBuildPhase) element);

			case "PBXHeadersBuildPhase":
				return processPBXHeadersBuildPhase((PBXHeadersBuildPhase) element);

			case "PBXLegacyTarget":
				return processPBXLegacyTarget((PBXLegacyTarget) element);

			case "PBXShellScriptBuildPhase":
				return processPBXShellScriptBuildPhase((PBXShellScriptBuildPhase) element);

			default:
				return new NSDictionary();
			}
		}
		return new NSDictionary();
	}

	private NSDictionary processPBXShellScriptBuildPhase(PBXShellScriptBuildPhase element) throws Exception {
		NSDictionary subDict = new NSDictionary();
		tryPut(subDict, "isa", parseToNSObject(element.isA(), true));
		tryPut(subDict, "files", parseToNSArray(element.getFiles()));
		tryPut(subDict, "inputPaths", parseToNSArray(element.getInputPaths()));
		tryPut(subDict, "outputPaths", parseToNSArray(element.getOutputPaths()));
		tryPut(subDict, "buildActionMask", parseToNSObject(element.getBuildActionMask(), true));
		tryPut(subDict, "runOnlyForDeploymentPostprocessing", parseToNSObject(element.getRunOnlyForDeploymentPostprocessing(), true));
		tryPut(subDict, "shellPath", parseToNSObject(element.getShellPath(), true));
		tryPut(subDict, "shellScript", parseToNSObject(element.getShellScript(), true));
		parsedObjects.put(element.getReference(), subDict);
		return subDict;
	}

	private NSDictionary processPBXLegacyTarget(PBXLegacyTarget element) throws Exception {
		NSDictionary subDict = new NSDictionary();
		tryPut(subDict, "isa", parseToNSObject(element.isA(), true));
		tryPut(subDict, "buildPhases", parseToNSArray(element.getBuildPhases()));
		tryPut(subDict, "buildArgumentsString", parseToNSObject(element.getBuildArgumentsString(), true));
		tryPut(subDict, "buildConfigurationList", parseToNSObject(element.getBuildConfigurationList().getReference(), true));
		tryPut(subDict, "buildToolPath", parseToNSObject(element.getBuildToolPath(), true));
		tryPut(subDict, "buildWorkingDirectory", parseToNSObject(element.getBuildWorkingDirectory(), true));
		tryPut(subDict, "dependencies", parseToNSArray(element.getDependencies()));
		tryPut(subDict, "name", parseToNSObject(element.getName(), true));
		tryPut(subDict, "passBuildSettingsInEnvironment", parseToNSObject(element.getPassBuildSettingsInEnvironment(), true));
		tryPut(subDict, "productName", parseToNSObject(element.getProductName(), true));
		parsedObjects.put(element.getReference(), subDict);
		return subDict;
	}

	private NSDictionary processPBXHeadersBuildPhase(PBXHeadersBuildPhase element) throws Exception {
		NSDictionary subDict = new NSDictionary();
		tryPut(subDict, "isa", parseToNSObject(element.isA(), true));
		tryPut(subDict, "files", parseToNSArray(element.getFiles()));
		tryPut(subDict, "buildActionMask", parseToNSObject(element.getBuildActionMask(), true));
		tryPut(subDict, "runOnlyForDeploymentPostprocessing", parseToNSObject(element.getRunOnlyForDeploymentPostprocessing(), true));
		parsedObjects.put(element.getReference(), subDict);
		return subDict;
	}

	private NSDictionary processPBXCopyFilesBuildPhase(PBXCopyFilesBuildPhase element) throws Exception {
		NSDictionary subDict = new NSDictionary();
		tryPut(subDict, "isa", parseToNSObject(element.isA(), true));
		tryPut(subDict, "buildActionMask", parseToNSObject(element.getBuildActionMask(), true));
		tryPut(subDict, "dstPath", parseToNSObject(element.getDstPath(), true));
		tryPut(subDict, "dstSubfolderSpec", parseToNSObject(element.getDstSubfolderSpec(), true));
		tryPut(subDict, "files", parseToNSArray(element.getFiles()));
		tryPut(subDict, "runOnlyForDeploymentPostprocessing", parseToNSObject(element.getRunOnlyForDeploymentPostprocessing(), true));
		parsedObjects.put(element.getReference(), subDict);
		return subDict;
	}

	private NSDictionary processXCConfigurationList(XCConfigurationList element) throws Exception {
		NSDictionary subDict = new NSDictionary();
		tryPut(subDict, "isa", parseToNSObject(element.isA(), true));
		tryPut(subDict, "buildConfigurations", parseToNSArray(element.getBuildConfigurations()));
		tryPut(subDict, "defaultConfigurationIsVisible", parseToNSObject(element.getDefaultConfigurationIsVisible(), true));
		tryPut(subDict, "defaultConfigurationName", parseToNSObject(element.getDefaultConfigurationName(), true));
		parsedObjects.put(element.getReference(), subDict);
		return subDict;
	}

	private NSDictionary processXCBuildConfiguration(XCBuildConfiguration element) throws Exception {
		NSDictionary subDict = new NSDictionary();
		tryPut(subDict, "isa", parseToNSObject(element.isA(), true));
		tryPut(subDict, "baseConfigurationReference", parseToNSObject(element.getBaseConfigurationReference(), true));
		tryPut(subDict, "buildSettings", parseToNSDictionary(element.getBuildSettings(), true));
		tryPut(subDict, "name", parseToNSObject(element.getName(), true));
		parsedObjects.put(element.getReference(), subDict);
		return subDict;
	}

	private NSDictionary processPBXVariantGroup(PBXVariantGroup element) throws Exception {
		NSDictionary subDict = new NSDictionary();
		tryPut(subDict, "isa", parseToNSObject(element.isA(), true));
		tryPut(subDict, "children", parseToNSArray(element.getChildren()));
		tryPut(subDict, "name", parseToNSObject(element.getName(), true));
		tryPut(subDict, "path", parseToNSObject(element.getPath(), true));
		tryPut(subDict, "sourceTree", parseToNSObject(element.getSourceTree(), true));
		parsedObjects.put(element.getReference(), subDict);
		return subDict;
	}

	private NSDictionary processPBXTargetDependency(PBXTargetDependency element) throws Exception {
		NSDictionary subDict = new NSDictionary();
		tryPut(subDict, "isa", parseToNSObject(element.isA(), true));
		tryPut(subDict, "target", parseToNSObject(element.getTarget().getReference(), true));
		tryPut(subDict, "targetProxy", parseToNSObject(element.getTargetProxy().getReference(), true));
		parsedObjects.put(element.getReference(), subDict);
		return subDict;
	}

	private NSDictionary processPBXSourcesBuildPhase(PBXSourcesBuildPhase element) throws Exception {
		NSDictionary subDict = new NSDictionary();
		tryPut(subDict, "isa", parseToNSObject(element.isA(), true));
		tryPut(subDict, "buildActionMask", parseToNSObject(element.getBuildActionMask(), true));
		tryPut(subDict, "files", parseToNSArray(element.getFiles()));
		tryPut(subDict, "runOnlyForDeploymentPostprocessing", parseToNSObject(element.getRunOnlyForDeploymentPostprocessing(), true));
		parsedObjects.put(element.getReference(), subDict);
		return subDict;
	}

	private NSDictionary processPBXResourcesBuildPhase(PBXResourcesBuildPhase element) throws Exception {
		NSDictionary subDict = new NSDictionary();
		tryPut(subDict, "isa", parseToNSObject(element.isA(), true));
		tryPut(subDict, "buildActionMask", parseToNSObject(element.getBuildActionMask(), true));
		tryPut(subDict, "files", parseToNSArray(element.getFiles()));
		tryPut(subDict, "runOnlyForDeploymentPostprocessing", parseToNSObject(element.getRunOnlyForDeploymentPostprocessing(), true));
		parsedObjects.put(element.getReference(), subDict);
		return subDict;
	}

	private NSDictionary processPBXProject(PBXProject element) throws Exception {
		NSDictionary subDict = new NSDictionary();
		tryPut(subDict, "isa", parseToNSObject(element.isA(), true));
		tryPut(subDict, "buildConfigurationList", parseToNSObject(element.getBuildConfigurationList().getReference(), true));
		tryPut(subDict, "compatibilityVersion", parseToNSObject(element.getCompatibilityVersion(), true));
		tryPut(subDict, "developmentRegion", parseToNSObject(element.getDevelopmentRegion(), true));
		tryPut(subDict, "hasScannedForEncodings", parseToNSObject(element.getHasScannedForEncodings(), true));
		tryPut(subDict, "productInstallPath", parseToNSArray(element.getKnownRegions()));
		tryPut(subDict, "mainGroup", parseToNSObject(element.getMainGroup().getReference(), true));
		tryPut(subDict, "productRefGroup", parseToNSObject(element.getProductRefGroup().getReference(), true));
		tryPut(subDict, "projectDirPath", parseToNSObject(element.getProjectDirPath(), true));
		tryPut(subDict, "projectReferences", parseToNSArray(element.getProjectReferences()));
		tryPut(subDict, "projectRoot", parseToNSObject(element.getProjectRoot(), true));
		tryPut(subDict, "targets", parseToNSArray(element.getTargets()));
		parsedObjects.put(element.getReference(), subDict);
		return subDict;
	}

	private NSDictionary processPBXNativeTarget(PBXNativeTarget element) throws Exception {
		NSDictionary subDict = new NSDictionary();
		tryPut(subDict, "isa", parseToNSObject(element.isA(), true));
		tryPut(subDict, "name", parseToNSObject(element.getName(), true));
		tryPut(subDict, "buildConfigurationList", parseToNSObject(element.getBuildConfigurationList().getReference(), true));
		tryPut(subDict, "buildPhases", parseToNSArray(element.getBuildPhases()));
		tryPut(subDict, "dependencies", parseToNSArray(element.getDependencies()));
		tryPut(subDict, "productInstallPath", parseToNSObject(element.getProductInstallPath(), true));
		tryPut(subDict, "productName", parseToNSObject(element.getProductName(), true));
		tryPut(subDict, "productReference", parseToNSObject(element.getProductReference().getReference(), true));
		tryPut(subDict, "productType", parseToNSObject(element.getProductType(), true));
		parsedObjects.put(element.getReference(), subDict);
		return subDict;
	}

	private NSDictionary processPBXGroup(PBXGroup element) throws Exception {
		NSDictionary subDict = new NSDictionary();
		tryPut(subDict, "isa", parseToNSObject(element.isA(), true));
		tryPut(subDict, "name", parseToNSObject(element.getName(), true));
		tryPut(subDict, "children", parseToNSArray(element.getChildren()));
		tryPut(subDict, "path", parseToNSObject(element.getPath(), true));
		tryPut(subDict, "sourceTree", parseToNSObject(element.getSourceTree(), true));
		parsedObjects.put(element.getReference(), subDict);
		return subDict;
	}

	private NSDictionary processPBXFrameworksBuildPhase(PBXFrameworksBuildPhase element) throws Exception {
		NSDictionary subDict = new NSDictionary();
		tryPut(subDict, "isa", parseToNSObject(element.isA(), true));
		tryPut(subDict, "buildActionMask", parseToNSObject(element.getBuildActionMask(), true));
		tryPut(subDict, "files", parseToNSArray(element.getFiles()));
		tryPut(subDict, "runOnlyForDeploymentPostprocessing", parseToNSObject(element.getRunOnlyForDeploymentPostprocessing(), true));
		parsedObjects.put(element.getReference(), subDict);
		return subDict;
	}

	private NSDictionary processPBXFileReference(PBXFileReference element) throws Exception {
		NSDictionary subDict = new NSDictionary();
		tryPut(subDict, "isa", parseToNSObject(element.isA(), true));
		tryPut(subDict, "fileEncoding", parseToNSObject(element.getFileEncoding(), true));
		tryPut(subDict, "explicitFileType", parseToNSObject(element.getExplicitFileType(), true));
		tryPut(subDict, "lastKnownFileType", parseToNSObject(element.getLastKnownFileType(), true));
		tryPut(subDict, "name", parseToNSObject(element.getName(), true));
		tryPut(subDict, "path", parseToNSObject(element.getPath(), true));
		tryPut(subDict, "sourceTree", parseToNSObject(element.getSourceTree(), true));
		parsedObjects.put(element.getReference(), subDict);
		return subDict;
	}

	private NSDictionary processPBXContainerItemProxy(PBXContainerItemProxy element) throws Exception {
		NSDictionary subDict = new NSDictionary();
		tryPut(subDict, "isa", parseToNSObject(element.isA(), true));
		tryPut(subDict, "containerPortal", parseToNSObject(element.getContainerPortal().getReference(), true));
		tryPut(subDict, "proxyType", parseToNSObject(element.getProxyType(), true));
		tryPut(subDict, "remoteGlobalIDString", parseToNSObject(element.getRemoteGlobalIDString().getReference(), true));
		tryPut(subDict, "remoteInfo", parseToNSObject(element.getRemoteInfo(), true));
		parsedObjects.put(element.getReference(), subDict);
		return subDict;
	}

	private NSDictionary processPBXBuildFile(PBXBuildFile element) throws Exception {
		NSDictionary subDict = new NSDictionary();
		tryPut(subDict, "isa", parseToNSObject(element.isA(), true));
		tryPut(subDict, "fileRef", parseToNSObject(element.getFileRef(), true));
		tryPut(subDict, "settings", null);//parseToNSDictionary(element.getSettings(), true));
		parsedObjects.put(element.getReference(), subDict);
		return subDict;
	}

	@SuppressWarnings("rawtypes")
	private NSObject parseToNSObject(Object object, boolean refOnly) throws Exception {
		if (object instanceof Map) {
			return parseToNSDictionary((Map) object, true);
		} else if (object instanceof List) {
			return parseToNSArray((List) object);
		} else if (object instanceof Element) {
			if (refOnly) {
				return NSObject.wrap(((Element) object).getReference());
			}
			return parsePBXDocument((Element) object);
		} else if (object != null) {
			return NSObject.wrap(object);
		}
		return null;
	}

	@SuppressWarnings({ "rawtypes" })
	private NSDictionary parseToNSDictionary(Map map, boolean refObly) throws Exception {		
		if (map != null) {
			NSDictionary nsDict = new NSDictionary();
			Iterator iterator = map.keySet().iterator();
			while (iterator.hasNext()) {
				String key = (String) iterator.next();
				nsDict.put(key, parseToNSObject(map.get(key), refObly));
			}
			return nsDict;
		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	private NSArray parseToNSArray(List objects) throws Exception {
		if (objects != null) {
			NSArray outputList = new NSArray(objects.size());
			for (int i = 0; i < objects.size(); i++) {
				outputList.setValue(i, parseToNSObject(objects.get(i), true));
			}
			return outputList;
		}
		return null;
	}
	
	private void tryPut(NSDictionary dict, String key, NSObject value) throws Exception {
		if(value != null) {
			dict.put(key, value);
		}
	}
}
