# CovidForecast

 <img src="https://github.com/emanuelefrisi/CovidForecast/blob/master/images/Logo%20presentazione.png?raw=true">

# Descrizione progetto
 Benvenuti in CovidForecast. Questo è un pweb service realizzato per l'esame di programmazione ad oggetti dell'anno accademico 2020/21. Il progetto, che comprende all'incirca 60 classi, si divide in tre principali fasi:
- Prima fase: raccolta giornaliera di dati attuali e previsionali riguardanti 10 città (Ancona, Cagliari, Firenze, Foggia, Milano, Napoli, Palermo, Perugia, Torino, Venezia). Le chiamate richieste all'API esterna OpenWeather sono state effettuate grazie ad uno scheduler all'interno del progetto che permette di richiedere questi dati una volta ogni 60 minuti. Essi poi vengono salvati all'interno di un database MySQL. Per automatizzare il processo senza dover necessariamente tenere attivo h24 un hardware, si è distribuito il codice sotto forma di archivio jar(Java ARchive) sulla piattaforma AWS(Amazon Web Service)
- Seconda fase: creazione di tutta la parte di back-end relativa alle possibili interazioni che l'utente può avere con l'applicativo. Ciò comprende la creazione di statistiche e filtri utilizzando i dati precedentemente raccolti e lo sviluppo di controller con cui l'utente può interfacciarsi con un tester di API(es. Postman)
- Terza fase(opzionale): creazione di un'interfaccia grafica che l'utente può scegliere di utilizzare per testare l'effettivo funzionamento delle statistiche. Inoltre è possibile accedere all'interno dell'applicazione tramite un'interfaccia di login, sfruttando nuovamente il database, o nel caso sia la prima volta in cui si ha accesso, creare un nuovo account. Dopodiché l'applicazione è in grado di eseguire una geolocalizzazione ricevendo e mostrando i dati relativi ad essa.

# UML

- Diagramma dei casi d'uso

<img src="https://github.com/emanuelefrisi/CovidForecast/blob/master/images/UML/Diagramma%20dei%20casi%20d'uso.png?raw=true">

- Diagramma dei casi d'uso - GUI

<img src="https://github.com/emanuelefrisi/CovidForecast/blob/master/images/UML/Diagramma%20dei%20casi%20d'uso%20GUI.png?raw=true">

- Diagramma delle classi

<img src="https://github.com/emanuelefrisi/CovidForecast/blob/master/images/UML/Diagramma%20delle%20classi.png?raw=true">

- Diagramma delle sequenze - Prima fase

<img src="https://github.com/emanuelefrisi/CovidForecast/blob/master/images/UML/Diagramma%20delle%20sequenze%20fase%201.png?raw=true">

- Diagramma delle sequenze - Statistiche

<img src="https://github.com/emanuelefrisi/CovidForecast/blob/master/images/UML/Diagramma%20delle%20sequenze%20-%20Controller%20Statistiche.png?raw=true">