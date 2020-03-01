package net.cirou.tool;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class FileCopy {

	static List<String> srcFiles = new ArrayList<>();

	public static void main(String args[]) throws IOException {

		String target = "C:/dest_folder/";

		readDocumentNames();

		for (String file : srcFiles) {

			// name of source file
			File sourceFile = new File(file);
			String name = sourceFile.getName();

			File targetFile = new File(target + name);
			System.out.println("Copying file : " + sourceFile.getName());

			// copy file from one location to other
			FileUtils.copyFile(sourceFile, targetFile);
		}

		System.out.println("copying of file from Java program is completed");
	}

	public static void readDocumentNames() throws IOException {

		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(new FileInputStream("filesToCopy.txt"), StandardCharsets.UTF_8))) {
			String line = reader.readLine();
			while (line != null) {
				srcFiles.add(line);
				line = reader.readLine();
			}
		} catch (IOException e) {
			System.out.println("error");
		}

	}

}