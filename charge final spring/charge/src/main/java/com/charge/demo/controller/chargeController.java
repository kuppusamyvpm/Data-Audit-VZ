package com.charge.demo.controller;

import java.io.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.charge.demo.model.charge;
import com.charge.demo.model.overall_projection;
import com.charge.demo.repository.chargeRepo;
//import com.charge.demo.repository.map;
import com.charge.demo.service.chargeService;
import com.google.gson.JsonObject;

@RestController
@CrossOrigin("*")
public class chargeController 
{
	@Autowired
	private chargeRepo cr;
	
	@Autowired
	private chargeService cs;
	
	//level1
	
	@RequestMapping("/ccabs/{acc_no}/{billtype}")
	 String method(@PathVariable String acc_no,@PathVariable String billtype) 
	{

		List<String> c=cr.findByKeyword(acc_no,billtype);
		JsonObject charge = new JsonObject();
		List<String> b=new ArrayList<>();
		
		for(int i=0;i<c.size();i++)
		{
			
			
			System.out.println(c.get(i));
			String[] a=c.get(i).split(",");
			charge.addProperty("accountnbr", a[0]);
			charge.addProperty("market_id", a[1]);
			charge.addProperty("wc_icc", a[2]);
			charge.addProperty("state", a[3]);
			charge.addProperty("lata", a[4]);
			charge.addProperty("cic", a[5]);
			charge.addProperty("ccabs_charge", a[6]);
			charge.addProperty("sv_charge", a[7]);
			charge.addProperty("differ_charge", a[8]);
			charge.addProperty("billing_period", a[9]);
			System.out.println(charge.toString());
			b.add(charge.toString());
			
			
		}
		System.out.println(b);
		
		return b.toString();
	}
	
	
	//level2
	@RequestMapping("/level2/{accountnbr}/{wc_icc}/{state}/{lata}/{cic}/{billing_period}")
	 String method1(@PathVariable String accountnbr,
			 @PathVariable String wc_icc,@PathVariable String state,@PathVariable int lata,@PathVariable int cic,
			 @PathVariable int billing_period) 
	{

		List<String> c1=cr.findByLevel2(accountnbr,wc_icc,state,lata,cic,billing_period);
		JsonObject charge1 = new JsonObject();
		List<String> b1=new ArrayList<>();
		System.out.print(charge1);
		
		
		for(int i=0;i<c1.size();i++)
		{
			
			
			System.out.println(c1.get(i));
			String[] b=c1.get(i).split(",");
			charge1.addProperty("accountnbr", b[0]);
			charge1.addProperty("market_id", b[1]);
			charge1.addProperty("wc_icc", b[2]);
			charge1.addProperty("state", b[3]);
			charge1.addProperty("lata", b[4]);
			charge1.addProperty("cic", b[5]);
			charge1.addProperty("end_office", b[6]);
			charge1.addProperty("ccabs_charge", b[7]);
			charge1.addProperty("sv_charge", b[8]);
			charge1.addProperty("differ_charge", b[9]);
			charge1.addProperty("billing_period", b[10]);
			
			System.out.println(charge1.toString());
			b1.add(charge1.toString());
			
			
		}
		System.out.println(b1);
		
		return b1.toString();
	}

