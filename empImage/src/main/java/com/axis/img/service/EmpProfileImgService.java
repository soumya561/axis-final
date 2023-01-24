package com.axis.img.service;

import org.springframework.web.multipart.MultipartFile;

import com.axis.img.entity.EmpProfileImg;



public interface EmpProfileImgService {
	
	EmpProfileImg getEmpProfileImgById(String empId);
	void uploadEmpProfileImg(String empId, MultipartFile file);

}
