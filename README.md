# CovidForecast

 <img src="https://github.com/emanuelefrisi/CovidForecast/blob/master/images/Logo%20presentazione.png?raw=true">

# Descrizione progetto
 Benvenuti in CovidForecast. Questo è un progetto realizzato per l'esame di programmazione ad oggetti dell'anno accademico 2020/21. Il progetto è stato svolto in tre principali fasi:
- Prima fase: raccolta giornaliera di dati attuali e previsionali riguardanti 10 città (Ancona, Cagliari, Firenze, Foggia, Milano, Napoli, Palermo, Perugia, Torino, Venezia). Le chiamate richieste all'API esterna OpenWeather sono state effettuate grazie ad uno scheduler all'interno del progetto che permette di richiedere questi dati una volta ogni 60 minuti. Essi poi vengono salvati all'interno di un database. Per automatizzare il processo senza dover necessariamente tenere attiva h24 un hardware, si è distribuito <br/>il codice sotto forma di archivio jar(Java ARchive) sulla piattaforma AWS(Amazon Web Service)
