/* *****************************************************************************
       File:           DATA_COMPARISON_DDL.sql
       Create_DATE:    10-03-2021
       Creator:        Kuppusamy V

==================================================================================

DESCRIPTION:

SQL script for creating TABLES,INDEXES and TRIGGER for Data Comparison. */

create table ETLD01.FS_PBW_1101_CHRG_DTL
(
  BILLING_PERIOD                           NUMBER(6) NOT NULL,
  CUSTOMER_NAME                            VARCHAR2 (30), 
  TO_ACCT_ID                               NUMBER (20),
  ACCOUNT_NBR                              VARCHAR2 (30) NOT NULL, 
  CUSTOMER_SUB_TYPE                        VARCHAR2 (10), 
  MARKET_ID                                NUMBER (8),
  WC_ICC                                   VARCHAR2(2),
  STATE                                    VARCHAR2(4),
  LATA                                     NUMBER (5),
  CIC                                      NUMBER (8),
  END_OFFICE                               VARCHAR2 (20),
  TRAFFIC_TYPE                             NUMBER (5),
  JURISDICTION                             NUMBER (2), 
  JURISDICTION_NAME                        VARCHAR2 (20),
  IS_VOIP                                  VARCHAR2 (1), 
  CHARGE                                   NUMBER (22,6),  
  USAGE                                    NUMBER (22,6),   
  VOLUME                                   NUMBER (22,6),   
  RECORD_TYPE_ID                           NUMBER (3),      
  COMPARISON_KEY                           VARCHAR2(250),  
  DB_INSRT_DATETM                          DATE,
  LAST_UPDT_BY                             VARCHAR2(20) ,
  LAST_UPDT_DATETM                         DATE,
  MIG_ITN_NUM                              NUMBER(10) 
);
/
create index I_TO_ACCT_ID on ETLD01.FS_PBW_1101_CHRG_DTL
(
  TO_ACCT_ID
);
/
create index I_MARKET_ID on ETLD01.FS_PBW_1101_CHRG_DTL
(
  MARKET_ID
);
/
create index I_LATA on ETLD01.FS_PBW_1101_CHRG_DTL
(
  LATA
);
/
create index I_CIC on ETLD01.FS_PBW_1101_CHRG_DTL
(
  CIC
);
/
create index I_TRAFFIC_TYPE on ETLD01.FS_PBW_1101_CHRG_DTL
(
  TRAFFIC_TYPE
);
/
create index I_JURISDICTION on ETLD01.FS_PBW_1101_CHRG_DTL
(
  JURISDICTION
);
/
create index I_RECORD_TYPE_ID on ETLD01.FS_PBW_1101_CHRG_DTL
(
  RECORD_TYPE_ID
);
/
create index I_CUSTOMER_SUB_TYPE on ETLD01.FS_PBW_1101_CHRG_DTL
(
  CUSTOMER_SUB_TYPE
);
/
create index I_MIG_ITN_NUM on ETLD01.FS_PBW_1101_CHRG_DTL
(
  MIG_ITN_NUM
);
/
create index I_COMPARISON_KEY on ETLD01.FS_PBW_1101_CHRG_DTL
(
  COMPARISON_KEY
);
/
create table ETLD01.FS_CCB_1010_CHRG_DTL 
(
  BILLING_PERIOD                           NUMBER(6) NOT NULL,
  CUSTOMER_NAME                            VARCHAR2 (312), 
  ACCOUNT_NBR                              VARCHAR2 (30) NOT NULL,  
  CUSTOMER_SUB_TYPE                        VARCHAR2 (10), 
  MARKET_ID                                NUMBER (8),
  WC_ICC                                   VARCHAR2(2),
  STATE                                    VARCHAR2(4),
  LATA                                     NUMBER (5),
  CIC                                      NUMBER (8),
  END_OFFICE                               VARCHAR2 (20),
  TRAFFIC_TYPE                             NUMBER (5),
  JURISDICTION_NAME                        VARCHAR2 (20),
  IS_VOIP                                  VARCHAR2 (1), 
  CHARGE                                   NUMBER (22,6),  
  USAGE                                    NUMBER (22,6),   
  VOLUME                                   NUMBER (22,6), 
  RECORD_TYPE_ID                           NUMBER (3),     
  COMPARISON_KEY                           VARCHAR2(250),  
  DB_INSRT_DATETM                          DATE ,
  LAST_UPDT_BY                             VARCHAR2(20) ,
  LAST_UPDT_DATETM                         DATE,
  MIG_ITN_NUM                              NUMBER(10)  
);
/
create index I_C_MARKET_ID on ETLD01.FS_CCB_1010_CHRG_DTL
(
  MARKET_ID
);
/
create index I_C_LATA on ETLD01.FS_CCB_1010_CHRG_DTL
(
  LATA
);
/
create index I_C_CIC on ETLD01.FS_CCB_1010_CHRG_DTL
(
  CIC
);
/
create index I_C_TRAFFIC_TYPE on ETLD01.FS_CCB_1010_CHRG_DTL
(
  TRAFFIC_TYPE
);
/
create index I_C_JURISDICTION on ETLD01.FS_CCB_1010_CHRG_DTL
(
  JURISDICTION_NAME
);
/
create index I_C_RECORD_TYPE_ID on ETLD01.FS_CCB_1010_CHRG_DTL
(
  RECORD_TYPE_ID
);
/
create index I_C_CUSTOMER_SUB_TYPE on ETLD01.FS_CCB_1010_CHRG_DTL
(
  CUSTOMER_SUB_TYPE
);
/
create index I_C_MIG_ITN_NUM on ETLD01.FS_CCB_1010_CHRG_DTL
(
  MIG_ITN_NUM
);
/
create index I_C_COMPARISON_KEY on ETLD01.FS_CCB_1010_CHRG_DTL
(
  COMPARISON_KEY
);
/
create table ETLD01.RP_BILL_DTL_COMP
(
  USG_COMP_SK				               NUMBER GENERATED ALWAYS AS IDENTITY NOT NULL,
  SRC_SYSTEM                               VARCHAR2(10),
  BILLING_PERIOD                           NUMBER(6) NOT NULL,
  CUSTOMER_NAME                            VARCHAR2 (312),  
  CUSTOMER_SUB_TYPE                        VARCHAR2 (10),    
  ACCOUNT_NBR                              VARCHAR2 (30) NOT NULL, 
  FROM_AMT                                 NUMBER (22,6),
  TO_AMT                                   NUMBER (22,6),
  DIFF_AMT                                 NUMBER (22,6),
  PERC_DIFF                                NUMBER (22,6),
  FROM_USAGE                               NUMBER (22,6),
  TO_USAGE                                 NUMBER (22,6),
  DIFF_USAGE                               NUMBER (22,6),
  FROM_VOLUME                              NUMBER (22,6),
  TO_VOLUME                                NUMBER (22,6),
  DIFF_VOLUME                              NUMBER (22,6),
  RECORD_TYPE_ID                           NUMBER (3),
  COMPARISON_KEY                           VARCHAR2(250), 
  DB_INSRT_DATETM                          DATE,
  LAST_UPDT_BY                             VARCHAR2(20) ,
  LAST_UPDT_DATETM                         DATE,
  MIG_ITN_NUM                              NUMBER(10)
  );
 /
