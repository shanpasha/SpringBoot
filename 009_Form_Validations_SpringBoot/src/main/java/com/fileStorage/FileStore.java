package com.fileStorage;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "File_Storage")
public class FileStore {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer fileId;
	private String fileType;
	private String fileName;
	@Lob
	byte[] data;

}
