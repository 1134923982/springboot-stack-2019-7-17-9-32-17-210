alter table TESTDB.PUBLIC.PROCURATOR add column age integer not null;
alter table TESTDB.PUBLIC.PROCURATOR add column birthday timestamp;
alter table TESTDB.PUBLIC.PROCURATOR add column experience integer not null;
alter table TESTDB.PUBLIC.PROCURATOR add column id_number varchar(255);
alter table TESTDB.PUBLIC.PROCURATOR add column sex varchar(255);
alter table procuratorate_procurators drop constraint if exists UK_avfmrw88o20jiuri8l75f4f37;
alter table procuratorate_procurators add constraint UK_avfmrw88o20jiuri8l75f4f37 unique (procurators_id);