create index I_COMP_SRC_SYSTEM on ETLD01.RP_BILL_DTL_COMP
(
  SRC_SYSTEM
);
/
create index I_COMP_CUSTOMER_SUB_TYPE on ETLD01.RP_BILL_DTL_COMP
(
  CUSTOMER_SUB_TYPE
);
/
create index I_COMP_RECORD_TYPE_ID on ETLD01.RP_BILL_DTL_COMP
(
  RECORD_TYPE_ID
);
/
create index I_COMP_MIG_ITN_NUM on ETLD01.RP_BILL_DTL_COMP
(
  MIG_ITN_NUM
);
/
create index I_COMP_COMPARISON_KEY on ETLD01.RP_BILL_DTL_COMP
(
  COMPARISON_KEY
);
/
create table ETLD01.PC_COMP_SUMMARY_LOG
(
  PROCESS_LEVEL                           VARCHAR2 (30),
  PROCESS_DESC                            VARCHAR2 (100),   
  SRC_CNT                                 NUMBER(20),  
  ERR_CNT                                 NUMBER(20),  
  TGT_CNT                                 NUMBER(20),  
  DB_INSRT_DATETM                         DATE,
  LAST_UPDT_BY                            VARCHAR2(20) ,
  LAST_UPDT_DATETM                        DATE,
  MIG_ITN_NUM                             NUMBER(10)
  );
 / 
