package com.jarsj;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.dd.plist.ASCIIPropertyListParser;
import com.dd.plist.NSArray;
import com.dd.plist.NSDictionary;
import com.dd.plist.NSNumber;
import com.dd.plist.NSObject;
import com.dd.plist.NSString;

public class PBXParser {

	// To have a all elements in single Map
	private Map<String, Object> parsedObjects;
	private Map<String, Object> parseInProgressObjects;

	private NSDictionary dict;
	private PBXDocument document;
	private File pbxProjFile;

	public PBXParser(File pbxProjFile) throws Exception {
		this.pbxProjFile = pbxProjFile;
		this.parsedObjects = new HashMap<String, Object>();
		this.parseInProgressObjects = new HashMap<String, Object>();
		this.document = new PBXDocument();
		parse();
	}

	private void parse() throws Exception {
		this.dict = (NSDictionary) ASCIIPropertyListParser.parse(pbxProjFile);
		this.document.setArchiveVersion(parseToJavaObject(dict
				.get("archiveVersion")));
		this.document.setObjectVersion(parseToJavaObject(dict
				.get("objectVersion")));
		this.document.setClasses(toElementMap(parseToMap((NSDictionary) dict
				.get("classes"))));
		this.document.setRootObject((PBXProject) parseObject(
				(String) parseToJavaObject(dict.get("rootObject")),
				(NSDictionary) dict.get("objects")));
		this.document.setObjects(toElementMap(parseToMap((NSDictionary) dict
				.get("objects"))));
	}

	private Object parseObject(String key, NSDictionary nsdict)
			throws Exception {
		NSObject nsObj = nsdict.get(key);
		if (nsObj != null) {
			if (nsObj instanceof NSDictionary) {
				if (parsedObjects.containsKey(key)) {
					return parsedObjects.get(key);
				}
				NSDictionary eleDict = (NSDictionary) nsObj;
				String isA = (String) eleDict.get("isa").toJavaObject();
				if (isA != null) {
					switch (isA) {
					case "PBXBuildFile":
						return processPBXBuildFile(key, nsdict);

					case "PBXContainerItemProxy":
						return processPBXContainerItemProxy(key, nsdict);

					case "PBXFileReference":
						return processPBXFileReference(key, nsdict);

					case "PBXFrameworksBuildPhase":
						return processPBXFrameworksBuildPhase(key, nsdict);

					case "PBXGroup":
						return processPBXGroup(key, nsdict);

					case "PBXNativeTarget":
						return processPBXNativeTarget(key, nsdict);

					case "PBXProject":// attributes missing
						return processPBXProject(key, nsdict);

					case "PBXResourcesBuildPhase":
						return processPBXResourcesBuildPhase(key, nsdict);

					case "PBXSourcesBuildPhase":
						return processPBXSourceBuildPhase(key, nsdict);

					case "PBXTargetDependency":
						return processPBXTargetDependency(key, nsdict);

					case "PBXVariantGroup":
						return processPBXVariantGroup(key, nsdict);

					case "XCBuildConfiguration":
						return processXCBuildConfiguration(key, nsdict);

					case "XCConfigurationList":
						return processXCConfigurationList(key, nsdict);

					case "PBXCopyFilesBuildPhase":
						return processPBXCopyFilesBuildPhase(key, nsdict);

					case "PBXHeadersBuildPhase":
						return processPBXHeadersBuildPhase(key, nsdict);

					case "PBXLegacyTarget":
						return processPBXLegacyTarget(key, nsdict);

					case "PBXShellScriptBuildPhase":
						return processPBXShellScriptBuildPhase(key, nsdict);

					default:
						return null;
					}
				} else {
					return parseToMap(eleDict);
				}
			} else if (nsObj instanceof NSArray) {
				return parseToList((NSArray) nsObj);
			} else if (nsObj instanceof NSNumber) {
				return nsObj.toJavaObject();
			} else if (nsObj instanceof NSString) {
				return nsObj.toJavaObject();
			}
		}
		return null;
	}

