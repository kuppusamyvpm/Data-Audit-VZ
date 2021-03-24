//package com.charge.demo.daoController;
//
//
//import java.io.FileWriter;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//public class Dao_charge {
//   public static ResultSet RetrieveData() throws Exception {
//    
//      DriverManager.registerDriver(new com.oracle.jdbc.Driver());
//      String oracleUrl = "jdbc:oracle:thin:@localhost:1522:xe";
//      Connection con = DriverManager.getConnection(oracleUrl, "system", "root");
//      System.out.println("Connection established......");
//      Statement stmt = con.createStatement();
//      
//      //Retrieving the records
//      ResultSet rs = stmt.executeQuery("select\r\n"
//      		+ "ccabs.BILLING_PERIOD,SV.CUSTOMER_NAME,ccabs.ACCOUNT_NAME,ccabs.BILL_TYPE,ccabs.MARKET_ID,ccabs.WC_ICC,ccabs.LATA,ccabs.CIC,\r\n"
//      		+ "ccabs.charge ccabs_charge,\r\n"
//      		+ "sv.charge sv_charge,(sv.charge-ccabs.charge) diff_charge\r\n"
//      		+ "from (\r\n"
//      		+ "select\r\n"
//      		+ "BILLING_PERIOD,CUSTOMER_NAME, ACCOUNT_NAME, BILL_TYPE, MARKET_ID,\r\n"
//      		+ "WC_ICC, LATA, CIC,sum(Charge) CHARGE\r\n"
//      		+ "from\r\n"
//      		+ "ccabs_charge\r\n"
//      		+ "where\r\n"
//      		+ "record_type_id=2\r\n"
//      		+ "and\r\n"
//      		+ "billing_period=202103\r\n"
//      		+ "and\r\n"
//      		+ "account_name='ADZ3586125'\r\n"
//      		+ "group by BILLING_PERIOD,CUSTOMER_NAME, ACCOUNT_NAME, BILL_TYPE, MARKET_ID,\r\n"
//      		+ "WC_ICC, LATA, CIC) ccabs,\r\n"
//      		+ "(\r\n"
//      		+ "select\r\n"
//      		+ "BILLING_PERIOD,CUSTOMER_NAME, ACCOUNT_NAME, BILL_TYPE, MARKET_ID,\r\n"
//      		+ "WC_ICC, LATA, CIC,sum(CHARGE) CHARGE\r\n"
//      		+ "from\r\n"
//      		+ "sv_charge\r\n"
//      		+ "where\r\n"
//      		+ "record_type_id=2\r\n"
//      		+ "and\r\n"
//      		+ "billing_period=202103\r\n"
//      		+ "and\r\n"
//      		+ "account_name='ADZ3586125'\r\n"
//      		+ "group by BILLING_PERIOD,CUSTOMER_NAME, ACCOUNT_NAME, BILL_TYPE, MARKET_ID,\r\n"
//      		+ "WC_ICC, LATA, CIC) sv\r\n"
//      		+ "\r\n"
//      		+ "where\r\n"
//      		+ "ccabs.account_Name=sv.account_name(+)\r\n"
//      		+ "and\r\n"
//      		+ "ccabs.wc_icc=sv.wc_icc(+)\r\n"
//      		+ "and\r\n"
//      		+ "ccabs.lata=sv.lata(+);\r\n"
//      		+ "");
//      return rs;
//   }
//   
//   public static void main(String args[]) throws Exception {
//      //Creating a JSONObject object
//      JSONObject jsonObject = new JSONObject();
//      //Creating a json array
//      JSONArray array = new JSONArray();
//      ResultSet rs = RetrieveData();
//      //Inserting ResutlSet data into the json object
//      while(rs.next()) {
//         JSONObject record = new JSONObject();
//         //Inserting key-value pairs into the json object
//         record.put("billingPeriod", rs.getInt("BILLING_PERIOD"));
//         record.put("customerName", rs.getString("CUSTOMER_NAME"));
//         record.put("accountName", rs.getString("ACCOUNT_NAME"));
//         record.put("billType", rs.getString("BILL_TYPE"));
//         record.put("marketId", rs.getInt("MARKET_ID"));
//         record.put("wcicc", rs.getString("WC_ICC"));
//         record.put("lata", rs.getInt("LATA"));
//         record.put("cic", rs.getInt("CIC"));
//         record.put("ccabs_Charge", rs.getInt("CCABS_CHARGE"));
//         record.put("sv_Charge", rs.getInt("SV_CHARGE"));
//         record.put("differ_Charge", rs.getInt("DIFF_CHARGE"));
//         array.add(record);
//      }
//      jsonObject.put("Players_data", array);
//      try {
//         FileWriter file = new FileWriter("E:/output.json");
//         file.write(jsonObject.toJSONString());
//         file.close();
//      } catch (IOException e) {
//         // TODO Auto-generated catch block
//         e.printStackTrace();
//      }
//      System.out.println("JSON file created......");
//   }
//}