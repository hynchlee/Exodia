
--DROP USER C##KH_UNIV;
CREATE USER C##KH_UNIV IDENTIFIED BY 1234;
GRANT CONNECT, RESOURCE TO C##KH_UNIV;
ALTER USER C##KH_UNIV DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;