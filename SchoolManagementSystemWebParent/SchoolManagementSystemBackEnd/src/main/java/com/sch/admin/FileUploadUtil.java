package com.sch.admin;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;


public class FileUploadUtil {
	//for file logging and should be used in the production mode
	private static final Logger LOGGER = LoggerFactory.getLogger(FileUploadUtil.class);
		

	//static method for uploading photos to image directory
	public static void saveFile(String uploadDir, String fileName,
			MultipartFile multipartFile) throws IOException {
		
		//get the image path
		Path uploadPath = Paths.get(uploadDir);
		
		//check if image directory exist
		if(!Files.exists(uploadPath)) {
			//create a directory if the image directory doesn't exist
			Files.createDirectories(uploadPath);
		}
		
		//get inputstream from the multipartfile object
		try (InputStream inputStream = multipartFile.getInputStream()){
			//create file upload path
			Path filePath = uploadPath.resolve(fileName);
			
			//override existing files with the same name
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
			
		} catch (IOException ex) {
			throw new IOException("Could not save file: " + fileName, ex);
		}
		
	}
	
	//clean image directory before uploading images
	public static void cleanDir(String dir) {
		//get the directory path
		Path dirPath = Paths.get(dir);
		
		try {
			Files.list(dirPath).forEach(file -> {
				if(!Files.isDirectory(file)) {
					try {
						Files.delete(file);
					}catch (IOException ex) {
						//print the error message in the log file
						
						LOGGER.error("Could not delete file: " + file);
					}
				}
			});
			
		} catch (IOException e) {
			//print the error message in the log file
			LOGGER.error("Could not list directory: " + dirPath);
		}
	}
	
	
}
