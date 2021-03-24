package com.charge.demo.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties.Jdbc;
import org.springframework.data.jpa.repository.JpaRepository;

import com.charge.demo.model.charge;

public interface chargeRepo extends JpaRepository<charge, List<String>> 
{
	//charge details
	  String mm="SELECT * FROM COMP_CHARGE WHERE RECORD_TYPE_ID=1";
	    @Query(nativeQuery = true,value = mm)  List<charge> getcharge2();

	
    @Query(value ="\r\n"
    		+ "\r\n"
    		+ "select\r\n"
    		+ "ccabs.ACCOUNT_NAME,ccabs.MARKET_ID,ccabs.WC_ICC,ccabs.STATE,ccabs.LATA,ccabs.CIC,\r\n"
    		+ "ccabs.charge ccabs_charge,\r\n"
    		+ "sv.charge sv_charge,(sv.charge-ccabs.charge) diff_charge,ccabs.BILLING_PERIOD\r\n"
    		+ "from (\r\n"
    		+ "select\r\n"
    		+ "BILLING_PERIOD,CUSTOMER_NAME, ACCOUNT_NAME, BILL_TYPE, MARKET_ID,\r\n"
    		+ "WC_ICC,STATE, LATA, CIC,sum(Charge) CHARGE\r\n"
    		+ "from\r\n"
    		+ "ccabs_charge\r\n"
    		+ "where\r\n"
    		+ "record_type_id=2\r\n"
    		+ "and\r\n"
    		+ "billing_period=:billtype\r\n"
    		+ "and\r\n"
    		+ "account_name=:acc_no\r\n"
    		+ "group by BILLING_PERIOD,CUSTOMER_NAME, ACCOUNT_NAME, BILL_TYPE, MARKET_ID,\r\n"
    		+ "WC_ICC,STATE, LATA, CIC) ccabs,\r\n"
    		+ "(\r\n"
    		+ "select\r\n"
    		+ "BILLING_PERIOD,CUSTOMER_NAME, ACCOUNT_NAME, BILL_TYPE, MARKET_ID,\r\n"
    		+ "WC_ICC,STATE, LATA, CIC,sum(CHARGE) CHARGE\r\n"
    		+ "from\r\n"
    		+ "sv_charge\r\n"
    		+ "where\r\n"
    		+ "record_type_id=2\r\n"
    		+ "and\r\n"
    		+ "billing_period=:billtype\r\n"
    		+ "and\r\n"
    		+ "account_name=:acc_no\r\n"
    		+ "group by BILLING_PERIOD,CUSTOMER_NAME, ACCOUNT_NAME, BILL_TYPE, MARKET_ID,\r\n"
    		+ "WC_ICC,STATE, LATA, CIC) sv\r\n"
    		+ "\r\n"
    		+ "where\r\n"
    		+ "ccabs.account_Name=sv.account_name(+)\r\n"
    		+ "and\r\n"
    		+ "ccabs.wc_icc=sv.wc_icc(+)\r\n"
    		+ "and\r\n"
    		+ "ccabs.state=sv.state(+)\r\n"
    		+ "and\r\n"
    		+ "ccabs.lata=sv.lata(+)", nativeQuery = true)
   
    List<String> findByKeyword(@Param("acc_no") String acc_no,@Param("billtype") String billtype);
//    accountnbr,market_id,wc_icc,lata,cic,ccabs_charge,sv_charge,differ_charge

    
    

//    level2
    
    @Query(value ="select\r\n"
    		+ "ccabs.ACCOUNT_NAME,ccabs.MARKET_ID,ccabs.WC_ICC,ccabs.STATE,ccabs.LATA,ccabs.CIC,ccabs.end_office,\r\n"
    		+ "ccabs.charge ccabs_charge,\r\n"
    		+ "sv.charge sv_charge,(sv.charge-ccabs.charge) diff_charge,ccabs.BILLING_PERIOD from\r\n"
    		+ "(select\r\n"
    		+ "BILLING_PERIOD,CUSTOMER_NAME, ACCOUNT_NAME, BILL_TYPE, MARKET_ID,\r\n"
    		+ "WC_ICC, STATE,LATA, CIC,end_office,sum(CHARGE) CHARGE\r\n"
    		+ "from\r\n"
    		+ "ccabs_charge\r\n"
    		+ "where\r\n"
    		+ "record_type_id=2\r\n"	
    		+ "and\r\n"
    		+ "account_name=:accountnbr\r\n"
    		+ "and\r\n"
    		+ "wc_icc=:wc_icc\r\n"
    		+ "and\r\n"
    		+ "state=:state\r\n"
    		+ "and\r\n"
    		+ "lata=:lata\r\n"
    		+ "and\r\n"
    		+ "cic=:cic\r\n"
    		+ "and\r\n"
    		+ "billing_period=:billing_period\r\n"
    		+ "group by BILLING_PERIOD,CUSTOMER_NAME, ACCOUNT_NAME, BILL_TYPE, MARKET_ID,\r\n"
    		+ "WC_ICC,STATE,LATA, CIC,end_office) ccabs ,\r\n"
    		+ "(select\r\n"
    		+ "BILLING_PERIOD,CUSTOMER_NAME, ACCOUNT_NAME, BILL_TYPE, MARKET_ID,\r\n"
    		+ "WC_ICC,STATE, LATA, CIC,end_office,sum(CHARGE) CHARGE\r\n"
    		+ "from\r\n"
    		+ "sv_charge\r\n"
    		+ "where\r\n"
    		+ "record_type_id=2\r\n"
    		+ "and\r\n"
    		+ "account_name=:accountnbr\r\n"
    		+ "and\r\n"
    		+ "wc_icc=:wc_icc\r\n"
    		+ "and\r\n"
    		+ "state=:state\r\n"
    		+ "and\r\n"
    		+ "lata=:lata\r\n"
    		+ "and\r\n"
    		+ "cic=:cic\r\n"
    		+ "and\r\n"
    		+ "billing_period=:billing_period\r\n" 		
    		+ "group by BILLING_PERIOD,CUSTOMER_NAME, ACCOUNT_NAME, BILL_TYPE, MARKET_ID,\r\n"
    		+ "WC_ICC,STATE, LATA, CIC,end_office) sv\r\n"
    		+ "where\r\n"
    		+ "ccabs.account_Name=sv.account_name(+)\r\n"
    		+ "and\r\n"
    		+ "ccabs.wc_icc=sv.wc_icc(+)\r\n"
    		+ "and\r\n"
    		+ "ccabs.state=sv.state(+)\r\n"
    		+ "and\r\n"
    		+ "ccabs.lata=sv.lata(+)\r\n"
    		+ "and\r\n"
    		+ "ccabs.end_office=sv.end_office(+)", nativeQuery = true)
 
    
      
    List<String> findByLevel2(@Param("accountnbr") String accountnbr,@Param("wc_icc") String wc_icc,
    		@Param("state") String state,@Param("lata") int lata,
    		@Param("cic") int cic,@Param("billing_period") int billing_period);
    
    
    //level3
    
