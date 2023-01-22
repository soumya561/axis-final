package com.axis.document.controller;

import com.axis.document.entity.Document;
import com.axis.document.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.Base64;




@RestController
@CrossOrigin(value = "http://localhost:3000")
public class DocumentController {

    
    @Autowired
    private DocumentService documentService;

    @GetMapping("/view-document/{documentId}")
    public ResponseEntity<byte[]> getDocumentById(@PathVariable int documentId) {
		Document doc = documentService.getDocumentById(documentId);
		return new ResponseEntity<>(Base64.getEncoder().encode(doc.getDocumentData()), HttpStatus.OK);
	}
    
    /*
    @GetMapping("/view-document/{documentId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String documentId) {
        // Load file from database
        Document doc = documentService.getDocumentById(documentId);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getDocumentType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getDocumentName() + "\"")
                .body(new ByteArrayResource(doc.getDocumentData()));
    }
*/
   
    @PostMapping("/uploaddocument")
	public ResponseEntity<String> addDocument(@RequestParam("file") MultipartFile file) {
		documentService.addDocument(file);
		return new ResponseEntity<>("Document Uploaded Successfully", HttpStatus.OK);
	}

}
