
INSERT INTO OSOBA (id,nazwa) VALUES (1,'Damian_Pabis');
insert into osoba (id,nazwa) values (2,'Adam_Ondra');
insert into osoba (id,nazwa) values (3,'Tommy_Caldwell');
insert into osoba (id,nazwa) values (4,'Miho_Nonaka');
insert into osoba (id,nazwa) values (5,'Akiyo_Noguchi');
insert into osoba (id,nazwa) values (6,'Krzysztof_Wielicki');
insert into osoba (id,nazwa) values (7,'Adam_Bielecki');
insert into osoba (id,nazwa) values (8,'Alex_Honnold');
insert into osoba (id,nazwa) values (9,'Janja_Garnbret');
insert into osoba (id,nazwa) values (10,'Fanny_Gibert');

insert into mieszkanie (id,nazwa,cena_jednostkowa,powierzchnia,opis) values (1,'Duzy Dom',100,30,'Bardzo duzy dom');
insert into mieszkanie (id,nazwa,cena_jednostkowa,powierzchnia,opis) values (2,'Maly Dom',10,15,'Bardzo maly dom');
insert into mieszkanie (id,nazwa,cena_jednostkowa,powierzchnia,opis) values (3,'Willa' ,300,100,'Jakas tam willa');
insert into mieszkanie (id,nazwa,cena_jednostkowa,powierzchnia,opis) values (4,'Palac',500,150,'Wspanialy palac');
insert into mieszkanie (id,nazwa,cena_jednostkowa,powierzchnia,opis) values (5,'Koleba pod Wolowa' ,1,1,'Piekny widok na Wolowa Turnie');


insert into rezerwacja (id,okres_poczatek,okres_koniec,wynajmujaca_id,najemca_id,mieszkanie_id,koszt) values (1,'2000-01-01','2000-01-15',1,6,5,1000);
insert into rezerwacja (id,okres_poczatek,okres_koniec,wynajmujaca_id,najemca_id,mieszkanie_id,koszt) values (2,'2000-02-01','2000-02-25',4,3,1,324234);
insert into rezerwacja (id,okres_poczatek,okres_koniec,wynajmujaca_id,najemca_id,mieszkanie_id,koszt) values (3,'2000-01-16','2000-01-20',4,2,3,32320);
insert into rezerwacja (id,okres_poczatek,okres_koniec,wynajmujaca_id,najemca_id,mieszkanie_id,koszt) values (4,'2000-06-01','2000-08-15',1,9,3,100);
insert into rezerwacja (id,okres_poczatek,okres_koniec,wynajmujaca_id,najemca_id,mieszkanie_id,koszt) values (5,'2000-05-20','2000-06-10',10,3,2,1300);