    @Query(value ="select \r\n"
    		+ "ccabs.ACCOUNT_NAME,ccabs.MARKET_ID,ccabs.WC_ICC,ccabs.state,\r\n"
    		+ "ccabs.LATA,ccabs.CIC,ccabs.end_office,ccabs.traffic_type,\r\n"
    		+ "ccabs.charge ccabs_charge,\r\n"
    		+ "sv.charge sv_charge,(sv.charge-ccabs.charge) diff_charge,ccabs.BILLING_PERIOD from\r\n"
    		+ "(select \r\n"
    		+ "BILLING_PERIOD,CUSTOMER_NAME, ACCOUNT_NAME, BILL_TYPE, MARKET_ID, \r\n"
    		+ "WC_ICC,STATE,LATA, CIC,end_office,Traffic_type,sum(CHARGE) CHARGE \r\n"
    		+ "from\r\n"
    		+ "ccabs_charge\r\n"
    		+ "where \r\n"
    		+ "record_type_id=2\r\n"
    		+ "and\r\n"
    		+ "billing_period=:billing_period\r\n"
    		+ "and\r\n"
    		+ "account_name=:accountnbr\r\n"
    		+ "and\r\n"
    		+ "wc_icc=:wc_icc\r\n"
    		+ "and\r\n"
    		+ "state=:state\r\n"
    		+ "and\r\n"
    		+ "lata=:lata\r\n"
    		+ "and\r\n"
    		+ "cic=:cic\r\n"
    		+ "and\r\n"
    		+ "end_office=:end_office\r\n"
    		+ "group by BILLING_PERIOD,CUSTOMER_NAME, ACCOUNT_NAME, BILL_TYPE, MARKET_ID, \r\n"
    		+ "WC_ICC,STATE, LATA, CIC,end_office,traffic_type) ccabs,\r\n"
    		+ "(\r\n"
    		+ "select \r\n"
    		+ "BILLING_PERIOD,CUSTOMER_NAME, ACCOUNT_NAME, BILL_TYPE, MARKET_ID, \r\n"
    		+ "WC_ICC,STATE, LATA, CIC,end_office,traffic_type,sum(CHARGE) CHARGE \r\n"
    		+ "from\r\n"
    		+ "sv_charge\r\n"
    		+ "where \r\n"
    		+ "record_type_id=2\r\n"
    		+ "and\r\n"
    		+ "billing_period=:billing_period\r\n"
    		+ "and\r\n"
    		+ "account_name=:accountnbr\r\n"
    		+ "and\r\n"
    		+ "wc_icc=:wc_icc\r\n"
    		+ "and\r\n"
    		+ "state=:state\r\n"
    		+ "and\r\n"
    		+ "lata=:lata\r\n"
    		+ "and\r\n"
    		+ "cic=:cic\r\n"
    		+ "and\r\n"
    		+ "end_office=:end_office\r\n"
    		+ "group by BILLING_PERIOD,CUSTOMER_NAME, ACCOUNT_NAME, BILL_TYPE, MARKET_ID, \r\n"
    		+ "WC_ICC,STATE, LATA, CIC,end_office,traffic_type) sv\r\n"
    		+ "where \r\n"
    		+ "ccabs.account_Name=sv.account_name(+)\r\n"
    		+ "and\r\n"
    		+ "ccabs.wc_icc=sv.wc_icc(+)\r\n"
    		+ "and\r\n"
    		+ "ccabs.state=sv.state(+)\r\n"
    		+ "and\r\n"
    		+ "ccabs.lata=sv.lata(+)\r\n"
    		+ "and\r\n"
    		+ "ccabs.end_office=sv.end_office(+)\r\n"
    		+ "and\r\n"
    		+ "ccabs.traffic_type=sv.traffic_type(+)", nativeQuery = true)
    
    List<String> findByLevel3(@Param("accountnbr") String accountnbr,@Param("wc_icc") String wc_icc,
    		@Param("state") String state,@Param("lata") int lata,
    		@Param("cic") int cic,@Param("end_office") String end_office,@Param("billing_period") int billing_period);
    
    
    
    //level4    
    @Query(value ="select \r\n"
    		+ "ccabs.ACCOUNT_NAME,ccabs.MARKET_ID,ccabs.WC_ICC,ccabs.state,\r\n"
    		+ "ccabs.LATA,ccabs.CIC,ccabs.end_office,ccabs.traffic_type,ccabs.JURISDICTION_NAME,\r\n"
    		+ "ccabs.charge ccabs_charge,\r\n"
    		+ "sv.charge sv_charge,(sv.charge-ccabs.charge) diff_charge,ccabs.BILLING_PERIOD from\r\n"
    		+ "(select \r\n"
    		+ "BILLING_PERIOD,CUSTOMER_NAME, ACCOUNT_NAME, BILL_TYPE, MARKET_ID, \r\n"
    		+ "WC_ICC,state, LATA, CIC,end_office,Traffic_type,JURISDICTION_NAME,sum(CHARGE) CHARGE \r\n"
    		+ "from\r\n"
    		+ "ccabs_charge\r\n"
    		+ "where \r\n"
    		+ "record_type_id=2\r\n"
    		+ "and\r\n"
    		+ "billing_period=:billing_period\r\n"
    		+ "and\r\n"
    		+ "account_name=:accountnbr\r\n"
    		+ "and\r\n"
    		+ "wc_icc=:wc_icc\r\n"
    		+ "and\r\n"
    		+ "state=:state\r\n"
    		+ "and\r\n"
    		+ "lata=:lata\r\n"
    		+ "and\r\n"
    		+ "cic=:cic\r\n"
    		+ "and\r\n"
    		+ "end_office=:end_office\r\n"
    		+ "and\r\n"
    		+ "traffic_type=:traffic_type\r\n"
    		+ "group by BILLING_PERIOD,CUSTOMER_NAME, ACCOUNT_NAME, BILL_TYPE, MARKET_ID, \r\n"
    		+ "WC_ICC,state, LATA, CIC,end_office,traffic_type,JURISDICTION_NAME) ccabs,\r\n"
    		+ "(select \r\n"
    		+ "BILLING_PERIOD,CUSTOMER_NAME, ACCOUNT_NAME, BILL_TYPE, MARKET_ID, \r\n"
    		+ "WC_ICC, state,LATA, CIC,end_office,traffic_type,JURISDICTION_NAME,sum(CHARGE) CHARGE \r\n"
    		+ "from\r\n"
    		+ "sv_charge\r\n"
    		+ "where \r\n"
    		+ "record_type_id=2\r\n"
    		+ "and\r\n"
    		+ "billing_period=:billing_period\r\n"
    		+ "and\r\n"
    		+ "account_name=:accountnbr\r\n"
    		+ "and\r\n"
    		+ "wc_icc=:wc_icc\r\n"
    		+ "and\r\n"
    		+ "state=:state\r\n"
    		+ "and\r\n"
    		+ "lata=:lata\r\n"
    		+ "and\r\n"
    		+ "cic=:cic\r\n"
    		+ "and\r\n"
    		+ "end_office=:end_office\r\n"
    		+ "and\r\n"
    		+ "traffic_type=:traffic_type\r\n"
    		+ "group by BILLING_PERIOD,CUSTOMER_NAME, ACCOUNT_NAME, BILL_TYPE, MARKET_ID, \r\n"
    		+ "WC_ICC,state, LATA, CIC,end_office,traffic_type,JURISDICTION_NAME) sv\r\n"
    		+ "where \r\n"
    		+ "ccabs.account_Name=sv.account_name(+)\r\n"
    		+ "and\r\n"
    		+ "ccabs.wc_icc=sv.wc_icc(+)\r\n"
    		+ "and\r\n"
    		+ "ccabs.state=sv.state(+)\r\n"
    		+ "and\r\n"
    		+ "ccabs.lata=sv.lata(+)\r\n"
    		+ "and\r\n"
    		+ "ccabs.end_office=sv.end_office(+)\r\n"
    		+ "and\r\n"
    		+ "ccabs.traffic_type=sv.traffic_type(+)\r\n"
    		+ "and\r\n"
    		+ "ccabs.JURISDICTION_NAME=sv.JURISDICTION_NAME (+)", nativeQuery = true)
    