	private PBXFileReference processPBXFileReference(String key,
			NSDictionary nsdict) throws Exception {
		NSDictionary eleDict = (NSDictionary) nsdict.get(key);
		PBXFileReference fileReference = (PBXFileReference) parseInProgressObjects
				.get(key);
		if (fileReference == null) {
			fileReference = new PBXFileReference();
			parseInProgressObjects.put(key, fileReference);
		}
		fileReference.setExplicitFileType((String) parseToJavaObject(eleDict
				.get("explicitFileType")));
		fileReference.setFileEncoding(parseToJavaObject(eleDict
				.get("fileEncoding")));
		fileReference.setLastKnownFileType((String) parseToJavaObject(eleDict
				.get("lastKnownFileType")));
		fileReference.setName((String) parseToJavaObject(eleDict.get("name")));
		fileReference.setPath((String) parseToJavaObject(eleDict.get("path")));
		fileReference.setReference(key);
		fileReference.setSourceTree((String) parseToJavaObject(eleDict
				.get("sourceTree")));
		parsedObjects.put(key, fileReference);
		parseInProgressObjects.remove(key);
		return fileReference;
	}

	private PBXFrameworksBuildPhase processPBXFrameworksBuildPhase(String key,
			NSDictionary nsdict) throws Exception {
		NSDictionary eleDict = (NSDictionary) nsdict.get(key);
		PBXFrameworksBuildPhase frameworksBuildPhase = (PBXFrameworksBuildPhase) parseInProgressObjects
				.get(key);
		if (frameworksBuildPhase == null) {
			frameworksBuildPhase = new PBXFrameworksBuildPhase();
			parseInProgressObjects.put(key, frameworksBuildPhase);
		}
		frameworksBuildPhase.setBuildActionMask(parseToJavaObject(eleDict
				.get("buildActionMask")));
		frameworksBuildPhase.setFiles(parseToList((NSArray) eleDict
				.get("files")));
		frameworksBuildPhase.setReference(key);
		frameworksBuildPhase
				.setRunOnlyForDeploymentPostprocessing(parseToJavaObject(eleDict
						.get("runOnlyForDeploymentPostprocessing")));
		parsedObjects.put(key, frameworksBuildPhase);
		parseInProgressObjects.remove(key);
		return frameworksBuildPhase;
	}

	private PBXGroup processPBXGroup(String key, NSDictionary nsdict)
			throws Exception {
		NSDictionary eleDict = (NSDictionary) nsdict.get(key);
		PBXGroup group = (PBXGroup) parseInProgressObjects.get(key);
		if (group == null) {
			group = new PBXGroup();
			parseInProgressObjects.put(key, group);
		}
		group.setChildren(parseToList((NSArray) eleDict.get("children")));
		group.setName((String) parseToJavaObject(eleDict.get("name")));
		group.setPath((String) parseToJavaObject(eleDict.get("path")));
		group.setReference(key);
		group.setSourceTree((String) parseToJavaObject(eleDict
				.get("sourceTree")));
		parsedObjects.put(key, group);
		parseInProgressObjects.remove(key);
		return group;
	}

	private PBXResourcesBuildPhase processPBXResourcesBuildPhase(String key,
			NSDictionary nsdict) throws Exception {
		NSDictionary eleDict = (NSDictionary) nsdict.get(key);
		PBXResourcesBuildPhase resourcesBuildPhase = (PBXResourcesBuildPhase) parseInProgressObjects
				.get(key);
		if (resourcesBuildPhase == null) {
			resourcesBuildPhase = new PBXResourcesBuildPhase();
			parseInProgressObjects.put(key, resourcesBuildPhase);
		}
		resourcesBuildPhase.setBuildActionMask(parseToJavaObject(eleDict
				.get("buildActionMask")));
		resourcesBuildPhase
				.setFiles(parseToList((NSArray) eleDict.get("files")));
		resourcesBuildPhase.setReference(key);
		resourcesBuildPhase
				.setRunOnlyForDeploymentPostprocessing(parseToJavaObject(eleDict
						.get("runOnlyForDeploymentPostprocessing")));
		parsedObjects.put(key, resourcesBuildPhase);
		parseInProgressObjects.remove(key);
		return resourcesBuildPhase;
	}