	//level3
	@RequestMapping("/level3/{accountnbr}/{wc_icc}/{state}/{lata}/{cic}/{end_office}/{billing_period}")
	 String method2(@PathVariable String accountnbr,
			 @PathVariable String wc_icc,@PathVariable String state,@PathVariable int lata,@PathVariable int cic,
			 @PathVariable String end_office,
			 @PathVariable int billing_period) 
	{

		List<String> c2=cr.findByLevel3(accountnbr,wc_icc,state,lata,cic,end_office,billing_period);
		JsonObject charge2 = new JsonObject();
		List<String> b2=new ArrayList<>();
		System.out.print(charge2);
		
		
		for(int i=0;i<c2.size();i++)
		{
			
			
			System.out.println(c2.get(i));
			String[] b=c2.get(i).split(",");
			charge2.addProperty("accountnbr", b[0]);
			charge2.addProperty("market_id", b[1]);
			charge2.addProperty("wc_icc", b[2]);
			charge2.addProperty("state", b[3]);
			charge2.addProperty("lata", b[4]);
			charge2.addProperty("cic", b[5]);
			charge2.addProperty("end_office", b[6]);
			charge2.addProperty("traffic_type", b[7]);
			charge2.addProperty("ccabs_charge", b[8]);
			charge2.addProperty("sv_charge", b[9]);
			charge2.addProperty("differ_charge", b[10]);
			charge2.addProperty("billing_period", b[11]);
			
			System.out.println(charge2.toString());
			b2.add(charge2.toString());
			
			
		}
		System.out.println(b2);
		
		return b2.toString();
	}
	
	
	//level3
	@RequestMapping("/level4/{accountnbr}/{wc_icc}/{state}/{lata}/{cic}/{end_office}/{traffic_type}/{billing_period}")
	 String method3(@PathVariable String accountnbr,
			 @PathVariable String wc_icc,@PathVariable String state,@PathVariable int lata,@PathVariable int cic,
			 @PathVariable String end_office,@PathVariable int traffic_type,
			 @PathVariable int billing_period) 
	{

		List<String> c3=cr.findByLevel4(accountnbr,wc_icc,state,lata,cic,end_office,traffic_type,billing_period);
		JsonObject charge3 = new JsonObject();
		List<String> b3=new ArrayList<>();
		System.out.print(charge3);
		
		
		for(int i=0;i<c3.size();i++)
		{
			
			
			System.out.println(c3.get(i));
			String[] b=c3.get(i).split(",");
			charge3.addProperty("accountnbr", b[0]);
			charge3.addProperty("market_id", b[1]);
			charge3.addProperty("wc_icc", b[2]);
			charge3.addProperty("state", b[3]);
			charge3.addProperty("lata", b[4]);
			charge3.addProperty("cic", b[5]);
			charge3.addProperty("end_office", b[6]);
			charge3.addProperty("traffic_type", b[7]);
			charge3.addProperty("jurisdiction", b[8]);
			charge3.addProperty("ccabs_charge", b[9]);
			charge3.addProperty("sv_charge", b[10]);
			charge3.addProperty("differ_charge", b[11]);
			charge3.addProperty("billing_period", b[12]);
			
			System.out.println(charge3.toString());
			b3.add(charge3.toString());
			
			
		}
		System.out.println(b3);
		
		return b3.toString();
	}
	
	
	//level4
	@RequestMapping("/level5/{accountnbr}/{wc_icc}/{state}/{lata}/{cic}/{end_office}/{traffic_type}/{jurisdiction}/{billing_period}")
	 String method4(@PathVariable String accountnbr,
			 @PathVariable String wc_icc,@PathVariable String state,@PathVariable int lata,@PathVariable int cic,
			 @PathVariable String end_office,@PathVariable int traffic_type,@PathVariable String jurisdiction,
			 @PathVariable int billing_period) 
	{

		List<String> c4=cr.findByLevel5(accountnbr,wc_icc,state,lata,cic,end_office,traffic_type,jurisdiction,billing_period);
		JsonObject charge4 = new JsonObject();
		List<String> b4=new ArrayList<>();
		System.out.print(charge4);
		
		
		for(int i=0;i<c4.size();i++)
		{
			
			
			System.out.println(c4.get(i));
			String[] b=c4.get(i).split(",");
			charge4.addProperty("accountnbr", b[0]);
			charge4.addProperty("market_id", b[1]);
			charge4.addProperty("wc_icc", b[2]);
			charge4.addProperty("state", b[3]);
			charge4.addProperty("lata", b[4]);
			charge4.addProperty("cic", b[5]);
			charge4.addProperty("end_office", b[6]);
			charge4.addProperty("traffic_type", b[7]);
			charge4.addProperty("jurisdiction", b[8]);
			charge4.addProperty("voip", b[9]);
			charge4.addProperty("ccabs_charge", b[10]);
			charge4.addProperty("sv_charge", b[11]);
			charge4.addProperty("differ_charge", b[12]);
			charge4.addProperty("billing_period", b[13]);
			
			System.out.println(charge4.toString());
			b4.add(charge4.toString());
			
			
		}
		System.out.println(b4);
		
		return b4.toString();
	}
	
	
	
	  @GetMapping("/ccabs")
	    @CrossOrigin(origins="http://localhost:4200")
		   public List<charge> getchargebyrawquery2()
	    {
	        return cs.getchargebyrawquery2();
	    }

	
	
	
	
	
//	public charge table1call(@RequestBody charge user) throws Exception {
//	       
//        String tempaccname=user.getACCOUNT_NAME();
//        int tempbillperiod=user.getBILLING_PERIOD();
//        charge userobj= cs.fetchUserByAccountAndBill(tempaccname,tempbillperiod);
//        return userobj;
//        }
	
  
  
  
}