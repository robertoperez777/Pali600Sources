package org.kecskemetip;

import java.io.File;
import java.text.Normalizer;
import java.text.Normalizer.Form;

public class JDirectoryNormalizer {

	public static void normalizeFilesAndSubDirectories(String dirName) {
		String[] list;
		File file, tmpFile;
		boolean isRenamed = false;
		file = new File(dirName);
		if (file.isDirectory()) {
			list = file.list();
			for (String element : list) {
				if (!isFileOrDirNormalized(element)) {
					tmpFile = new File(file.getPath() + File.separator + element);
					String newFileOrDir = file.getPath() + File.separator + removeAccents(element);
					isRenamed = tmpFile.renameTo(new File(newFileOrDir));
					if (isRenamed) {
						normalizeFilesAndSubDirectories(newFileOrDir);
					} else {
						normalizeFilesAndSubDirectories(dirName);
					}
				}
			}
			if (!isFileOrDirNormalized(dirName)) {
				file.renameTo(new File(file.getParent() + File.separator + removeAccents(file.getName())));
			}
		}
	}

	public static String removeAccents(String fileOrDirName) {
		if (fileOrDirName == null) {
			return null;
		}
		String normalized = fileOrDirName;
		if (!isFileOrDirNormalized(fileOrDirName)) {
			normalized = Normalizer.normalize(fileOrDirName, Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
		}
		return normalized;
	}

	public static boolean isFileOrDirNormalized(String fileOrDirName) {
		if (Normalizer.isNormalized(fileOrDirName, Form.NFD)) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Usage: java JDirectoryNormalizer <AbsoluthPath>dirName");
			System.exit(0);
		}
		JDirectoryNormalizer.normalizeFilesAndSubDirectories(args[0]);
	}

}