	private PBXSourcesBuildPhase processPBXSourceBuildPhase(String key,
			NSDictionary nsdict) throws Exception {
		NSDictionary eleDict = (NSDictionary) nsdict.get(key);
		PBXSourcesBuildPhase sourcesBuildPhase = (PBXSourcesBuildPhase) parseInProgressObjects
				.get(key);
		if (sourcesBuildPhase == null) {
			sourcesBuildPhase = new PBXSourcesBuildPhase();
			parseInProgressObjects.put(key, sourcesBuildPhase);
		}
		sourcesBuildPhase.setBuildActionMask(parseToJavaObject(eleDict
				.get("buildActionMask")));
		sourcesBuildPhase.setFiles(parseToList((NSArray) eleDict.get("files")));
		sourcesBuildPhase.setReference(key);
		sourcesBuildPhase
				.setRunOnlyForDeploymentPostprocessing(parseToJavaObject(eleDict
						.get("runOnlyForDeploymentPostprocessing")));
		parsedObjects.put(key, sourcesBuildPhase);
		parseInProgressObjects.remove(key);
		return sourcesBuildPhase;
	}

	private PBXTargetDependency processPBXTargetDependency(String key,
			NSDictionary nsdict) throws Exception {
		NSDictionary eleDict = (NSDictionary) nsdict.get(key);
		PBXTargetDependency targetDependency = (PBXTargetDependency) parseInProgressObjects
				.get(key);
		if (targetDependency == null) {
			targetDependency = new PBXTargetDependency();
			parseInProgressObjects.put(key, targetDependency);
		}
		targetDependency.setReference(key);
		String target = (String) parseToJavaObject(eleDict.get("target"));
		if (parseInProgressObjects.containsKey(target)) {
			targetDependency.setTarget((PBXNativeTarget) parseInProgressObjects
					.get(target));
		} else {
			targetDependency.setTarget((PBXNativeTarget) parseObject(target,
					nsdict));
		}

		String targetProxy = (String) parseToJavaObject(eleDict
				.get("targetProxy"));
		if (parseInProgressObjects.containsKey(targetProxy)) {
			targetDependency
					.setTargetProxy((PBXContainerItemProxy) parseInProgressObjects
							.get(targetProxy));
		} else {
			targetDependency
					.setTargetProxy((PBXContainerItemProxy) parseObject(
							targetProxy, nsdict));
		}
		parsedObjects.put(key, targetDependency);
		parseInProgressObjects.remove(key);
		return targetDependency;
	}

	private PBXVariantGroup processPBXVariantGroup(String key,
			NSDictionary nsdict) throws Exception {
		NSDictionary eleDict = (NSDictionary) nsdict.get(key);
		PBXVariantGroup variantGroup = (PBXVariantGroup) parseInProgressObjects
				.get(key);
		if (variantGroup == null) {
			variantGroup = new PBXVariantGroup();
			parseInProgressObjects.put(key, variantGroup);
		}
		variantGroup
				.setChildren(parseToList((NSArray) eleDict.get("children")));
		variantGroup.setName((String) parseToJavaObject(eleDict.get("name")));
		variantGroup.setReference(key);
		variantGroup.setSourceTree((String) parseToJavaObject(eleDict
				.get("sourceTree")));
		parsedObjects.put(key, variantGroup);
		parseInProgressObjects.remove(key);
		return variantGroup;
	}

	private XCBuildConfiguration processXCBuildConfiguration(String key,
			NSDictionary nsdict) throws Exception {
		NSDictionary eleDict = (NSDictionary) nsdict.get(key);
		XCBuildConfiguration buildConfiguration = (XCBuildConfiguration) parseInProgressObjects
				.get(key);
		if (buildConfiguration == null) {
			buildConfiguration = new XCBuildConfiguration();
			parseInProgressObjects.put(key, buildConfiguration);
		}
		buildConfiguration
				.setBaseConfigurationReference((String) parseToJavaObject(eleDict
						.get("baseConfigurationReference")));
		buildConfiguration.setBuildSettings(parseToMap((NSDictionary) eleDict
				.get("buildSettings")));
		buildConfiguration.setName((String) parseToJavaObject(eleDict
				.get("name")));
		buildConfiguration.setReference(key);
		parsedObjects.put(key, buildConfiguration);
		parseInProgressObjects.remove(key);
		return buildConfiguration;
	}

