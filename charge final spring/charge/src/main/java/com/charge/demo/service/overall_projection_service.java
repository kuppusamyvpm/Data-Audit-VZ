package com.charge.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charge.demo.model.overall_projection;
import com.charge.demo.repository.overall_projection_repo;

@Service
public class overall_projection_service {
	
	@Autowired
	private overall_projection_repo opr;
	
	public List<overall_projection> getchargebyrawquery3()
    {
        List<overall_projection> c=opr.findByoverallproject();
        return c;
     }

}
