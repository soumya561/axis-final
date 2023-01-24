package com.axis.img.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class EmpProfileImg {
	

	@Id
	private String empId;
	private String imgName;
	private String imgType;
	
	@Lob
	private byte[] imgData;

	public EmpProfileImg() {
		
	}

	public EmpProfileImg(String empId, String imgName, String imgType, byte[] imgData) {
		super();
		this.empId = empId;
		this.imgName = imgName;
		this.imgType = imgType;
		this.imgData = imgData;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public String getImgType() {
		return imgType;
	}

	public void setImgType(String imgType) {
		this.imgType = imgType;
	}

	public byte[] getImgData() {
		return imgData;
	}

	public void setImgData(byte[] imgData) {
		this.imgData = imgData;
		
		
	}
	
	

}