    List<String> findByLevel4(@Param("accountnbr") String accountnbr,@Param("wc_icc") String wc_icc,
    		@Param("state") String state,@Param("lata") int lata,
    		@Param("cic") int cic,@Param("end_office") String end_office,@Param("traffic_type") int traffic_type,
    		@Param("billing_period") int billing_period);
    
    
  //level4    
    @Query(value ="select\r\n"
    		+ "ccabs.ACCOUNT_NAME,ccabs.MARKET_ID,ccabs.WC_ICC,ccabs.state,\r\n"
    		+ "ccabs.LATA,ccabs.CIC,ccabs.end_office,ccabs.traffic_type,ccabs.JURISDICTION_NAME,ccabs.IS_VOIP,\r\n"
    		+ "ccabs.charge ccabs_charge,\r\n"
    		+ "sv.charge sv_charge,(sv.charge-ccabs.charge) diff_charge,ccabs.BILLING_PERIOD from\r\n"
    		+ "(select * from ccabs_charge\r\n"
    		+ "where\r\n"
    		+ "record_type_id=2\r\n"
    		+ "and\r\n"
    		+ "billing_period=:billing_period\r\n"
    		+ "and\r\n"
    		+ "account_name=:accountnbr\r\n"
    		+ "and\r\n"
    		+ "wc_icc=:wc_icc\r\n"
    		+ "and\r\n"
    		+ "state=:state\r\n"
    		+ "and\r\n"
    		+ "lata=:lata\r\n"
    		+ "and\r\n"
    		+ "cic=:cic\r\n"
    		+ "and\r\n"
    		+ "end_office=:end_office\r\n"
    		+ "and\r\n"
    		+ "traffic_type=:traffic_type\r\n"
    		+ "and\r\n"
    		+ "JURISDICTION_NAME=:jurisdiction) ccabs,\r\n"
    		+ "(select * from sv_charge\r\n"
    		+ "where\r\n"
    		+ "record_type_id=2\r\n"
    		+ "and\r\n"
    		+ "billing_period=:billing_period\r\n"
    		+ "and\r\n"
    		+ "account_name=:accountnbr\r\n"
    		+ "and\r\n"
    		+ "wc_icc=:wc_icc\r\n"
    		+ "and\r\n"
    		+ "state=:state\r\n"
    		+ "and\r\n"
    		+ "lata=:lata\r\n"
    		+ "and\r\n"
    		+ "cic=:cic\r\n"
    		+ "and\r\n"
    		+ "end_office=:end_office\r\n"
    		+ "and\r\n"
    		+ "traffic_type=:traffic_type\r\n"
    		+ "and\r\n"
    		+ "JURISDICTION_NAME=:jurisdiction) SV\r\n"
    		+ "where\r\n"
    		+ "ccabs.account_Name=sv.account_name(+)\r\n"
    		+ "and\r\n"
    		+ "ccabs.wc_icc=sv.wc_icc(+)\r\n"
    		+ "and\r\n"
    		+ "ccabs.state=sv.state(+)\r\n"
    		+ "and\r\n"
    		+ "ccabs.lata=sv.lata(+)\r\n"
    		+ "and\r\n"
    		+ "ccabs.end_office=sv.end_office(+)\r\n"
    		+ "and\r\n"
    		+ "ccabs.traffic_type=sv.traffic_type(+)\r\n"
    		+ "and\r\n"
    		+ "ccabs.JURISDICTION_NAME=sv.JURISDICTION_NAME (+)\r\n"
    		+ "and\r\n"
    		+ "ccabs.IS_VOIP=sv.IS_VOIP(+)", nativeQuery = true)
    
    List<String> findByLevel5(@Param("accountnbr") String accountnbr,@Param("wc_icc") String wc_icc,
    		@Param("state") String state,@Param("lata") int lata,
    		@Param("cic") int cic,@Param("end_office") String end_office,@Param("traffic_type") int traffic_type,
    		@Param("jurisdiction") String jurisdiction,@Param("billing_period") int billing_period);
    
    
    
    //overallprojection
    
