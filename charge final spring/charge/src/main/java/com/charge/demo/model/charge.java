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
	 int BILLING_PERIOD;                           
	 String  BILL_TYPE ;                                                        
	 int CCABS_CHARGE;                            
	 int SV_CHARGE;                              
	 int DIFF_CHARGE;                              
	 String PERC_DIFF;
	 int RECORD_TYPE_ID;
	 public charge()
	 {
		 
	 }
	 public charge(String aCCOUNT_NAME, int bILLING_PERIOD, String bILL_TYPE, int cCABS_CHARGE, int sV_CHARGE,
			int dIFF_CHARGE, String pERC_DIFF,int rECORD_TYPE_ID) {
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
	public int getBILLING_PERIOD() {
		return BILLING_PERIOD;
	}
	public void setBILLING_PERIOD(int bILLING_PERIOD) {
		BILLING_PERIOD = bILLING_PERIOD;
	}
	public String getBILL_TYPE() {
		return BILL_TYPE;
	}
	public void setBILL_TYPE(String bILL_TYPE) {
		BILL_TYPE = bILL_TYPE;
	}
	public int getCCABS_CHARGE() {
		return CCABS_CHARGE;
	}
	public void setCCABS_CHARGE(int cCABS_CHARGE) {
		CCABS_CHARGE = cCABS_CHARGE;
	}
	public int getSV_CHARGE() {
		return SV_CHARGE;
	}
	public void setSV_CHARGE(int sV_CHARGE) {
		SV_CHARGE = sV_CHARGE;
	}
	public int getDIFF_CHARGE() {
		return DIFF_CHARGE;
	}
	public void setDIFF_CHARGE(int dIFF_CHARGE) {
		DIFF_CHARGE = dIFF_CHARGE;
	}
	public String getPERC_DIFF() {
		return PERC_DIFF;
	}
	public void setPERC_DIFF(String pERC_DIFF) {
		PERC_DIFF = pERC_DIFF;
	}
	 public int getRECORD_TYPE_ID() {
		return RECORD_TYPE_ID;
	}
	public void setRECORD_TYPE_ID(int rECORD_TYPE_ID) {
		RECORD_TYPE_ID = rECORD_TYPE_ID;
	}
	                              	 
}