create table ETLD01.PC_COMP_ERROR_LOG
(
  PROCESS_LEVEL                           VARCHAR2 (30),
  PROCESS_DESC                            VARCHAR2 (100), 
  SOURCE_DATA_KEY                         VARCHAR2 (50), 
  ERROR_DESCRIPTION                       VARCHAR2 (250),
  DB_INSRT_DATETM                         DATE,
  LAST_UPDT_BY                            VARCHAR2(20) ,
  LAST_UPDT_DATETM                        DATE,
  MIG_ITN_NUM                             NUMBER(10)
  );
  /
----TRIGGER For FS_TO_AMT_DC table
create or replace trigger etld01.TRG_FS_TO_AMT BEFORE
    INSERT OR UPDATE ON ETLD01.FS_PBW_1101_CHRG_DTL
    FOR EACH ROW
BEGIN
    CASE
        WHEN inserting THEN
            SELECT
                SYSDATE,
                SYSDATE,
                USER
            INTO
                :NEW.db_insrt_datetm,:NEW.last_updt_datetm,:NEW.last_updt_by
            FROM
                dual;
        ELSE
            SELECT
                :OLD.db_insrt_datetm,
                SYSDATE,
                USER
            INTO
                :NEW.db_insrt_datetm,:NEW.last_updt_datetm,:NEW.last_updt_by
            FROM
                dual;
    END CASE;
END;
/
--Trigger for ETLD01.FS_CCB_1010_CHRG_DTL table
create or replace trigger ETLD01.TRG_FS_CCB_Charge BEFORE
    INSERT OR UPDATE ON ETLD01.FS_CCB_1010_CHRG_DTL
    FOR EACH ROW
BEGIN
    CASE
        WHEN inserting THEN
            SELECT
                SYSDATE,
                SYSDATE,
                USER
            INTO
                :NEW.db_insrt_datetm,:NEW.last_updt_datetm,:NEW.last_updt_by
            FROM
                dual;
        ELSE
            SELECT
                :OLD.db_insrt_datetm,
                SYSDATE,
                USER
            INTO
                :NEW.db_insrt_datetm,:NEW.last_updt_datetm,:NEW.last_updt_by
            FROM
                dual;
    END CASE;
END;
/
--Trigger for ETLD01.RP_BILL_DTL_COMP_DC table
create or replace trigger ETLD01.TRG_RP_USG_COMP BEFORE
    INSERT OR UPDATE ON ETLD01.RP_BILL_DTL_COMP
    FOR EACH ROW
BEGIN
    CASE
        WHEN inserting THEN
            SELECT
                SYSDATE,
                SYSDATE,
                USER
            INTO
                :NEW.db_insrt_datetm,:NEW.last_updt_datetm,:NEW.last_updt_by
            FROM
                dual;
        ELSE
            SELECT
                :OLD.db_insrt_datetm,
                SYSDATE,
                USER
            INTO
                :NEW.db_insrt_datetm,:NEW.last_updt_datetm,:NEW.last_updt_by
            FROM
                dual;
    END CASE;
END;
/
--Trigger for ETLD01.PC_COMP_SUMMARY_LOG table
create or replace trigger ETLD01.TRG_RP_COMP_SUMMARY_LOG BEFORE
    INSERT OR UPDATE ON ETLD01.PC_COMP_SUMMARY_LOG
    FOR EACH ROW
BEGIN
    CASE
        WHEN inserting THEN
            SELECT
                SYSDATE,
                SYSDATE,
                USER
            INTO
                :NEW.db_insrt_datetm,:NEW.last_updt_datetm,:NEW.last_updt_by
            FROM
                dual;
        ELSE
            SELECT
                :OLD.db_insrt_datetm,
                SYSDATE,
                USER
            INTO
                :NEW.db_insrt_datetm,:NEW.last_updt_datetm,:NEW.last_updt_by
            FROM
                dual;
    END CASE;