    @Query(value ="SELECT \r\n"
    		+ "NVL(CABS.BILLING_PERIOD,SV.BILLING_PERIOD) BILLING_PERIOD,\r\n"
    		+ "NVL(CABS.BILL_TYPE,SV.BILL_TYPE) BILL_TYPE,\r\n"
    		+ "CABS.CHARGE CCABS_CHARGE,\r\n"
    		+ "SV.CHARGE SV_CHARGE,\r\n"
    		+ "(SV.CHARGE-CABS.CHARGE) DIFF_CHARGE,\r\n"
    		+ "CABS.USAGE CCABS_USAGE,\r\n"
    		+ "SV.USAGE SV_USAGE,\r\n"
    		+ "(SV.USAGE-CABS.USAGE) DIFF_USAGE,\r\n"
    		+ "CABS.VOLUME CCABS_VOLUME,\r\n"
    		+ "SV.VOLUME SV_VOLUME,\r\n"
    		+ "(SV.VOLUME-CABS.VOLUME) DIFF_VOLUME \r\n"
    		+ "FROM \r\n"
    		+ "(SELECT BILLING_PERIOD,BILL_TYPE,SUM(CHARGE) CHARGE,SUM(USAGE) USAGE,SUM(VOLUME) VOLUME\r\n"
    		+ "FROM \r\n"
    		+ "CCABS_CHARGE \r\n"
    		+ "WHERE RECORD_TYPE_ID=2 \r\n"
    		+ "GROUP BY  BILLING_PERIOD,BILL_TYPE) CABS  FULL JOIN\r\n"
    		+ "(SELECT BILLING_PERIOD,BILL_TYPE,SUM(CHARGE) CHARGE,SUM(USAGE) USAGE,SUM(VOLUME) VOLUME\r\n"
    		+ "FROM \r\n"
    		+ "SV_CHARGE \r\n"
    		+ "WHERE RECORD_TYPE_ID=2 \r\n"
    		+ "GROUP BY BILLING_PERIOD,BILL_TYPE) SV\r\n"
    		+ "ON (CABS.BILL_TYPE=SV.BILL_TYPE)\r\n"
    		+ "WHERE\r\n"
    		+ "CABS.BILLING_PERIOD=SV.BILLING_PERIOD\r\n"
    		+ "UNION\r\n"
    		+ "SELECT \r\n"
    		+ "NVL(CABS.BILLING_PERIOD,SV.BILLING_PERIOD) BILLING_PERIOD,\r\n"
    		+ "'SUMMARY' BILL_TYPE,\r\n"
    		+ "CABS.CHARGE CABS_CHARGE,\r\n"
    		+ "SV.CHARGE SV_CHARGE,\r\n"
    		+ "(SV.CHARGE-CABS.CHARGE) DIFF_CHARGE,\r\n"
    		+ "CABS.USAGE CABS_USAGE,\r\n"
    		+ "SV.USAGE SV_USAGE,\r\n"
    		+ "(SV.USAGE-CABS.USAGE) DIFF_USAGE,\r\n"
    		+ "CABS.VOLUME CABS_VOLUME,\r\n"
    		+ "SV.VOLUME SV_VOLUME,\r\n"
    		+ "(SV.VOLUME-CABS.VOLUME) DIFF_VOLUME \r\n"
    		+ "FROM \r\n"
    		+ "(SELECT BILLING_PERIOD,SUM(CHARGE) CHARGE,SUM(USAGE) USAGE,SUM(VOLUME) VOLUME\r\n"
    		+ "FROM \r\n"
    		+ "CCABS_CHARGE \r\n"
    		+ "WHERE RECORD_TYPE_ID=2 \r\n"
    		+ "GROUP BY  BILLING_PERIOD) CABS  FULL JOIN\r\n"
    		+ "(SELECT BILLING_PERIOD,SUM(CHARGE) CHARGE,SUM(USAGE) USAGE,SUM(VOLUME) VOLUME\r\n"
    		+ "FROM \r\n"
    		+ "SV_CHARGE \r\n"
    		+ "WHERE RECORD_TYPE_ID=2 \r\n"
    		+ "GROUP BY BILLING_PERIOD) SV\r\n"
    		+ "ON (CABS.BILLING_PERIOD=SV.BILLING_PERIOD)\r\n"
    		+ "ORDER BY 2", nativeQuery = true)
    		List<String> findoverallproj();
   
    //market level
    @Query(value ="SELECT \r\n"
    		+ "NVL(CABS.BILLING_PERIOD,SV.BILLING_PERIOD) BILLING_PERIOD,\r\n"
    		+ "NVL(CABS.BILL_TYPE,SV.BILL_TYPE) BILL_TYPE,\r\n"
    		+ "NVL(CABS.MARKET_ID,SV.MARKET_ID) MARKET_ID,\r\n"
    		+ "CABS.CHARGE CCABS_CHARGE,\r\n"
    		+ "SV.CHARGE SV_CHARGE,\r\n"
    		+ "(SV.CHARGE-CABS.CHARGE) DIFF_CHARGE,\r\n"
    		+ "CABS.USAGE CCABS_USAGE,\r\n"
    		+ "SV.USAGE SV_USAGE,\r\n"
    		+ "(SV.USAGE-CABS.USAGE) DIFF_USAGE,\r\n"
    		+ "CABS.VOLUME CCABS_VOLUME,\r\n"
    		+ "SV.VOLUME SV_VOLUME,\r\n"
    		+ "(SV.VOLUME-CABS.VOLUME) DIFF_VOLUME \r\n"
    		+ "FROM \r\n"
    		+ "(SELECT BILLING_PERIOD,BILL_TYPE,MARKET_ID,SUM(CHARGE) CHARGE,SUM(USAGE) USAGE,SUM(VOLUME) VOLUME\r\n"
    		+ "FROM \r\n"
    		+ "CCABS_CHARGE \r\n"
    		+ "WHERE RECORD_TYPE_ID=2 \r\n"
    		+ "GROUP BY  BILLING_PERIOD,BILL_TYPE,MARKET_ID) CABS  FULL JOIN\r\n"
    		+ "(SELECT BILLING_PERIOD,BILL_TYPE,MARKET_ID,SUM(CHARGE) CHARGE,SUM(USAGE) USAGE,SUM(VOLUME) VOLUME\r\n"
    		+ "FROM \r\n"
    		+ "SV_CHARGE \r\n"
    		+ "WHERE RECORD_TYPE_ID=2 \r\n"
    		+ "GROUP BY BILLING_PERIOD,BILL_TYPE,MARKET_ID) SV\r\n"
    		+ "ON (CABS.MARKET_ID=SV.MARKET_ID)\r\n"
    		+ "WHERE\r\n"
    		+ "CABS.BILL_TYPE=SV.BILL_TYPE\r\n"
    		+ "AND\r\n"
    		+ "CABS.BILLING_PERIOD=SV.BILLING_PERIOD\r\n"
    		+ "UNION\r\n"
    		+ "SELECT \r\n"
    		+ "NVL(CABS.BILLING_PERIOD,SV.BILLING_PERIOD) BILLING_PERIOD,\r\n"
    		+ "'SUMMARY' BILL_TYPE,\r\n"
    		+ "NVL(CABS.MARKET_ID,SV.MARKET_ID) MARKET_ID,\r\n"
    		+ "CABS.CHARGE CABS_CHARGE,\r\n"
    		+ "SV.CHARGE SV_CHARGE,\r\n"
    		+ "(SV.CHARGE-CABS.CHARGE) DIFF_CHARGE,\r\n"
    		+ "CABS.USAGE CABS_USAGE,\r\n"
    		+ "SV.USAGE SV_USAGE,\r\n"
    		+ "(SV.USAGE-CABS.USAGE) DIFF_USAGE,\r\n"
    		+ "CABS.VOLUME CABS_VOLUME,\r\n"
    		+ "SV.VOLUME SV_VOLUME,\r\n"
    		+ "(SV.VOLUME-CABS.VOLUME) DIFF_VOLUME \r\n"
    		+ "FROM \r\n"
    		+ "(SELECT BILLING_PERIOD,MARKET_ID,SUM(CHARGE) CHARGE,SUM(USAGE) USAGE,SUM(VOLUME) VOLUME\r\n"
    		+ "FROM \r\n"
    		+ "CCABS_CHARGE \r\n"
    		+ "WHERE RECORD_TYPE_ID=2 \r\n"
    		+ "GROUP BY  BILLING_PERIOD,MARKET_ID) CABS  FULL JOIN\r\n"
    		+ "(SELECT BILLING_PERIOD,MARKET_ID,SUM(CHARGE) CHARGE,SUM(USAGE) USAGE,SUM(VOLUME) VOLUME\r\n"
    		+ "FROM \r\n"
    		+ "SV_CHARGE \r\n"
    		+ "WHERE RECORD_TYPE_ID=2 \r\n"
    		+ "GROUP BY BILLING_PERIOD,MARKET_ID) SV\r\n"
    		+ "ON (CABS.MARKET_ID=SV.MARKET_ID)\r\n"
    		+ "WHERE\r\n"
    		+ "CABS.BILLING_PERIOD=SV.BILLING_PERIOD\r\n"
    		+ "ORDER BY 3,2", nativeQuery = true) List<String> findmarketlevel();
    