	private XCConfigurationList processXCConfigurationList(String key,
			NSDictionary nsdict) throws Exception {
		NSDictionary eleDict = (NSDictionary) nsdict.get(key);
		XCConfigurationList configurationList = (XCConfigurationList) parseInProgressObjects
				.get(key);
		if (configurationList == null) {
			configurationList = new XCConfigurationList();
			parseInProgressObjects.put(key, configurationList);
		}
		configurationList.setBuildConfigurations(parseToList((NSArray) eleDict
				.get("buildConfigurations")));
		configurationList
				.setDefaultConfigurationIsVisible(parseToJavaObject(eleDict
						.get("defaultConfigurationIsVisible")));
		configurationList
				.setDefaultConfigurationName((String) parseToJavaObject(eleDict
						.get("defaultConfigurationName")));
		configurationList.setReference(key);
		parsedObjects.put(key, configurationList);
		parseInProgressObjects.remove(key);
		return configurationList;
	}

	private PBXCopyFilesBuildPhase processPBXCopyFilesBuildPhase(String key,
			NSDictionary nsdict) throws Exception {
		NSDictionary eleDict = (NSDictionary) nsdict.get(key);
		PBXCopyFilesBuildPhase filesBuildPhase = (PBXCopyFilesBuildPhase) parseInProgressObjects
				.get(key);
		if (filesBuildPhase == null) {
			filesBuildPhase = new PBXCopyFilesBuildPhase();
			parseInProgressObjects.put(key, filesBuildPhase);
		}
		filesBuildPhase.setBuildActionMask(parseToJavaObject(eleDict
				.get("buildActionMask")));
		filesBuildPhase.setDstPath((String) parseToJavaObject(eleDict
				.get("dstPath")));
		filesBuildPhase.setDstSubfolderSpec(parseToJavaObject(eleDict
				.get("dstSubfolderSpec")));
		filesBuildPhase.setFiles(parseToList((NSArray) eleDict.get("files")));
		filesBuildPhase.setReference(key);
		filesBuildPhase
				.setRunOnlyForDeploymentPostprocessing(parseToJavaObject(eleDict
						.get("runOnlyForDeploymentPostprocessing")));
		parsedObjects.put(key, filesBuildPhase);
		parseInProgressObjects.remove(key);
		return filesBuildPhase;
	}

	private PBXHeadersBuildPhase processPBXHeadersBuildPhase(String key,
			NSDictionary nsdict) throws Exception {
		NSDictionary eleDict = (NSDictionary) nsdict.get(key);
		PBXHeadersBuildPhase headersBuildPhase = (PBXHeadersBuildPhase) parseInProgressObjects
				.get(key);
		if (headersBuildPhase == null) {
			headersBuildPhase = new PBXHeadersBuildPhase();
			parseInProgressObjects.put(key, headersBuildPhase);
		}
		headersBuildPhase.setBuildActionMask(parseToJavaObject(eleDict
				.get("buildActionMask")));
		headersBuildPhase.setFiles(parseToList((NSArray) eleDict.get("files")));
		headersBuildPhase.setReference(key);
		headersBuildPhase
				.setRunOnlyForDeploymentPostprocessing(parseToJavaObject(eleDict
						.get("runOnlyForDeploymentPostprocessing")));
		parsedObjects.put(key, headersBuildPhase);
		parseInProgressObjects.remove(key);
		return headersBuildPhase;
	}

