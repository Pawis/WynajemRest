Create schema Wynajem
use wynajem
CREATE TABLE Osoba (id int(11) NOT NULL AUTO_INCREMENT, name varchar(128) DEFAULT NULL, PRIMARY KEY (id) ) 

CREATE TABLE mieszkanie(id int(11) NOT NULL AUTO_INCREMENT, nazwa varchar(128) unique, cenaJednostkowa int DEFAULT NULL, powierzchnia int DEFAULT NULL, opis varchar(200) DEFAULT NULL, rezerwacja_id int DEFAULT NULL, PRIMARY KEY (id))

CREATE TABLE rezerwacja ( id int(11) NOT NULL AUTO_INCREMENT, okresPoczatek date DEFAULT NULL, okresKoniec date DEFAULT NULL, wynajmujaca_id int DEFAULT NULL, Najemca_id int DEFAULT NULL, mieszkanie_nazwa varchar(45) default null, CONSTRAINT FK_MIESZKANIE FOREIGN KEY (mieszkanie_nazwa) REFERENCES Mieszkanie (nazwa), koszt int(11) DEFAULT NULL, PRIMARY KEY (id), CONSTRAINT FK_WYNAJMUJACY FOREIGN KEY (wynajmujaca_id)  REFERENCES Osoba (id), CONSTRAINT FK_NAJEMCA FOREIGN KEY (Najemca_id)  REFERENCES Osoba (id))


