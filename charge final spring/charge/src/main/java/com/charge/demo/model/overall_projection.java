package com.charge.demo.model;

import javax.persistence.Entity;

@Entity
public class overall_projection {
	
	
	int  BILLING_PERIOD ;	
	String BILL_TYPE;                                                                                    
	int CCABS_CHARGE;                            
	 int SV_CHARGE;                              
	 int DIFF_CHARGE;                              
	 int CCABS_USAGE;
	 int SV_USAGE;                              
	 int DIFF_USAGE;                              
	 int CCABS_VOLUME;
	 int SV_VOLUME;
	 int DIFF_VOLUME;
	 public overall_projection()
	 {
		 
	 }
	 public overall_projection(int bILLING_PERIOD, String bILL_TYPE, int cCABS_CHARGE, int sV_CHARGE, int dIFF_CHARGE,
			 int cCABS_USAGE, int sV_USAGE, int dIFF_USAGE, int cCABS_VOLUME, int sV_VOLUME,
				int dIFF_VOLUME) {
			super();
			BILLING_PERIOD = bILLING_PERIOD;
			BILL_TYPE = bILL_TYPE;
			CCABS_CHARGE = cCABS_CHARGE;
			SV_CHARGE = sV_CHARGE;
			DIFF_CHARGE = dIFF_CHARGE;
			
			CCABS_USAGE = cCABS_USAGE;
			SV_USAGE = sV_USAGE;
			DIFF_USAGE = dIFF_USAGE;
			CCABS_VOLUME = cCABS_VOLUME;
			SV_VOLUME = sV_VOLUME;
			DIFF_VOLUME = dIFF_VOLUME;
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
	
		public int getCCABS_USAGE() {
			return CCABS_USAGE;
		}
		public void setCCABS_USAGE(int cCABS_USAGE) {
			CCABS_USAGE = cCABS_USAGE;
		}
		public int getSV_USAGE() {
			return SV_USAGE;
		}
		public void setSV_USAGE(int sV_USAGE) {
			SV_USAGE = sV_USAGE;
		}
		public int getDIFF_USAGE() {
			return DIFF_USAGE;
		}
		public void setDIFF_USAGE(int dIFF_USAGE) {
			DIFF_USAGE = dIFF_USAGE;
		}
		public int getCCABS_VOLUME() {
			return CCABS_VOLUME;
		}
		public void setCCABS_VOLUME(int cCABS_VOLUME) {
			CCABS_VOLUME = cCABS_VOLUME;
		}
		public int getSV_VOLUME() {
			return SV_VOLUME;
		}
		public void setSV_VOLUME(int sV_VOLUME) {
			SV_VOLUME = sV_VOLUME;
		}
		public int getDIFF_VOLUME() {
			return DIFF_VOLUME;
		}
		public void setDIFF_VOLUME(int dIFF_VOLUME) {
			DIFF_VOLUME = dIFF_VOLUME;
		}
	 
	
	
}
