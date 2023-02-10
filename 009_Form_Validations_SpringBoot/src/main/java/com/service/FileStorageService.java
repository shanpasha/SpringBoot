package com.service;

import org.springframework.web.multipart.MultipartFile;

import com.fileStorage.FileStore;

public interface FileStorageService {

	public FileStore uploadFile(MultipartFile file);
	
	public FileStore getFile(Integer FileID);
}
