CREATE TABLE IF NOT EXISTS Participant_Settlement (
	pzn TEXT PRIMARY KEY NOT NULL, 
	imy TEXT, name TEXT);

CREATE TABLE IF NOT EXISTS Elect_Participant (
	uer TEXT, 
	name TEXT);

CREATE TABLE IF NOT EXISTS Region (
	rgn TEXT PRIMARY KEY NOT NULL, 
	name TEXT);

CREATE TABLE IF NOT EXISTS Type_Locality (
	tnp TEXT PRIMARY KEY NOT NULL, 
	name TEXT);


CREATE TABLE IF NOT EXISTS Bnk_Seek(
	real TEXT, 
	pzn TEXT, 
	uer TEXT NOT NULL, 
	rgn TEXT NOT NULL, 
	ind TEXT, 
	tnp TEXT, 
	nnp TEXT, 
	adr TEXT, 
	rkc TEXT, 
	namep TEXT NOT NULL, 
	newnum TEXT PRIMARY KEY NOT NULL, 
	telefon TEXT, 
	regn TEXT, 
	okpo TEXT, 
	dt_izm TEXT NOT NULL, 
	ksnp TEXT, 
	date_in TEXT NOT NULL, 
	date_ch TEXT, 
	FOREIGN KEY (pzn) REFERENCES Participant_Settlement (pzn), 
	FOREIGN KEY (uer) REFERENCES Elect_Participant (uer), 
	FOREIGN KEY (rgn) REFERENCES Region (rgn), 
	FOREIGN KEY (tnp) REFERENCES Type_Locality (tnp) );