    //wcicc state lata cic
    @Query(value ="SELECT \r\n"
    		+ "NVL(CABS.BILLING_PERIOD,SV.BILLING_PERIOD) BILLING_PERIOD,\r\n"
    		+ "NVL(CABS.BILL_TYPE,SV.BILL_TYPE) BILL_TYPE,\r\n"
    		+ "NVL(CABS.WC_ICC,SV.WC_ICC) WC_ICC,\r\n"
    		+ "NVL(CABS.STATE,SV.STATE) STATE,\r\n"
    		+ "NVL(CABS.LATA,SV.LATA) LATA,\r\n"
    		+ "NVL(CABS.CIC,SV.CIC) CIC,\r\n"
    		+ "CABS.CHARGE CCABS_CHARGE,\r\n"
    		+ "SV.CHARGE SV_CHARGE,\r\n"
    		+ "(SV.CHARGE-CABS.CHARGE) DIFF_CHARGE,\r\n"
    		+ "CABS.USAGE CCABS_USAGE,\r\n"
    		+ "SV.USAGE SV_USAGE,\r\n"
    		+ "(SV.USAGE-CABS.USAGE) DIFF_USAGE,\r\n"
    		+ "CABS.VOLUME CCABS_VOLUME,\r\n"
    		+ "SV.VOLUME SV_VOLUME,\r\n"
    		+ "(SV.VOLUME-CABS.VOLUME) DIFF_VOLUME \r\n"
    		+ "FROM \r\n"
    		+ "(SELECT BILLING_PERIOD,BILL_TYPE,WC_ICC,STATE,LATA,CIC,SUM(CHARGE) CHARGE,SUM(USAGE) USAGE,SUM(VOLUME) VOLUME\r\n"
    		+ "FROM \r\n"
    		+ "CCABS_CHARGE \r\n"
    		+ "WHERE RECORD_TYPE_ID=2 \r\n"
    		+ "GROUP BY  BILLING_PERIOD,BILL_TYPE,WC_ICC,STATE,LATA,CIC) CABS  FULL JOIN\r\n"
    		+ "(SELECT BILLING_PERIOD,BILL_TYPE,WC_ICC,STATE,LATA,CIC,SUM(CHARGE) CHARGE,SUM(USAGE) USAGE,SUM(VOLUME) VOLUME\r\n"
    		+ "FROM \r\n"
    		+ "SV_CHARGE \r\n"
    		+ "WHERE RECORD_TYPE_ID=2 \r\n"
    		+ "GROUP BY BILLING_PERIOD,BILL_TYPE,WC_ICC,STATE,LATA,CIC) SV\r\n"
    		+ "ON (CABS.WC_ICC=SV.WC_ICC AND CABS.STATE=SV.STATE AND CABS.LATA=SV.LATA)\r\n"
    		+ "WHERE\r\n"
    		+ "CABS.BILL_TYPE=SV.BILL_TYPE\r\n"
    		+ "AND\r\n"
    		+ "CABS.BILLING_PERIOD=SV.BILLING_PERIOD\r\n"
    		+ "UNION\r\n"
    		+ "SELECT \r\n"
    		+ "NVL(CABS.BILLING_PERIOD,SV.BILLING_PERIOD) BILLING_PERIOD,\r\n"
    		+ "'SUMMARY' BILL_TYPE,\r\n"
    		+ "NVL(CABS.WC_ICC,SV.WC_ICC) WC_ICC,\r\n"
    		+ "NVL(CABS.STATE,SV.STATE) STATE,\r\n"
    		+ "NVL(CABS.LATA,SV.LATA) LATA,\r\n"
    		+ "NVL(CABS.CIC,SV.CIC) CIC,\r\n"
    		+ "CABS.CHARGE CABS_CHARGE,\r\n"
    		+ "SV.CHARGE SV_CHARGE,\r\n"
    		+ "(SV.CHARGE-CABS.CHARGE) DIFF_CHARGE,\r\n"
    		+ "CABS.USAGE CABS_USAGE,\r\n"
    		+ "SV.USAGE SV_USAGE,\r\n"
    		+ "(SV.USAGE-CABS.USAGE) DIFF_USAGE,\r\n"
    		+ "CABS.VOLUME CABS_VOLUME,\r\n"
    		+ "SV.VOLUME SV_VOLUME,\r\n"
    		+ "(SV.VOLUME-CABS.VOLUME) DIFF_VOLUME \r\n"
    		+ "FROM \r\n"
    		+ "(SELECT BILLING_PERIOD,WC_ICC,STATE,LATA,CIC,SUM(CHARGE) CHARGE,SUM(USAGE) USAGE,SUM(VOLUME) VOLUME\r\n"
    		+ "FROM \r\n"
    		+ "CCABS_CHARGE \r\n"
    		+ "WHERE RECORD_TYPE_ID=2 \r\n"
    		+ "GROUP BY  BILLING_PERIOD,WC_ICC,STATE,LATA,CIC) CABS  FULL JOIN\r\n"
    		+ "(SELECT BILLING_PERIOD,WC_ICC,STATE,LATA,CIC,SUM(CHARGE) CHARGE,SUM(USAGE) USAGE,SUM(VOLUME) VOLUME\r\n"
    		+ "FROM \r\n"
    		+ "SV_CHARGE \r\n"
    		+ "WHERE RECORD_TYPE_ID=2 \r\n"
    		+ "GROUP BY BILLING_PERIOD,WC_ICC,STATE,LATA,CIC) SV\r\n"
    		+ "ON (CABS.WC_ICC=SV.WC_ICC AND CABS.STATE=SV.STATE AND CABS.LATA=SV.LATA)\r\n"
    		+ "WHERE\r\n"
    		+ "CABS.BILLING_PERIOD=SV.BILLING_PERIOD\r\n"
    		+ "ORDER BY 3,2", nativeQuery = true) List<String> findwslc();
    
    
  //Endoffice
    @Query(value ="SELECT \r\n"
    		+ "NVL(CABS.BILLING_PERIOD,SV.BILLING_PERIOD) BILLING_PERIOD,\r\n"
    		+ "NVL(CABS.BILL_TYPE,SV.BILL_TYPE) BILL_TYPE,\r\n"
    		+ "NVL(CABS.END_OFFICE,SV.END_OFFICE) END_OFFICE,\r\n"
    		+ "CABS.CHARGE CCABS_CHARGE,\r\n"
    		+ "SV.CHARGE SV_CHARGE,\r\n"
    		+ "(SV.CHARGE-CABS.CHARGE) DIFF_CHARGE,\r\n"
    		+ "CABS.USAGE CCABS_USAGE,\r\n"
    		+ "SV.USAGE SV_USAGE,\r\n"
    		+ "(SV.USAGE-CABS.USAGE) DIFF_USAGE,\r\n"
    		+ "CABS.VOLUME CCABS_VOLUME,\r\n"
    		+ "SV.VOLUME SV_VOLUME,\r\n"
    		+ "(SV.VOLUME-CABS.VOLUME) DIFF_VOLUME \r\n"
    		+ "FROM \r\n"
    		+ "(SELECT BILLING_PERIOD,BILL_TYPE,END_OFFICE,SUM(CHARGE) CHARGE,SUM(USAGE) USAGE,SUM(VOLUME) VOLUME\r\n"
    		+ "FROM \r\n"
    		+ "CCABS_CHARGE \r\n"
    		+ "WHERE RECORD_TYPE_ID=2 \r\n"
    		+ "GROUP BY  BILLING_PERIOD,BILL_TYPE,END_OFFICE) CABS  FULL JOIN\r\n"
    		+ "(SELECT BILLING_PERIOD,BILL_TYPE,END_OFFICE,SUM(CHARGE) CHARGE,SUM(USAGE) USAGE,SUM(VOLUME) VOLUME\r\n"
    		+ "FROM \r\n"
    		+ "SV_CHARGE \r\n"
    		+ "WHERE RECORD_TYPE_ID=2 \r\n"
    		+ "GROUP BY BILLING_PERIOD,BILL_TYPE,END_OFFICE) SV\r\n"
    		+ "ON (CABS.END_OFFICE=SV.END_OFFICE)\r\n"
    		+ "WHERE\r\n"
    		+ "CABS.BILL_TYPE=SV.BILL_TYPE\r\n"
    		+ "AND\r\n"
    		+ "CABS.BILLING_PERIOD=SV.BILLING_PERIOD\r\n"
    		+ "UNION\r\n"
    		+ "SELECT \r\n"
    		+ "NVL(CABS.BILLING_PERIOD,SV.BILLING_PERIOD) BILLING_PERIOD,\r\n"
    		+ "'SUMMARY' BILL_TYPE,\r\n"
    		+ "NVL(CABS.END_OFFICE,SV.END_OFFICE) END_OFFICE,\r\n"
    		+ "CABS.CHARGE CABS_CHARGE,\r\n"
    		+ "SV.CHARGE SV_CHARGE,\r\n"
    		+ "(SV.CHARGE-CABS.CHARGE) DIFF_CHARGE,\r\n"
    		+ "CABS.USAGE CABS_USAGE,\r\n"
    		+ "SV.USAGE SV_USAGE,\r\n"
    		+ "(SV.USAGE-CABS.USAGE) DIFF_USAGE,\r\n"
    		+ "CABS.VOLUME CABS_VOLUME,\r\n"
    		+ "SV.VOLUME SV_VOLUME,\r\n"
    		+ "(SV.VOLUME-CABS.VOLUME) DIFF_VOLUME \r\n"
    		+ "FROM \r\n"
    		+ "(SELECT BILLING_PERIOD,END_OFFICE,SUM(CHARGE) CHARGE,SUM(USAGE) USAGE,SUM(VOLUME) VOLUME\r\n"
    		+ "FROM \r\n"
    		+ "CCABS_CHARGE \r\n"
    		+ "WHERE RECORD_TYPE_ID=2 \r\n"
    		+ "GROUP BY  BILLING_PERIOD,END_OFFICE) CABS  FULL JOIN\r\n"
    		+ "(SELECT BILLING_PERIOD,END_OFFICE,SUM(CHARGE) CHARGE,SUM(USAGE) USAGE,SUM(VOLUME) VOLUME\r\n"
    		+ "FROM \r\n"
    		+ "SV_CHARGE \r\n"
    		+ "WHERE RECORD_TYPE_ID=2 \r\n"
    		+ "GROUP BY BILLING_PERIOD,END_OFFICE) SV\r\n"
    		+ "ON (CABS.END_OFFICE=SV.END_OFFICE)\r\n"
    		+ "WHERE\r\n"
    		+ "CABS.BILLING_PERIOD=SV.BILLING_PERIOD\r\n"
    		+ "ORDER BY 3,2", nativeQuery = true) List<String> findendoffice();
    
