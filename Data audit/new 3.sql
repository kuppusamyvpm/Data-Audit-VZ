    
--MKT_ID,WC_ICC,LATA,CIC level
With cabs as (
select 
BILLING_PERIOD,CUSTOMER_NAME, ACCOUNT_NAME, BILL_TYPE, MARKET_ID, 
WC_ICC, LATA, CIC,sum(USAGE_CHARGE) CHARGE 
from
cabs_usage_charge_aug
where 
record_type_id=8
and
billing_period=202009
and
account_name='BDF1200288'
group by BILLING_PERIOD,CUSTOMER_NAME, ACCOUNT_NAME, BILL_TYPE, MARKET_ID, 
WC_ICC, LATA, CIC),
sv as(
select 
BILLING_PERIOD,CUSTOMER_NAME, ACCOUNT_NAME, BILL_TYPE, MARKET_ID, 
WC_ICC, LATA, CIC,sum(USAGE_CHARGE) CHARGE 
from
sv_usage_charge_aug
where 
record_type_id=8
and
billing_period=202009
and
account_name='BDF1200288'
group by BILLING_PERIOD,CUSTOMER_NAME, ACCOUNT_NAME, BILL_TYPE, MARKET_ID, 
WC_ICC, LATA, CIC)
select 
cabs.BILLING_PERIOD,SV.CUSTOMER_NAME,cabs.ACCOUNT_NAME,cabs.BILL_TYPE,cabs.MARKET_ID,cabs.WC_ICC,cabs.LATA,cabs.CIC,
cabs.charge cabs_charge,
sv.charge sv_charge,(sv.charge-cabs.charge) diff_charge
from cabs,sv
where 
cabs.account_Name=sv.account_name(+)
and
cabs.wc_icc=sv.wc_icc
and
cabs.lata=sv.lata;


--END_OFFICE level
select
ccabs.ACCOUNT_NAME,ccabs.MARKET_ID,ccabs.WC_ICC,ccabs.STATE,ccabs.LATA,ccabs.CIC,ccabs.end_office,
ccabs.charge ccabs_charge,
sv.charge sv_charge,(sv.charge-ccabs.charge) diff_charge from
(select
BILLING_PERIOD,CUSTOMER_NAME, ACCOUNT_NAME, BILL_TYPE, MARKET_ID,
WC_ICC, STATE,LATA, CIC,end_office,sum(CHARGE) CHARGE
from
ccabs_charge
where
record_type_id=2
and
billing_period=202009
and
account_name='BDF1200288'
and
wc_icc='BF'
and
lata=120
and
cic=288
group by BILLING_PERIOD,CUSTOMER_NAME, ACCOUNT_NAME, BILL_TYPE, MARKET_ID,
WC_ICC,STATE,LATA, CIC,end_office),
(select
BILLING_PERIOD,CUSTOMER_NAME, ACCOUNT_NAME, BILL_TYPE, MARKET_ID,
WC_ICC,STATE, LATA, CIC,end_office,sum(USAGE_CHARGE) CHARGE
from
sv_charge
where
record_type_id=2
and
billing_period=202009
and
account_name='BDF1200288'
and
wc_icc='BF'
and
lata=120
and
cic=288
group by BILLING_PERIOD,CUSTOMER_NAME, ACCOUNT_NAME, BILL_TYPE, MARKET_ID,
WC_ICC,STATE, LATA, CIC,end_office)
where
ccabs.account_Name=sv.account_name(+)
and
ccabs.wc_icc=sv.wc_icc
and
ccabs.state=sv.state(+)
and
ccabs.lata=sv.lata
and
ccabs.end_office=sv.end_office;


--TRAFFIC_TYPE level
select 
ccabs.ACCOUNT_NAME,ccabs.MARKET_ID,ccabs.WC_ICC,ccabs.state,
ccabs.LATA,ccabs.CIC,ccabs.end_office,ccabs.traffic_type,
ccabs.charge ccabs_charge,
sv.charge sv_charge,(sv.charge-ccabs.charge) diff_charge,ccabs.BILLING_PERIOD from
(select 
BILLING_PERIOD,CUSTOMER_NAME, ACCOUNT_NAME, BILL_TYPE, MARKET_ID, 
WC_ICC,STATE,LATA, CIC,end_office,Traffic_type,sum(CHARGE) CHARGE 
from
ccabs_charge
where 
record_type_id=2
and
billing_period=202103
and
account_name='ADZ3586125'
and
wc_icc='XO'
and
state='MN'
and
lata=358
and
cic=125
and
end_office='PTLDMECMDS0'
group by BILLING_PERIOD,CUSTOMER_NAME, ACCOUNT_NAME, BILL_TYPE, MARKET_ID, 
WC_ICC,STATE, LATA, CIC,end_office,traffic_type) ccabs,
(
select 
BILLING_PERIOD,CUSTOMER_NAME, ACCOUNT_NAME, BILL_TYPE, MARKET_ID, 
WC_ICC,STATE, LATA, CIC,end_office,traffic_type,sum(CHARGE) CHARGE 
from
sv_charge
where 
record_type_id=2
and
account_name='ADZ3586125'
and
wc_icc='XO'
and
state='MN'
and
lata=358
and
cic=125
and
end_office='PTLDMECMDS0'
group by BILLING_PERIOD,CUSTOMER_NAME, ACCOUNT_NAME, BILL_TYPE, MARKET_ID, 
WC_ICC,STATE, LATA, CIC,end_office,traffic_type) sv
where 
ccabs.account_Name=sv.account_name(+)
and
ccabs.wc_icc=sv.wc_icc(+)
and
ccabs.state=sv.state(+)
and
ccabs.lata=sv.lata(+)
and
ccabs.end_office=sv.end_office(+)
and
ccabs.traffic_type=sv.traffic_type(+);