	private PBXLegacyTarget processPBXLegacyTarget(String key,
			NSDictionary nsdict) throws Exception {
		NSDictionary eleDict = (NSDictionary) nsdict.get(key);
		PBXLegacyTarget legacyTarget = (PBXLegacyTarget) parseInProgressObjects
				.get(key);
		if (legacyTarget == null) {
			legacyTarget = new PBXLegacyTarget();
			parseInProgressObjects.put(key, legacyTarget);
		}
		legacyTarget.setBuildArgumentsString((String) parseToJavaObject(eleDict
				.get("buildArgumentsString")));

		String buildConfigurationList = (String) parseToJavaObject(eleDict
				.get("buildConfigurationList"));
		if (parseInProgressObjects.containsKey(buildConfigurationList)) {
			legacyTarget
					.setBuildConfigurationList((XCConfigurationList) parseInProgressObjects
							.get(buildConfigurationList));
		} else {
			legacyTarget
					.setBuildConfigurationList((XCConfigurationList) parseObject(
							buildConfigurationList, nsdict));
		}
		legacyTarget.setBuildPhases(parseToList((NSArray) eleDict
				.get("buildPhases")));
		legacyTarget.setDependencies(parseToList((NSArray) eleDict
				.get("dependencies")));
		legacyTarget.setName((String) parseToJavaObject(eleDict.get("name")));
		legacyTarget
				.setPassBuildSettingsInEnvironment(parseToJavaObject(eleDict
						.get("passBuildSettingsInEnvironment")));
		legacyTarget.setProductName((String) parseToJavaObject(eleDict
				.get("productName")));
		legacyTarget.setBuildToolPath((String) parseToJavaObject(eleDict
				.get("buildToolPath")));
		legacyTarget
				.setBuildWorkingDirectory((String) parseToJavaObject(eleDict
						.get("buildWorkingDirectory")));
		legacyTarget.setReference(key);
		parsedObjects.put(key, legacyTarget);
		parseInProgressObjects.remove(key);
		return legacyTarget;
	}

	private PBXShellScriptBuildPhase processPBXShellScriptBuildPhase(
			String key, NSDictionary nsdict) throws Exception {
		NSDictionary eleDict = (NSDictionary) nsdict.get(key);
		PBXShellScriptBuildPhase shellScriptBuildPhase = (PBXShellScriptBuildPhase) parseInProgressObjects
				.get(key);
		if (shellScriptBuildPhase == null) {
			shellScriptBuildPhase = new PBXShellScriptBuildPhase();
			parseInProgressObjects.put(key, shellScriptBuildPhase);
		}
		shellScriptBuildPhase.setBuildActionMask(parseToJavaObject(eleDict
				.get("buildActionMask")));
		shellScriptBuildPhase.setFiles(parseToList((NSArray) eleDict
				.get("files")));
		shellScriptBuildPhase.setReference(key);
		shellScriptBuildPhase
				.setRunOnlyForDeploymentPostprocessing(parseToJavaObject(eleDict
						.get("runOnlyForDeploymentPostprocessing")));
		shellScriptBuildPhase.setInputPaths(parseToList((NSArray) eleDict
				.get("inputPaths")));
		shellScriptBuildPhase.setOutputPaths(parseToList((NSArray) eleDict
				.get("outputPaths")));
		shellScriptBuildPhase.setShellPath((String) parseToJavaObject(eleDict
				.get("shellPath")));
		shellScriptBuildPhase.setShellScript((String) parseToJavaObject(eleDict
				.get("shellScript")));
		parsedObjects.put(key, shellScriptBuildPhase);
		parseInProgressObjects.remove(key);
		return shellScriptBuildPhase;
	}

