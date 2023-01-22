package com.axis.document.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.axis.document.entity.Document;
import com.axis.document.exception.DocumentNotFoundException;
import com.axis.document.exception.DocumentStorageException;
import com.axis.document.repository.DocumentRepository;

@Service
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private DocumentRepository documentRepository;
	
	@Override
	public Document getDocumentById(int documentId) {
		// TODO Auto-generated method stub
	 return documentRepository.findById(documentId).orElseThrow(() 
			 -> new DocumentNotFoundException("Document do not Exist with Document ID: " + documentId));
	}

	@Override
	public void addDocument(MultipartFile file) {
		
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			if(fileName.contains("..")) {
				throw new DocumentStorageException(" Invalid Path" + fileName);
			}
			Document document = new Document(fileName, file.getContentType(), file.getBytes());
			documentRepository.save(document);
		} catch(IOException e) {
			throw new DocumentStorageException("Could not store file " + fileName + ". Please try again!");
		}// TODO Auto-generated method stub
		
	}
	
	
	
}
