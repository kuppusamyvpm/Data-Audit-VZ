package com.charge.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charge.demo.model.charge;
import com.charge.demo.repository.chargeRepo;

@Service
public class chargeService 
{
	@Autowired
	private chargeRepo crepo;

//	public List<charge>fetchbyuserList()
//    {
//        return crepo.findAll();
//    }
	
	  public List<charge> getchargebyrawquery2()
      {
          List<charge> b=crepo.getcharge2();
          return b;
       }
}