  //Traffictype
    @Query(value ="SELECT \r\n"
    		+ "NVL(CABS.BILLING_PERIOD,SV.BILLING_PERIOD) BILLING_PERIOD,\r\n"
    		+ "NVL(CABS.BILL_TYPE,SV.BILL_TYPE) BILL_TYPE,\r\n"
    		+ "NVL(CABS.TRAFFIC_TYPE,SV.TRAFFIC_TYPE) TRAFFIC_TYPE,\r\n"
    		+ "CABS.CHARGE CCABS_CHARGE,\r\n"
    		+ "SV.CHARGE SV_CHARGE,\r\n"
    		+ "(SV.CHARGE-CABS.CHARGE) DIFF_CHARGE,\r\n"
    		+ "CABS.USAGE CCABS_USAGE,\r\n"
    		+ "SV.USAGE SV_USAGE,\r\n"
    		+ "(SV.USAGE-CABS.USAGE) DIFF_USAGE,\r\n"
    		+ "CABS.VOLUME CCABS_VOLUME,\r\n"
    		+ "SV.VOLUME SV_VOLUME,\r\n"
    		+ "(SV.VOLUME-CABS.VOLUME) DIFF_VOLUME \r\n"
    		+ "FROM \r\n"
    		+ "(SELECT BILLING_PERIOD,BILL_TYPE,TRAFFIC_TYPE,SUM(CHARGE) CHARGE,SUM(USAGE) USAGE,SUM(VOLUME) VOLUME\r\n"
    		+ "FROM \r\n"
    		+ "CCABS_CHARGE \r\n"
    		+ "WHERE RECORD_TYPE_ID=2 \r\n"
    		+ "GROUP BY  BILLING_PERIOD,BILL_TYPE,TRAFFIC_TYPE) CABS  FULL JOIN\r\n"
    		+ "(SELECT BILLING_PERIOD,BILL_TYPE,TRAFFIC_TYPE,SUM(CHARGE) CHARGE,SUM(USAGE) USAGE,SUM(VOLUME) VOLUME\r\n"
    		+ "FROM \r\n"
    		+ "SV_CHARGE \r\n"
    		+ "WHERE RECORD_TYPE_ID=2 \r\n"
    		+ "GROUP BY BILLING_PERIOD,BILL_TYPE,TRAFFIC_TYPE) SV\r\n"
    		+ "ON (CABS.TRAFFIC_TYPE=SV.TRAFFIC_TYPE)\r\n"
    		+ "WHERE\r\n"
    		+ "CABS.BILL_TYPE=SV.BILL_TYPE\r\n"
    		+ "AND\r\n"
    		+ "CABS.BILLING_PERIOD=SV.BILLING_PERIOD\r\n"
    		+ "UNION\r\n"
    		+ "SELECT \r\n"
    		+ "NVL(CABS.BILLING_PERIOD,SV.BILLING_PERIOD) BILLING_PERIOD,\r\n"
    		+ "'SUMMARY' BILL_TYPE,\r\n"
    		+ "NVL(CABS.TRAFFIC_TYPE,SV.TRAFFIC_TYPE) TRAFFIC_TYPE,\r\n"
    		+ "CABS.CHARGE CABS_CHARGE,\r\n"
    		+ "SV.CHARGE SV_CHARGE,\r\n"
    		+ "(SV.CHARGE-CABS.CHARGE) DIFF_CHARGE,\r\n"
    		+ "CABS.USAGE CABS_USAGE,\r\n"
    		+ "SV.USAGE SV_USAGE,\r\n"
    		+ "(SV.USAGE-CABS.USAGE) DIFF_USAGE,\r\n"
    		+ "CABS.VOLUME CABS_VOLUME,\r\n"
    		+ "SV.VOLUME SV_VOLUME,\r\n"
    		+ "(SV.VOLUME-CABS.VOLUME) DIFF_VOLUME \r\n"
    		+ "FROM \r\n"
    		+ "(SELECT BILLING_PERIOD,TRAFFIC_TYPE,SUM(CHARGE) CHARGE,SUM(USAGE) USAGE,SUM(VOLUME) VOLUME\r\n"
    		+ "FROM \r\n"
    		+ "CCABS_CHARGE \r\n"
    		+ "WHERE RECORD_TYPE_ID=2 \r\n"
    		+ "GROUP BY  BILLING_PERIOD,TRAFFIC_TYPE) CABS  FULL JOIN\r\n"
    		+ "(SELECT BILLING_PERIOD,TRAFFIC_TYPE,SUM(CHARGE) CHARGE,SUM(USAGE) USAGE,SUM(VOLUME) VOLUME\r\n"
    		+ "FROM \r\n"
    		+ "SV_CHARGE \r\n"
    		+ "WHERE RECORD_TYPE_ID=2 \r\n"
    		+ "GROUP BY BILLING_PERIOD,TRAFFIC_TYPE) SV\r\n"
    		+ "ON (CABS.TRAFFIC_TYPE=SV.TRAFFIC_TYPE)\r\n"
    		+ "WHERE\r\n"
    		+ "CABS.BILLING_PERIOD=SV.BILLING_PERIOD\r\n"
    		+ "ORDER BY 3,2", nativeQuery = true) List<String> findtraffictype();
  