END;
/
--Trigger for ETLD01.PC_COMP_ERROR_LOG table
create or replace trigger ETLD01.TRG_RP_COMP_ERROR_LOG BEFORE
    INSERT OR UPDATE ON ETLD01.PC_COMP_ERROR_LOG
    FOR EACH ROW
BEGIN
    CASE
        WHEN inserting THEN
            SELECT
                SYSDATE,
                SYSDATE,
                USER
            INTO
                :NEW.db_insrt_datetm,:NEW.last_updt_datetm,:NEW.last_updt_by
            FROM
                dual;
        ELSE
            SELECT
                :OLD.db_insrt_datetm,
                SYSDATE,
                USER
            INTO
                :NEW.db_insrt_datetm,:NEW.last_updt_datetm,:NEW.last_updt_by
            FROM
                dual;
    END CASE;
END;
/
--Comment added for ETLD01.FS_PBW_1101_CHRG_DTL
COMMENT ON COLUMN ETLD01.FS_PBW_1101_CHRG_DTL.CHARGE IS 'This column is to capture the CDR CHARGES,TAX CHARGES,INVOICE CHARGES';
/
COMMENT ON COLUMN ETLD01.FS_PBW_1101_CHRG_DTL.TO_ACCT_ID IS 'This column store the account id created from PBW';
/
COMMENT ON COLUMN ETLD01.FS_PBW_1101_CHRG_DTL.USAGE IS 'This column is to capture the DURATION Of the calls';
/
COMMENT ON COLUMN ETLD01.FS_PBW_1101_CHRG_DTL.VOLUME IS 'This column is to capture the No of calls';
/
COMMENT ON COLUMN ETLD01.FS_PBW_1101_CHRG_DTL.COMPARISON_KEY IS 'This column is to capture the CONCATENATE of column with respect to level comparison';
/
--Comment added for ETLD01.FS_PBW_1101_CHRG_DTL
COMMENT ON COLUMN ETLD01.FS_CCB_1010_CHRG_DTL.CHARGE IS 'This column is to capture the CDR CHARGES,TAX CHARGES,INVOICE CHARGES';
/
COMMENT ON COLUMN ETLD01.FS_CCB_1010_CHRG_DTL.USAGE IS 'This column is to capture the DURATION Of the calls';
/
COMMENT ON COLUMN ETLD01.FS_CCB_1010_CHRG_DTL.VOLUME IS 'This column is to capture the No of calls';
/
COMMENT ON COLUMN ETLD01.FS_CCB_1010_CHRG_DTL.COMPARISON_KEY IS 'This column is to capture the CONCATENATE of column with respect to level comparison';
/
--Comment added for ETLD01.FS_PBW_1101_CHRG_DTL
COMMENT ON COLUMN ETLD01.RP_BILL_DTL_COMP.SRC_SYSTEM IS 'This column is to capture the SOURCE SYSTEM LIKE CCABS,WIN,CABS';
/
COMMENT ON COLUMN ETLD01.RP_BILL_DTL_COMP.FROM_AMT IS 'This column is to capture the CDR CHARGES,TAX CHARGES,INVOICE CHARGES from CCABS ';
/
COMMENT ON COLUMN ETLD01.RP_BILL_DTL_COMP.TO_AMT IS 'This column is to capture the CDR CHARGES,TAX CHARGES,INVOICE CHARGES from PBW';
/
COMMENT ON COLUMN ETLD01.RP_BILL_DTL_COMP.DIFF_AMT IS 'This column is to capture the Difference in CDR CHARGES,TAX CHARGES,INVOICE CHARGES Between CCABS and PBW';
/
COMMENT ON COLUMN ETLD01.RP_BILL_DTL_COMP.FROM_USAGE IS 'This column is to capture the DURATION Of the calls from CCABS';
/
COMMENT ON COLUMN ETLD01.RP_BILL_DTL_COMP.TO_USAGE IS 'This column is to capture the DURATION Of the calls from PBW';
/
COMMENT ON COLUMN ETLD01.RP_BILL_DTL_COMP.DIFF_USAGE IS 'This column is to capture the difference in DURATION Of the calls between CCABS and PBW';
/
COMMENT ON COLUMN ETLD01.RP_BILL_DTL_COMP.FROM_VOLUME IS 'This column is to capture the No of calls from CCABS';
/
COMMENT ON COLUMN ETLD01.RP_BILL_DTL_COMP.TO_VOLUME IS 'This column is to capture the No of calls from PBW';
/
COMMENT ON COLUMN ETLD01.RP_BILL_DTL_COMP.DIFF_VOLUME IS 'This column is to capture the difference in No of calls between CCABS and PBW';
/
COMMENT ON COLUMN ETLD01.RP_BILL_DTL_COMP.COMPARISON_KEY IS 'This column is to capture the CONCATENATE of column with respect to level comparison';
/
--Comment added for ETLD01.PC_COMP_SUMMARY_LOG
COMMENT ON COLUMN ETLD01.PC_COMP_SUMMARY_LOG.PROCESS_LEVEL IS 'This column is to capture the USAGE or TAX or INVOICE Level';
/
COMMENT ON COLUMN ETLD01.PC_COMP_SUMMARY_LOG.PROCESS_DESC IS 'This column is to capture the VOIP or account level for each customer sub type';
/
COMMENT ON COLUMN ETLD01.PC_COMP_SUMMARY_LOG.SRC_CNT IS 'This column is to capture the No of records in Cursor';
/
COMMENT ON COLUMN ETLD01.PC_COMP_SUMMARY_LOG.ERR_CNT IS 'This column is to capture the No of records failed during Code running';
/
COMMENT ON COLUMN ETLD01.PC_COMP_SUMMARY_LOG.TGT_CNT IS 'This column is to capture the No of records successfully inserted or updated';
/
--Comment added for ETLD01.PC_COMP_ERROR_LOG
COMMENT ON COLUMN ETLD01.PC_COMP_ERROR_LOG.PROCESS_LEVEL IS 'This column is to capture the USAGE or TAX or INVOICE Level';
/
COMMENT ON COLUMN ETLD01.PC_COMP_ERROR_LOG.PROCESS_DESC IS 'This column is to capture the VOIP or account level for each customer sub type';
/
COMMENT ON COLUMN ETLD01.PC_COMP_ERROR_LOG.SOURCE_DATA_KEY IS 'This column is to capture the Errored Account_nbr record';
/
COMMENT ON COLUMN ETLD01.PC_COMP_ERROR_LOG.ERROR_DESCRIPTION IS 'This column is to capture the oracle error message for errored records';
/
--GRANT 
GRANT SELECT ON ETLD01.FS_PBW_1101_CHRG_DTL TO ROLE_MFRO;
/
GRANT SELECT ON ETLD01.FS_CCB_1010_CHRG_DTL TO ROLE_MFRO;
/
GRANT SELECT ON ETLD01.RP_BILL_DTL_COMP TO ROLE_MFRO;
/
GRANT SELECT ON ETLD01.PC_COMP_SUMMARY_LOG TO ROLE_MFRO;
/
GRANT SELECT ON ETLD01.PC_COMP_ERROR_LOG TO ROLE_MFRO;
/
GRANT SELECT,INSERT,UPDATE,DELETE ON ETLD01.FS_PBW_1101_CHRG_DTL TO ROLE_MFRW;
/
GRANT SELECT,INSERT,UPDATE,DELETE ON ETLD01.FS_CCB_1010_CHRG_DTL TO ROLE_MFRW;
/
GRANT SELECT,INSERT,UPDATE,DELETE ON ETLD01.RP_BILL_DTL_COMP TO ROLE_MFRW;
/
GRANT SELECT,INSERT,UPDATE,DELETE ON ETLD01.PC_COMP_SUMMARY_LOG TO ROLE_MFRW;
/
GRANT SELECT,INSERT,UPDATE,DELETE ON ETLD01.PC_COMP_ERROR_LOG TO ROLE_MFRW;
/

