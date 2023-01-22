package com.axis.document.service;

import org.springframework.web.multipart.MultipartFile;

import com.axis.document.entity.Document;


public interface DocumentService {

    Document getDocumentById(int documentId);
	void addDocument(MultipartFile file);
	
}
