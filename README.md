## Przykladowe wywolania curl

Dodanie nowej rezerwacji:

curl -X POST http://localhost:8007/post -H 'Content-Type: application/json' -d '{"okres_poczatek":"2000-10-01","okres_koniec":"2000-11-15","najemca":"Janja_Garnbret","wynajmujacy":"Miho_Nonaka","koszt":1000,"mieszkanie":"Palac"}'

Zmiana rezerwacji:

curl -X PUT http://localhost:8007/update/3 -H 'Content-Type: application/json' -d '{"okres_poczatek":"2000-03-01","okres_koniec":"2000-03-15","najemca":"Janja_Garnbret","wynajmujacy":"Miho_Nonaka","koszt": 100220,"mieszkanie":"Palac"}'

Lista rezerwacji dla danego najmecy:

curl -X GET http://localhost:8007/najemcy/Tommy_Caldwell

Lista rezerwacji dla danego mieszkania:

curl -X GET http://localhost:8007/rezerwacjeMieszkania/Willa