--JURISDICTION level
select 
ccabs.ACCOUNT_NAME,ccabs.MARKET_ID,ccabs.WC_ICC,ccabs.state,
ccabs.LATA,ccabs.CIC,ccabs.end_office,ccabs.traffic_type,ccabs.JURISDICTION,
ccabs.charge ccabs_charge,
sv.charge sv_charge,(sv.charge-ccabs.charge) diff_charge,ccabs.BILLING_PERIOD from
(select 
BILLING_PERIOD,CUSTOMER_NAME, ACCOUNT_NAME, BILL_TYPE, MARKET_ID, 
WC_ICC,state, LATA, CIC,end_office,Traffic_type,JURISDICTION,sum(CHARGE) CHARGE 
from
cabs_charge
where 
record_type_id=2
and
billing_period=202103
and
account_name='ADZ3586125'
and
wc_icc='XO'
and
state='MN'
and
lata=358
and
cic=125
and
end_office='PTLDMECMDS0'
and
traffic_type=5
group by BILLING_PERIOD,CUSTOMER_NAME, ACCOUNT_NAME, BILL_TYPE, MARKET_ID, 
WC_ICC,state, LATA, CIC,end_office,traffic_type,jurisdiction) ccabs,
(select 
BILLING_PERIOD,CUSTOMER_NAME, ACCOUNT_NAME, BILL_TYPE, MARKET_ID, 
WC_ICC, state,LATA, CIC,end_office,traffic_type,jurisdiction,sum(CHARGE) CHARGE 
from
sv_charge
where 
record_type_id=2
and
billing_period=202103
and
account_name='ADZ3586125'
and
wc_icc='XO'
and
state='MN'
and
lata=358
and
cic=125
and
end_office='PTLDMECMDS0'
and
traffic_type=5
group by BILLING_PERIOD,CUSTOMER_NAME, ACCOUNT_NAME, BILL_TYPE, MARKET_ID, 
WC_ICC,state, LATA, CIC,end_office,traffic_type,jurisdiction)
where 
ccabs.account_Name=sv.account_name(+)
and
ccabs.wc_icc=sv.wc_icc(+)
and
ccabs.state=sv.state(+)
and
ccabs.lata=sv.lata(+)
and
ccabs.end_office=sv.end_office(+)
and
ccabs.traffic_type=sv.traffic_type(+)
and
ccabs.jurisdiction=sv.JURISDICTION (+);


--VOIP level
select 
ccabs.ACCOUNT_NAME,ccabs.MARKET_ID,ccabs.WC_ICC,ccabs.state,
ccabs.LATA,ccabs.CIC,ccabs.end_office,ccabs.traffic_type,ccabs.JURISDICTION,ccabs.IS_VOIP,
ccabs.usage_charge ccabs_charge,
sv.usage_charge sv_charge,(sv.usage_charge-ccabs.usage_charge) diff_charge,ccabs.BILLING_PERIOD from
(select * from cabs_charge
where 
record_type_id=2
and
billing_period=202103
and
account_name='ADZ3586125'
and
wc_icc='XO'
and
state='MN'
and
lata=358
and
cic=125
and
end_office='PTLDMECMDS0'
and
traffic_type=5
and
JURISDICTION='INTERSTATE') ccabs,
(select * from sv_charge
where 
record_type_id=2
and
billing_period=202103
and
account_name='ADZ3586125'
and
wc_icc='XO'
and
state='MN'
and
lata=358
and
cic=125
and
end_office='PTLDMECMDS0'
and
traffic_type=5
and
JURISDICTION='INTERSTATE') SV
where 
ccabs.account_Name=sv.account_name(+)
and
ccabs.wc_icc=sv.wc_icc(+)
and
ccabs.state=sv.state(+)
and
ccabs.lata=sv.lata(+)
and
ccabs.end_office=sv.end_office(+)
and
ccabs.traffic_type=sv.traffic_type(+)
and
ccabs.jurisdiction=sv.JURISDICTION (+)
and
ccabs.IS_VOIP=sv.IS_VOIP(+);






