drop table if exists character_information CASCADE;
drop table if exists job CASCADE; 

create table character_information (
	id integer auto_increment NOT NULL,
	race varchar(255), 
	grand_company varchar(255),
	free_company varchar(255),  
	datacentre varchar(255), 
	primary key (id)
);

create table job (
	id integer primary key auto_increment, 
	job_name varchar(255),
	job_level integer not null,  
	character_id Integer, 
	foreign key (character_id) References character_information(id) on delete cascade
);




