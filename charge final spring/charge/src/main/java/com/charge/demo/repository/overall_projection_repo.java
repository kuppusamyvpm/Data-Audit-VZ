package com.charge.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.charge.demo.model.overall_projection;

public interface overall_projection_repo extends JpaRepository<overall_projection, List<Integer>>
{
	 String ab ="select * from test";
	 @Query(nativeQuery = true,value = ab)  List<overall_projection> findByoverallproject();
		

}