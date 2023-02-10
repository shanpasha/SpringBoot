package com.restController;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fileStorage.FileStore;
import com.fileStorage.ResponseFile;
import com.service.FileStorageService;



@RestController
public class FileController {
	
	
	@Autowired
    private FileStorageService fileStorageService;

    @PostMapping("/uploadFile")
    public ResponseEntity<?>uploadFile(@RequestParam("file") MultipartFile file) {
        FileStore fileName = fileStorageService.uploadFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
            .path("/downloadFile/")
            .path(fileName.getFileName())
            .toUriString();
        ResponseFile Rfile=new ResponseFile(fileName.getFileName(),fileDownloadUri,file.getContentType(),file.getSize());
		return new ResponseEntity<>(HttpStatus.OK).ok(Rfile);
        

  
    }
	
    
    @GetMapping("/downloadFile/{id}")
    public ResponseEntity < ? > downloadFile(@PathVariable("id") Integer FileID, HttpServletRequest request) {
        try {
    	FileStore databaseFile = fileStorageService.getFile(FileID);
    	return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(databaseFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; FileID=\"" + databaseFile.getFileName() + "\"")
                .body(new ByteArrayResource(databaseFile.getData()));
        }catch (Exception e) {
        	return new ResponseEntity<>(HttpStatus.OK).ok("No files Available in this ID:"+FileID);
		}
		
        
    }

}
