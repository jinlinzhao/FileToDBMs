package com.iavtar.controller;

import javax.ws.rs.core.HttpHeaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.iavtar.model.DBFile;
import com.iavtar.payload.UploadFileResponse;
import com.iavtar.service.DBFileStorageService;

@RestController
public class FileController {

	//private static final Logger logger = LoggerFactory.getLogger(FileController.class);
	
	@Autowired
	private DBFileStorageService dbFileStorageService;
	
	@PostMapping("/uploadFile")
	public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
	
		DBFile dbFile = dbFileStorageService.storeFile(file);
		
		
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/downloadFile/")
				.path(dbFile.getId())
				.toUriString();
		
		return new UploadFileResponse(dbFile.getFileName(), fileDownloadUri, file.getContentType(), file.getSize());
		
	}
	
	@GetMapping("/downloadFile/{fileId}")
	public ResponseEntity<Resource> downLoadFile(@PathVariable String fileId){
		
		
		DBFile dbFile = dbFileStorageService.getFile(fileId);
		
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(dbFile.getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachement; fileName=\"" + dbFile.getFileName() +"\"")
				.body(new ByteArrayResource(dbFile.getData()));
		
	}
}
