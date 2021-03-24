package com.charge.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COMP_CHARGE")
public class charge
{
	@Id
	 String  ACCOUNT_NAME ;
	 String BILLING_PERIOD;                           
	 String  BILL_TYPE ;                                                        
	 String CCABS_CHARGE;                            
	 String SV_CHARGE;                              
	 String DIFF_CHARGE;                              
	 String PERC_DIFF;
	 String RECORD_TYPE_ID;
	 public charge()
	 {
		 
	 }
	 public charge(String aCCOUNT_NAME, String bILLING_PERIOD, String bILL_TYPE, String cCABS_CHARGE, String sV_CHARGE,
			String dIFF_CHARGE, String pERC_DIFF,String rECORD_TYPE_ID) {
		super();
		ACCOUNT_NAME = aCCOUNT_NAME;
		BILLING_PERIOD = bILLING_PERIOD;
		BILL_TYPE = bILL_TYPE;
		CCABS_CHARGE = cCABS_CHARGE;
		SV_CHARGE = sV_CHARGE;
		DIFF_CHARGE = dIFF_CHARGE;
		PERC_DIFF = pERC_DIFF;
	}
	 

	public String getACCOUNT_NAME() {
		return ACCOUNT_NAME;
	}
	public void setACCOUNT_NAME(String aCCOUNT_NAME) {
		ACCOUNT_NAME = aCCOUNT_NAME;
	}
	public String getBILLING_PERIOD() {
		return BILLING_PERIOD;
	}
	public void setBILLING_PERIOD(String bILLING_PERIOD) {
		BILLING_PERIOD = bILLING_PERIOD;
	}
	public String getBILL_TYPE() {
		return BILL_TYPE;
	}
	public void setBILL_TYPE(String bILL_TYPE) {
		BILL_TYPE = bILL_TYPE;
	}
	public String getCCABS_CHARGE() {
		return CCABS_CHARGE;
	}
	public void setCCABS_CHARGE(String cCABS_CHARGE) {
		CCABS_CHARGE = cCABS_CHARGE;
	}
	public String getSV_CHARGE() {
		return SV_CHARGE;
	}
	public void setSV_CHARGE(String sV_CHARGE) {
		SV_CHARGE = sV_CHARGE;
	}
	public String getDIFF_CHARGE() {
		return DIFF_CHARGE;
	}
	public void setDIFF_CHARGE(String dIFF_CHARGE) {
		DIFF_CHARGE = dIFF_CHARGE;
	}
	public String getPERC_DIFF() {
		return PERC_DIFF;
	}
	public void setPERC_DIFF(String pERC_DIFF) {
		PERC_DIFF = pERC_DIFF;
	}
	 public String getRECORD_TYPE_ID() {
		return RECORD_TYPE_ID;
	}
	public void setRECORD_TYPE_ID(String rECORD_TYPE_ID) {
		RECORD_TYPE_ID = rECORD_TYPE_ID;
	}
	                              	 
}