	private PBXProject processPBXProject(String key, NSDictionary nsdict)
			throws Exception {
		NSDictionary eleDict = (NSDictionary) nsdict.get(key);
		PBXProject project = (PBXProject) parseInProgressObjects.get(key);
		if (project == null) {
			project = new PBXProject();
			parseInProgressObjects.put(key, project);
		}
		String buildConfigurationListP = (String) parseToJavaObject(eleDict
				.get("buildConfigurationList"));
		if (parseInProgressObjects.containsKey(buildConfigurationListP)) {
			project.setBuildConfigurationList((XCConfigurationList) parseInProgressObjects
					.get(buildConfigurationListP));
		} else {
			project.setBuildConfigurationList((XCConfigurationList) parseObject(
					buildConfigurationListP, nsdict));
		}

		project.setCompatibilityVersion((String) parseToJavaObject(eleDict
				.get("compatibilityVersion")));
		project.setDevelopmentRegion((String) parseToJavaObject(eleDict
				.get("developmentRegion")));
		project.setHasScannedForEncodings(parseToJavaObject(eleDict
				.get("hasScannedForEncodings")));
		project.setKnownRegions(parseToList((NSArray) eleDict
				.get("knownRegions")));

		String mainGroup = (String) parseToJavaObject(eleDict.get("mainGroup"));
		if (parseInProgressObjects.containsKey(mainGroup)) {
			project.setMainGroup((PBXGroup) parseInProgressObjects
					.get(mainGroup));
		} else {
			project.setMainGroup((PBXGroup) parseObject(mainGroup, nsdict));
		}

		String productRefGroup = (String) parseToJavaObject(eleDict
				.get("productRefGroup"));
		if (parseInProgressObjects.containsKey(productRefGroup)) {
			project.setProductRefGroup((PBXGroup) parseInProgressObjects
					.get(productRefGroup));
		} else {
			project.setProductRefGroup((PBXGroup) parseObject(productRefGroup,
					nsdict));
		}

		project.setProjectDirPath((String) parseToJavaObject(eleDict
				.get("projectDirPath")));
		project.setProjectReferences(parseToList((NSArray) eleDict
				.get("projectReferences")));
		project.setProjectRoot((String) parseToJavaObject(eleDict
				.get("projectRoot")));
		project.setReference(key);
		project.setTargets(parseToList((NSArray) eleDict.get("targets")));
		parsedObjects.put(key, project);
		parseInProgressObjects.remove(key);
		return project;
	}

	private PBXNativeTarget processPBXNativeTarget(String key,
			NSDictionary nsdict) throws Exception {
		NSDictionary eleDict = (NSDictionary) nsdict.get(key);
		PBXNativeTarget nativeTarget = (PBXNativeTarget) parseInProgressObjects
				.get(key);
		if (nativeTarget == null) {
			nativeTarget = new PBXNativeTarget();
			parseInProgressObjects.put(key, nativeTarget);
		}

		String buildConfigurationList = (String) parseToJavaObject(eleDict
				.get("buildConfigurationList"));
		if (parseInProgressObjects.containsKey(buildConfigurationList)) {
			nativeTarget
					.setBuildConfigurationList((XCConfigurationList) parseInProgressObjects
							.get(buildConfigurationList));
		} else {
			nativeTarget
					.setBuildConfigurationList((XCConfigurationList) parseObject(
							buildConfigurationList, nsdict));
		}
		nativeTarget.setBuildPhases(parseToList((NSArray) eleDict
				.get("buildPhases")));
		nativeTarget.setDependencies(parseToList((NSArray) eleDict
				.get("dependencies")));
		nativeTarget.setName((String) parseToJavaObject(eleDict.get("name")));
		nativeTarget.setProductInstallPath((String) parseToJavaObject(eleDict
				.get("productInstallPath")));
		nativeTarget.setProductName((String) parseToJavaObject(eleDict
				.get("productName")));

		String productReference = (String) parseToJavaObject(eleDict
				.get("productReference"));
		if (parseInProgressObjects.containsKey(productReference)) {
			nativeTarget
					.setProductReference((PBXFileReference) parseInProgressObjects
							.get(productReference));
		} else {
			nativeTarget.setProductReference((PBXFileReference) parseObject(
					productReference, nsdict));
		}

		nativeTarget.setProductType((String) parseToJavaObject(eleDict
				.get("productType")));
		nativeTarget.setReference(key);
		parsedObjects.put(key, nativeTarget);
		parseInProgressObjects.remove(key);
		return nativeTarget;
	}

