Create schema Wynajem
use wynajem
CREATE TABLE Osoba (id int(11) NOT NULL AUTO_INCREMENT, NAZWA varchar(128)unique, DEFAULT NULL, PRIMARY KEY (id) ) 

CREATE TABLE mieszkanie(id int(11) NOT NULL AUTO_INCREMENT, nazwa varchar(128) unique, CENA_JEDNOSTKOWA int DEFAULT NULL, powierzchnia int DEFAULT NULL, opis varchar(200) DEFAULT NULL, PRIMARY KEY (id))

CREATE TABLE rezerwacja ( id int(11) NOT NULL AUTO_INCREMENT, OKRES_POCZATEK date DEFAULT NULL, OKRES_KONIEC date DEFAULT NULL, wynajmujaca_id int DEFAULT NULL, Najemca_id int DEFAULT NULL, mieszkanie_id int(11) default null, CONSTRAINT FK_MIESZKANIE FOREIGN KEY (mieszkanie_id) REFERENCES Mieszkanie (id), koszt int(11) DEFAULT NULL, PRIMARY KEY (id), CONSTRAINT FK_WYNAJMUJACY FOREIGN KEY (wynajmujaca_id)  REFERENCES Osoba (id), CONSTRAINT FK_NAJEMCA FOREIGN KEY (Najemca_id)  REFERENCES Osoba (id))


