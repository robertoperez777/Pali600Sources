package org.kecskemetip.test;

import org.junit.Test;
import org.kecskemetip.JDirectoryNormalizer;

public class JDirectoryNormalizerTest {

	private String fileOrDirName = "aáeÉuüűúoőöóií AÁEÉUŰÚÜŰOÖŐÓIÍ";

	@Test
	public void removeAccents() {
		System.out.println(JDirectoryNormalizer.removeAccents(this.fileOrDirName));
	}

	@Test
	public void normalizeFilesAndSubDirectories() {
		JDirectoryNormalizer.normalizeFilesAndSubDirectories("/home/pali/Letöltések/TeaéáűőúöüóíÉÁŰ");
	}

}
