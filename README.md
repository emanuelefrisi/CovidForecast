# CovidForecast

 <img src="https://github.com/emanuelefrisi/CovidForecast/blob/master/images/Logo%20presentazione.png?raw=true">

# Descrizione progetto
 Benvenuti in CovidForecast. Questo è un web service realizzato per l'esame di programmazione ad oggetti dell'anno accademico 2020/21. Il progetto, che comprende all'incirca 60 classi, si divide in tre principali fasi:
- Prima fase: raccolta giornaliera di dati attuali e previsionali riguardanti 10 città (Ancona, Cagliari, Firenze, Foggia, Milano, Napoli, Palermo, Perugia, Torino, Venezia). Le chiamate richieste all'API esterna OpenWeather sono state effettuate grazie ad uno scheduler all'interno del progetto che permette di richiedere questi dati una volta ogni 60 minuti. Essi poi vengono salvati all'interno di un database MySQL. Per automatizzare il processo senza dover necessariamente tenere attivo h24 un hardware, si è distribuito il codice sotto forma di archivio jar(Java ARchive) sulla piattaforma AWS(Amazon Web Service)
- Seconda fase: creazione della parte di back-end relativa alle possibili interazioni che l'utente può avere con l'applicativo. Ciò comprende la creazione di statistiche e filtri utilizzando i dati precedentemente raccolti e lo sviluppo di controller con cui l'utente può interfacciarsi con un tester di API(es. Postman)
- Terza fase(opzionale): creazione di un'interfaccia grafica che l'utente può scegliere di utilizzare per testare l'effettivo funzionamento delle statistiche. Inoltre è possibile accedere all'interno dell'applicazione tramite un'interfaccia di login, sfruttando nuovamente il database o, nel caso in cui si effettui l'accesso per la prima volta, creare un nuovo account. Dopodiché l'applicazione è in grado di eseguire una geolocalizzazione ricevendo e mostrando i dati relativi ad essa.

# UML

## Diagramma dei casi d'uso

<img src="https://github.com/emanuelefrisi/CovidForecast/blob/master/images/UML/Diagramma%20dei%20casi%20d'uso.png?raw=true">

## Diagramma dei casi d'uso - GUI

<img src="https://github.com/emanuelefrisi/CovidForecast/blob/master/images/UML/Diagramma%20dei%20casi%20d'uso%20GUI.png?raw=true">

## Diagramma delle classi

<img src="https://github.com/emanuelefrisi/CovidForecast/blob/master/images/UML/Diagramma%20delle%20classi.png?raw=true">

## Diagramma delle sequenze - Prima fase

<img src="https://github.com/emanuelefrisi/CovidForecast/blob/master/images/UML/Diagramma%20delle%20sequenze%20fase%201.png?raw=true">

## Diagramma delle sequenze - Statistiche

<img src="https://github.com/emanuelefrisi/CovidForecast/blob/master/images/UML/Diagramma%20delle%20sequenze%20-%20Controller%20Statistiche.png?raw=true">

# Rotte

| Nome rotta | Tipo Rotta | Descrizione |
| ----- | ---- | ---------------------- |
| /stats | POST | Restituisce oggetti riguardanti statistiche ottenute secondo dati ricevuti in input su dati attuali |
| /filters | POST | Restituisce oggetti riguardanti filtraggi ottenuti secondo dati ricevuti in input su dati attuali |
| /forecastStats | POST | Restituisce oggetti riguardanti statistiche ottenute secondo dati ricevuti in input su dati previsionali |
| /dati | GET | Restituisce come chiavi l'elenco delle città che si sono monitorate e di cui è possibile effettuare le statistiche e i filtraggi, e come valori il numero di contagiati totali di Covid ad ogni città associati(il numero si riferisce ai contagi per provincia)|

## Rotta POST /stats

Questa rotta permette di effettuare statistiche sui dati meteorologici(e non previsionali) immagazzinati nel database. Questi dati vengono prima filtarti per città, poi per data(da un instante iniziale ad uno finale). Successivamente è possibile scegliere il tipo di variabile e il tipo di statistica. Tenere conto del fatto che le città sono state monitorate dall'1 gennaio 2021 17:30 al 21 gennaio 23:59

Chiavi:
- citta: accetta un array di città(ovviamente presenti tra quelle monitorate);
- dataInit: accetta una data nel formato "dd-MM-yyyy HH:mm"; dd sta per giorno, MM sta per mese, yyyy per anno, HH per ora(0-23), mm per minuti;
- dataFin: accetta una data nel formato "dd-MM-yyyy HH:mm"; dd sta per giorno, MM sta per mese, yyyy per anno, HH per ora(0-23), mm per minuti;
- variabile: accetta una variabile tra [pressione, temp, tempMin, tempMax, tempPercepita, umidita];
- tipoStat: accetta una tipologia di statistica tra [min, max, media, varianza].

