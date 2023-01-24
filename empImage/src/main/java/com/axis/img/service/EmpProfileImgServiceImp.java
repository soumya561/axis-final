package com.axis.img.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.axis.img.entity.EmpProfileImg;
import com.axis.img.exception.EmpProfileImgNotFoundException;
import com.axis.img.exception.EmpProfileImgStorageException;
import com.axis.img.respository.EmpProfileImgRepository;




@Service
public class EmpProfileImgServiceImp implements EmpProfileImgService{

	
	
	
	@Autowired
	private EmpProfileImgRepository empProfileImgRepository;
	
	@Override
	public EmpProfileImg getEmpProfileImgById(String empId) {
		// TODO Auto-generated method stub
		return empProfileImgRepository.findById(empId).orElseThrow(()->new EmpProfileImgNotFoundException("img not found"+empId));
				
	}

	@Override
	public void uploadEmpProfileImg(String empId, MultipartFile file) {
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			try {
				if(fileName.contains("..")) {
					throw new EmpProfileImgStorageException("Invalid Path Sequence" + fileName);
				}
				EmpProfileImg empProfileImg = new EmpProfileImg(empId, fileName, file.getContentType(), file.getBytes());
				empProfileImgRepository.save(empProfileImg);
			} catch(IOException e) {
				throw new EmpProfileImgStorageException("Could not store file " + fileName + ". Please try again!");
			}
		
		
	}

}
