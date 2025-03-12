package com.example.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.utils.Constants;

@CrossOrigin
@RestController
@RequestMapping("/upload")
public class ImageController {
	
	private final Path root = Paths.get("upload");
	
	
	@RequestMapping(value = { "/" }, method = { RequestMethod.POST }, consumes = { "multipart/form-data" })
	public String upload(@RequestParam("file") MultipartFile file) {
		

		try {
			UUID uuid = UUID.randomUUID();
			String extension = FilenameUtils.getExtension(file.getOriginalFilename());
			File path = new File(Constants.UPLOAD_PATH + uuid.toString() + "." + extension);
			path.createNewFile();
			FileOutputStream output = new FileOutputStream(path);
			output.write(file.getBytes());
			output.close();
			return (Constants.UPLOAD + uuid.toString() +"."+ extension);

		} catch (Exception e) {
			return (Constants.FAILURE_STATUS);
		}
	}
	
}
