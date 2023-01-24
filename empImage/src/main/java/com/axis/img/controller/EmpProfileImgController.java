package com.axis.img.controller;


import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.axis.img.entity.EmpProfileImg;
import com.axis.img.service.EmpProfileImgService;

@RestController

public class EmpProfileImgController {
	
	@Autowired
	private EmpProfileImgService empProfileImgService;
	
	@GetMapping("/profile-image/{empId}")
	public ResponseEntity<byte[]> getProfileImageById(@PathVariable String empId) {
		EmpProfileImg empProfileImg = empProfileImgService.getEmpProfileImgById(empId);
		return new ResponseEntity<>(Base64.getEncoder().encode(empProfileImg.getImgData()), HttpStatus.OK);
	}

	@PostMapping("/upload-image")
	public ResponseEntity<String> uploadProfileImage(@RequestParam("empId") String empId,
			@RequestParam("file") MultipartFile file) {
		 empProfileImgService.uploadEmpProfileImg(empId, file);
		return new ResponseEntity<>("Profile Image Uploaded Successfully", HttpStatus.OK);
	}
}
	
	
	
	