  //jurisdiction
    @Query(value ="SELECT \r\n"
    		+ "NVL(CABS.BILLING_PERIOD,SV.BILLING_PERIOD) BILLING_PERIOD,\r\n"
    		+ "NVL(CABS.BILL_TYPE,SV.BILL_TYPE) BILL_TYPE,\r\n"
    		+ "NVL(CABS.JURISDICTION_NAME,SV.JURISDICTION_NAME) JURISDICTION_NAME,\r\n"
    		+ "CABS.CHARGE CCABS_CHARGE,\r\n"
    		+ "SV.CHARGE SV_CHARGE,\r\n"
    		+ "(SV.CHARGE-CABS.CHARGE) DIFF_CHARGE,\r\n"
    		+ "CABS.USAGE CCABS_USAGE,\r\n"
    		+ "SV.USAGE SV_USAGE,\r\n"
    		+ "(SV.USAGE-CABS.USAGE) DIFF_USAGE,\r\n"
    		+ "CABS.VOLUME CCABS_VOLUME,\r\n"
    		+ "SV.VOLUME SV_VOLUME,\r\n"
    		+ "(SV.VOLUME-CABS.VOLUME) DIFF_VOLUME \r\n"
    		+ "FROM \r\n"
    		+ "(SELECT BILLING_PERIOD,BILL_TYPE,JURISDICTION_NAME,SUM(CHARGE) CHARGE,SUM(USAGE) USAGE,SUM(VOLUME) VOLUME\r\n"
    		+ "FROM \r\n"
    		+ "CCABS_CHARGE \r\n"
    		+ "WHERE RECORD_TYPE_ID=2 \r\n"
    		+ "GROUP BY  BILLING_PERIOD,BILL_TYPE,JURISDICTION_NAME) CABS  FULL JOIN\r\n"
    		+ "(SELECT BILLING_PERIOD,BILL_TYPE,JURISDICTION_NAME,SUM(CHARGE) CHARGE,SUM(USAGE) USAGE,SUM(VOLUME) VOLUME\r\n"
    		+ "FROM \r\n"
    		+ "SV_CHARGE \r\n"
    		+ "WHERE RECORD_TYPE_ID=2 \r\n"
    		+ "GROUP BY BILLING_PERIOD,BILL_TYPE,JURISDICTION_NAME) SV\r\n"
    		+ "ON (CABS.JURISDICTION_NAME=SV.JURISDICTION_NAME)\r\n"
    		+ "WHERE\r\n"
    		+ "CABS.BILL_TYPE=SV.BILL_TYPE\r\n"
    		+ "AND\r\n"
    		+ "CABS.BILLING_PERIOD=SV.BILLING_PERIOD\r\n"
    		+ "UNION\r\n"
    		+ "SELECT \r\n"
    		+ "NVL(CABS.BILLING_PERIOD,SV.BILLING_PERIOD) BILLING_PERIOD,\r\n"
    		+ "'SUMMARY' BILL_TYPE,\r\n"
    		+ "NVL(CABS.JURISDICTION_NAME,SV.JURISDICTION_NAME) JURISDICTION_NAME,\r\n"
    		+ "CABS.CHARGE CABS_CHARGE,\r\n"
    		+ "SV.CHARGE SV_CHARGE,\r\n"
    		+ "(SV.CHARGE-CABS.CHARGE) DIFF_CHARGE,\r\n"
    		+ "CABS.USAGE CABS_USAGE,\r\n"
    		+ "SV.USAGE SV_USAGE,\r\n"
    		+ "(SV.USAGE-CABS.USAGE) DIFF_USAGE,\r\n"
    		+ "CABS.VOLUME CABS_VOLUME,\r\n"
    		+ "SV.VOLUME SV_VOLUME,\r\n"
    		+ "(SV.VOLUME-CABS.VOLUME) DIFF_VOLUME \r\n"
    		+ "FROM \r\n"
    		+ "(SELECT BILLING_PERIOD,JURISDICTION_NAME,SUM(CHARGE) CHARGE,SUM(USAGE) USAGE,SUM(VOLUME) VOLUME\r\n"
    		+ "FROM \r\n"
    		+ "CCABS_CHARGE \r\n"
    		+ "WHERE RECORD_TYPE_ID=2 \r\n"
    		+ "GROUP BY  BILLING_PERIOD,JURISDICTION_NAME) CABS  FULL JOIN\r\n"
    		+ "(SELECT BILLING_PERIOD,JURISDICTION_NAME,SUM(CHARGE) CHARGE,SUM(USAGE) USAGE,SUM(VOLUME) VOLUME\r\n"
    		+ "FROM \r\n"
    		+ "SV_CHARGE \r\n"
    		+ "WHERE RECORD_TYPE_ID=2 \r\n"
    		+ "GROUP BY BILLING_PERIOD,JURISDICTION_NAME) SV\r\n"
    		+ "ON (CABS.JURISDICTION_NAME=SV.JURISDICTION_NAME)\r\n"
    		+ "WHERE\r\n"
    		+ "CABS.BILLING_PERIOD=SV.BILLING_PERIOD\r\n"
    		+ "ORDER BY 3,2", nativeQuery = true) List<String> findjurisdiction();

