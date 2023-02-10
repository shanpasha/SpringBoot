package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fileStorage.FileStore;

public interface FileStorageRepo extends JpaRepository<FileStore, Integer>{

}
