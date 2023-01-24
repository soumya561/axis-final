package com.axis.img.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axis.img.entity.EmpProfileImg;

@Repository
public interface EmpProfileImgRepository extends JpaRepository<EmpProfileImg, String> {

}
