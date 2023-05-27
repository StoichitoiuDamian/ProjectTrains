#  Tema1 Proiectare Software 
## Prezentare Proiect
                                                          Gara 🚆
  Aplicatia pe care o voi dezvolta pe parcursul acestui semestru in cadrul materiei Proiectare Software este o platformacare are capacitatea de a simula utilitatea unei gari de transport persoane.
Vom avea si un administrator care va putea adauga curse de tren speciale sau sa editeze tabelele in functie de anumite cerinte sau probleme care au aparut in urma unor defectiuni sau a altor probleme neasteptate.
Clientii se pot inregistra si conecta la aplicatie.Persoanele care nu au un cont inregistrat pot deasemenea sa vizualizele trenurile si datile acestora de plecare.
Vom avea baza de date ,mai exact 5 tabele:
- tabela ticket cu un id_ticket pentru fiecare persoana care achizitioneaza un ticket pentru calatorie,id_person  care a achizitionat biletul, ora,ziua,luna de plecare a trenului ,id_train si numarul scaunului pe care se va aseza persoana.
- tabela person vine cu un id_person pentru a putea face legatura intre persoana care a achizitionat biletul,un username si o parola.
- tabela train prezinta un id_train care este numarul trenului ,numele acestuia si tipul.
- tabela tour are prezente ora,ziua,luna,trenul de la care va pleca trenul in momentul inceperii cursei.
- tabela carload va avea un id_carload,numar scaune si trenul caruia ii este atasat plus clasa.

Pe langa modificariile pe care le-am adus bazei de date am implementat si operatiile CRUD pe baza de date si anume operatiile: 
- GetMapping care ma ajuta sa vad toate trenurile care sunt in baza de date 
- DeleteMapping care ma ajuta sa sterg toate trenurile din baza de date 
- PostMapping care ma ajuta sa creez un nou tren si sa ii adaug noi caracteristici
- PutMapping care ma ajuta sa editez un tren in cazul in care este nevoie.
## Adaugari:
- Ajustari noi aduse la JavaDoc
- repartitionarea claselor in pachete
- Incercarea de a testa aplicatia folosind o interfata noua numita Train Dao si Clasa TrainDaoImpl 
 pentru a decupla baza de date de aplicatia noastre,dar si pentru a testa endpoint-urile
testTrainFindAll(): Această metodă de testare verifică funcția trainFindAll() din clasa TrainService.
testTrainDeleteAll():Această metodă de testare verifică funcția trainDeleteAll() din clasa TrainService.
testCreateTrain():Această metodă de testare verifică funcția createTrain(Train train) din clasa TrainService.
testUpdateById():Această metodă de testare verifică funcția updateById(Long id, Train train) din clasa TrainService.
testFindById():Această metodă de testare verifică funcția findById(Long id) din clasa TrainService.
- Mai multe detalii au fost adaugate in JavaDoc-ul in care se afla clasa de teste.

## Capacitati pe care le vom putea face:

- Se vor putea cumpara bilete
- Se vor putea vizualiza trenurile care au curse 
- Se va putea alege clasa la care sa calatoresti
- Se va putea alege scaunul pe care sa calatoresti

## FRONTEND
 Pentru a realiza frontend-ul meu am avut nevoie de a invata un nou frakework si anume Angular care este un cadru (framework) de dezvoltare web utilizat pentru construirea aplicațiilor web dinamice și complexe. Este dezvoltat și susținut de către Google și oferă un set de instrumente și funcționalități pentru a facilita dezvoltarea aplicațiilor web cu interfață utilizator modernă și reactivă.
 
 In aceasta aplicatie web am realizat comunicarea intre Backend si FrontEnd pentru a transmite datele,si afisarea acestora pe o pagina web.Principalele date pe care le-am trimis eu fost cele de la endpoint-uri de exemplu pentru clasa train am realizat comunicarea prin intermediul link-urilor create in backend si anume :
- /train care imi afiseaza toate trenurile 
- /createTrain care ma ajuta la crearea unui nou tren
- /findTrain care ma ajuta la gasirea unui tren dupa id
- /putTrain care ma ajuta la a face update la datele unui tren
- /deleteTrain pentru a sterge un tren

Avem capacitatea de a face serviciul de login insa doar pentru persoanele din baza de date,am ajustat paginile astfel incat sa putem regasi cateva butoane ajutatoare pentru update si delete,avem capacitatea de a se naviga intre pagini,modificarea datelor in timp real,stilizarea paginilor astfel incat sa arate cat mai frumos.

 
## Diagrama bazei de date 
https://photos.google.com/photo/AF1QipMLdARsYrYSUnUbEmqW4Ib596aX8MyfEsQgrmEh