  //voip
    @Query(value ="SELECT \r\n"
    		+ "NVL(CABS.BILLING_PERIOD,SV.BILLING_PERIOD) BILLING_PERIOD,\r\n"
    		+ "NVL(CABS.BILL_TYPE,SV.BILL_TYPE) BILL_TYPE,\r\n"
    		+ "NVL(CABS.IS_VOIP,SV.IS_VOIP) VOIP,\r\n"
    		+ "CABS.CHARGE CCABS_CHARGE,\r\n"
    		+ "SV.CHARGE SV_CHARGE,\r\n"
    		+ "(SV.CHARGE-CABS.CHARGE) DIFF_CHARGE,\r\n"
    		+ "CABS.USAGE CCABS_USAGE,\r\n"
    		+ "SV.USAGE SV_USAGE,\r\n"
    		+ "(SV.USAGE-CABS.USAGE) DIFF_USAGE,\r\n"
    		+ "CABS.VOLUME CCABS_VOLUME,\r\n"
    		+ "SV.VOLUME SV_VOLUME,\r\n"
    		+ "(SV.VOLUME-CABS.VOLUME) DIFF_VOLUME \r\n"
    		+ "FROM \r\n"
    		+ "(SELECT BILLING_PERIOD,BILL_TYPE,IS_VOIP,SUM(CHARGE) CHARGE,SUM(USAGE) USAGE,SUM(VOLUME) VOLUME\r\n"
    		+ "FROM \r\n"
    		+ "CCABS_CHARGE \r\n"
    		+ "WHERE RECORD_TYPE_ID=2 \r\n"
    		+ "GROUP BY  BILLING_PERIOD,BILL_TYPE,IS_VOIP) CABS  FULL JOIN\r\n"
    		+ "(SELECT BILLING_PERIOD,BILL_TYPE,IS_VOIP,SUM(CHARGE) CHARGE,SUM(USAGE) USAGE,SUM(VOLUME) VOLUME\r\n"
    		+ "FROM \r\n"
    		+ "SV_CHARGE \r\n"
    		+ "WHERE RECORD_TYPE_ID=2 \r\n"
    		+ "GROUP BY BILLING_PERIOD,BILL_TYPE,IS_VOIP) SV\r\n"
    		+ "ON (CABS.IS_VOIP=SV.IS_VOIP)\r\n"
    		+ "WHERE\r\n"
    		+ "CABS.BILL_TYPE=SV.BILL_TYPE\r\n"
    		+ "AND\r\n"
    		+ "CABS.BILLING_PERIOD=SV.BILLING_PERIOD\r\n"
    		+ "UNION\r\n"
    		+ "SELECT \r\n"
    		+ "NVL(CABS.BILLING_PERIOD,SV.BILLING_PERIOD) BILLING_PERIOD,\r\n"
    		+ "'SUMMARY' BILL_TYPE,\r\n"
    		+ "NVL(CABS.IS_VOIP,SV.IS_VOIP) VOIP,\r\n"
    		+ "CABS.CHARGE CABS_CHARGE,\r\n"
    		+ "SV.CHARGE SV_CHARGE,\r\n"
    		+ "(SV.CHARGE-CABS.CHARGE) DIFF_CHARGE,\r\n"
    		+ "CABS.USAGE CABS_USAGE,\r\n"
    		+ "SV.USAGE SV_USAGE,\r\n"
    		+ "(SV.USAGE-CABS.USAGE) DIFF_USAGE,\r\n"
    		+ "CABS.VOLUME CABS_VOLUME,\r\n"
    		+ "SV.VOLUME SV_VOLUME,\r\n"
    		+ "(SV.VOLUME-CABS.VOLUME) DIFF_VOLUME \r\n"
    		+ "FROM \r\n"
    		+ "(SELECT BILLING_PERIOD,IS_VOIP,SUM(CHARGE) CHARGE,SUM(USAGE) USAGE,SUM(VOLUME) VOLUME\r\n"
    		+ "FROM \r\n"
    		+ "CCABS_CHARGE \r\n"
    		+ "WHERE RECORD_TYPE_ID=2 \r\n"
    		+ "GROUP BY  BILLING_PERIOD,IS_VOIP) CABS  FULL JOIN\r\n"
    		+ "(SELECT BILLING_PERIOD,IS_VOIP,SUM(CHARGE) CHARGE,SUM(USAGE) USAGE,SUM(VOLUME) VOLUME\r\n"
    		+ "FROM \r\n"
    		+ "SV_CHARGE \r\n"
    		+ "WHERE RECORD_TYPE_ID=2 \r\n"
    		+ "GROUP BY BILLING_PERIOD,IS_VOIP) SV\r\n"
    		+ "ON (CABS.IS_VOIP=SV.IS_VOIP)\r\n"
    		+ "WHERE\r\n"
    		+ "CABS.BILLING_PERIOD=SV.BILLING_PERIOD\r\n"
    		+ "ORDER BY 3,2", nativeQuery = true) List<String> findvoip();
    
    //ccab count for bar chart
    @Query(value ="select\r\n"
    		+ "NVL(a.billing_period,b.billing_period) Billing_period,\r\n"
    		+ "NVL(a.bill_type,b.bill_type) bill_type,\r\n"
    		+ "a.CCABS_COUNT,\r\n"
    		+ "b.SV_COUNT\r\n"
    		+ "from\r\n"
    		+ "(select\r\n"
    		+ "billing_period,\r\n"
    		+ "bill_type,\r\n"
    		+ "count(distinct account_name) ccabs_count\r\n"
    		+ "from ccabs_charge\r\n"
    		+ "group by billing_period,bill_type\r\n"
    		+ "union\r\n"
    		+ "select\r\n"
    		+ "billing_period,\r\n"
    		+ "'TOTAL' bill_type,\r\n"
    		+ "count(distinct account_name)\r\n"
    		+ "from ccabs_charge\r\n"
    		+ "group by billing_period) a full join\r\n"
    		+ "(select\r\n"
    		+ "billing_period,\r\n"
    		+ "bill_type,\r\n"
    		+ "count(distinct account_name) SV_COUNT\r\n"
    		+ "from sv_charge\r\n"
    		+ "group by billing_period, bill_type\r\n"
    		+ "union\r\n"
    		+ "select\r\n"
    		+ "billing_period,\r\n"
    		+ "'TOTAL' bill_type,\r\n"
    		+ "count(distinct account_name)\r\n"
    		+ "from sv_charge\r\n"
    		+ "group by billing_period) b\r\n"
    		+ "on (a.billing_period=b.billing_period and a.bill_type=b.bill_type) order by 3", nativeQuery = true) List<String> findccabbar();

    
}
