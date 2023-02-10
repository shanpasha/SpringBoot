package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.Exception.FileStorageException;
import com.dao.FileStorageRepo;
import com.fileStorage.FileStore;
@Service
public class FileStoargeServiceImpl implements FileStorageService {
	
	@Autowired
	FileStorageRepo repo;
	

	@Override
	public FileStore uploadFile(MultipartFile file) {
		String fileName=StringUtils.cleanPath(file.getOriginalFilename());
		
		
		try {
			
			if (fileName.contains("..")) {
			throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
				
			}
			
			FileStore store=new FileStore();
			store.setFileType(file.getContentType());
			store.setFileName(fileName);
			store.setData(file.getBytes());
			return repo.save(store);
		} catch (Exception e) {
			e.getStackTrace();
		}
		return null;
		
		
		
		
	}

	@Override
	public FileStore getFile(Integer FileID) {
		FileStore file=repo.findById(FileID).get();
		if(file!=null) {
		return file;
		}else {
			
		return null;	
		
			
		}
}


}

