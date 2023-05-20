package com.sch.admin;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
/**
 * this class is created for the purpose of 
 * exposing the user-photos directory to display 
 * the photos stored in directory
 */
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	//configuration method for exposing images/photos in the file directories
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
//		//exposes photos in the user-photo directory
//		 String dirName = "student-photos"; 
//		 
//		 //directory path 
//		 Path studentPhotosDir = Paths.get(dirName);
//		 
//		//get absolute path 
//		 String studentPhotosPath = studentPhotosDir.toFile().getAbsolutePath();
//		 
//		 registry.addResourceHandler("/" + dirName + "/**")
//		 .addResourceLocations("file:/" + studentPhotosPath + "/");
		
		exposeDirectory("student-photos",registry);
		exposeDirectory("father-photos",registry);
		exposeDirectory("mother-photos",registry);
		exposeDirectory("guardian-photos",registry);
		
	}
	
	
	//method that exposes images in the directory refactored
		private void exposeDirectory(String pathPattern, ResourceHandlerRegistry registry) {
			
			//get directory path
			Path path = Paths.get(pathPattern);
			
			//get absolute path
			String absolutePath = path.toFile().getAbsolutePath();
			
			String logicalPath = pathPattern.replace("..","") + "/**";
			
			registry.addResourceHandler(logicalPath)
			.addResourceLocations("file:/" + absolutePath + "/");
		}

	//registers custom argument resolver
//	@Override
//	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
//		// TODO Auto-generated method stub
//		WebMvcConfigurer.super.addArgumentResolvers(resolvers);
//	}

	
	
}