Esempio Body:

```json
{
    "citta":["Ancona", "Firenze"],
    "dataInit":"01-01-2021 23:34",
    "dataFin":"10-01-2021 12:23",
    "variabile":"pressione",
    "tipoStat":"max"
}
```

Esempio Responso:

```json
[
    {
        "data": "09-01-2021 01:40",
        "citta": "Ancona",
        "nazione": "IT",
        "pressione": 1016,
        "temp": 3.24,
        "tempMax": 4.44,
        "tempMin": 1.11,
        "tempPercepita": 0.16,
        "umidita": 93
    },
    {
        "data": "07-01-2021 04:02",
        "citta": "Firenze",
        "nazione": "IT",
        "pressione": 1015,
        "temp": 2.67,
        "tempMax": 3.33,
        "tempMin": 1.67,
        "tempPercepita": 0.06,
        "umidita": 100
    }
]
```

Esempio rotta con body e responso su postman:

<img src="https://github.com/emanuelefrisi/CovidForecast/blob/master/images/Postaman%20-%20Stats.png?raw=true">

## Rotta POST /filters

Questa rotta permette di effettuare filtraggi sui dati meteorologici(e non previsionali) immagazzinati nel database. Questi dati vengono prima filtarti per città, poi per data(da un instante iniziale ad uno finale). Successivamente è possibile scegliere il tipo di variabile e il range di valori su cui effettuare il filtraggio. Tenere conto del fatto che le città sono state monitorate dall'1 gennaio 2021 17:30 al 21 gennaio 23:59

Chiavi:
- citta: accetta un array di città(ovviamente presenti tra quelle monitorate);
- dataInit: accetta una data nel formato "dd-MM-yyyy HH:mm"; dd sta per giorno, MM sta per mese, yyyy per anno, HH per ora(0-23), mm per minuti;
- dataFin: accetta una data nel formato "dd-MM-yyyy HH:mm"; dd sta per giorno, MM sta per mese, yyyy per anno, HH per ora(0-23), mm per minuti;
- variabile: accetta una variabile tra [pressione, temp, tempMin, tempMax, tempPercepita, umidita];
- valInit e valFin: accettano valori numerici. Nel caso in cui non si conoscano i possibili range di valori, è possibile recuperarli usando la rotta /stats

Body:

```json
{
    "citta":["Foggia"],
    "dataInit":"08-01-2021 11:00",
    "dataFin":"10-01-2021 12:00",
    "variabile":"pressione",
    "valInit":1008,
    "valFin":1010
}
```

Esempio Responso:

```json
[
    {
        "data": "08-01-2021 11:19",
        "citta": "Foggia",
        "nazione": "IT",
        "pressione": 1010,
        "temp": 8.0,
        "tempMax": 8.0,
        "tempMin": 8.0,
        "tempPercepita": 2.76,
        "umidita": 87
    },
    {
        "data": "08-01-2021 13:02",
        "citta": "Foggia",
        "nazione": "IT",
        "pressione": 1010,
        "temp": 7.0,
        "tempMax": 7.0,
        "tempMin": 7.0,
        "tempPercepita": 1.19,
        "umidita": 87
    },
    {
        "data": "08-01-2021 14:47",
        "citta": "Foggia",
        "nazione": "IT",
        "pressione": 1010,
        "temp": 8.0,
        "tempMax": 8.0,
        "tempMin": 8.0,
        "tempPercepita": 1.82,
        "umidita": 81
    },
    {
        "data": "08-01-2021 18:40",
        "citta": "Foggia",
        "nazione": "IT",
        "pressione": 1010,
        "temp": 7.77,
        "tempMax": 7.77,
        "tempMin": 7.77,
        "tempPercepita": 2.49,
        "umidita": 85
    }
]
```

Esempio rotta con body e responso su postman:

<img src="https://github.com/emanuelefrisi/CovidForecast/blob/master/images/Postman%20-%20Filters.png?raw=true">

## Rotta POST /forecastStats

Questa rotta permette di effettuare statistiche sulla quatità di previsioni azzeccate usando dati meteorologici e previsionali immagazzinati nel database. Questi dati vengono filtarti per citt e poi per errorein percentuale(massima differenza tra valore reale e previsionale). Questa rotta permette di effettuare la statistica solo per l'umidità

Chiavi:
- citta: accetta una citta(ovviamente presenti tra quelle monitorate);
- errore: accetta un errore in percentuale


Body:

```json
{
    "citta":"Firenze",
    "errore":"5"
}
```

Esempio Responso:

```json
{
    "Città": "Firenze",
    "Numero previsioni azzecate": "72",
    "Errore": "5%"
}
```

Esempio rotta con body e responso su postman:

<img src="https://github.com/emanuelefrisi/CovidForecast/blob/master/images/Postman%20-%20forecastStats.png?raw=true">