	private PBXContainerItemProxy processPBXContainerItemProxy(String key,
			NSDictionary nsdict) throws Exception {
		NSDictionary eleDict = (NSDictionary) nsdict.get(key);
		PBXContainerItemProxy containerItemProxy = (PBXContainerItemProxy) parseInProgressObjects
				.get(key);
		if (containerItemProxy == null) {
			containerItemProxy = new PBXContainerItemProxy();
			parseInProgressObjects.put(key, containerItemProxy);
		}

		String containerPortal = (String) parseToJavaObject(eleDict
				.get("containerPortal"));
		if (parseInProgressObjects.containsKey(containerPortal)) {
			containerItemProxy
					.setContainerPortal((PBXProject) parseInProgressObjects
							.get(containerPortal));
		} else {
			containerItemProxy.setContainerPortal((PBXProject) parseObject(
					containerPortal, nsdict));
		}
		containerItemProxy.setProxyType(parseToJavaObject(eleDict
				.get("proxyType")));
		containerItemProxy.setReference(key);
		String remoteGlobalIDString = (String) parseToJavaObject(eleDict
				.get("remoteGlobalIDString"));
		if (parseInProgressObjects.containsKey(remoteGlobalIDString)) {
			containerItemProxy
					.setRemoteGlobalIDString((PBXTarget) parseInProgressObjects
							.get(remoteGlobalIDString));
		} else {
			containerItemProxy.setRemoteGlobalIDString((PBXTarget) parseObject(
					remoteGlobalIDString, nsdict));
		}
		containerItemProxy.setRemoteInfo((String) parseToJavaObject(eleDict
				.get("remoteInfo")));
		parsedObjects.put(key, containerItemProxy);
		parseInProgressObjects.remove(key);
		return containerItemProxy;
	}

	private PBXBuildFile processPBXBuildFile(String key, NSDictionary nsdict)
			throws Exception {
		NSDictionary eleDict = (NSDictionary) nsdict.get(key);
		PBXBuildFile buildFile = (PBXBuildFile) parseInProgressObjects.get(key);
		if (buildFile == null) {
			buildFile = new PBXBuildFile();
			parseInProgressObjects.put(key, buildFile);
		}
		buildFile.setReference(key);
		buildFile
				.setSettings(parseToMap((NSDictionary) eleDict.get("settings")));
		String fileRef = (String) parseToJavaObject(eleDict.get("fileRef"));
		if (parseInProgressObjects.containsKey(fileRef)) {
			buildFile.setFileRef((Element) parseInProgressObjects.get(fileRef));
		} else {
			buildFile
					.setFileRef((Element) parseObject(
							(String) parseToJavaObject(eleDict.get("fileRef")),
							nsdict));
		}
		parsedObjects.put(key, buildFile);
		parseInProgressObjects.remove(key);
		return buildFile;
	}

	private Object parseToJavaObject(NSObject nsobject) throws Exception {
		if (nsobject instanceof NSDictionary) {
			return parseToMap((NSDictionary) nsobject);
		} else if (nsobject instanceof NSArray) {
			return parseToList((NSArray) nsobject);
		} else if (nsobject instanceof NSNumber) {
			return nsobject.toJavaObject();
		} else if (nsobject instanceof NSString) {
			return nsobject.toJavaObject();
		}
		return null;
	}

	private Map<String, Object> parseToMap(NSDictionary dict) throws Exception {
		if (dict != null) {
			Map<String, Object> map = new HashMap<String, Object>();
			Iterator<String> iterator = dict.keySet().iterator();
			while (iterator.hasNext()) {
				String key = iterator.next();
				map.put(key, parseObject(key, dict));
			}
			return map;
		}
		return null;
	}

	private List<Object> parseToList(NSArray array) throws Exception {
		if (array != null) {
			List<Object> outputList = new ArrayList<Object>();
			for (int i = 0; i < array.count(); i++) {
				String key = (String) parseToJavaObject(array.objectAtIndex(i));
				Object obj = key;
				if (((NSDictionary) this.dict.get("objects")).containsKey(key)) {
					obj = parseObject(key,
							(NSDictionary) this.dict.get("objects"));					
				}
				outputList.add(obj);
			}
			return outputList;
		}
		return null;
	}

	public static Map<String, Element> toElementMap(
			Map<String, Object> objectMap) throws ClassCastException {
		if (objectMap != null) {
			Map<String, Element> newMap = new HashMap<String, Element>();
			for (Map.Entry<String, Object> entry : objectMap.entrySet()) {
				newMap.put(entry.getKey(), (Element) entry.getValue());
			}
			return newMap;
		}
		return null;
	}

	public PBXDocument getDocument() {
		return document;
	}
}
