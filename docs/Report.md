# Report

# 1. Introduzione
Nella seguente documentazione verrà descritta la relazione tecnica del progetto di **Ingegneria del Software Anno Accademico 2022-2023**.

Iniziamo con le presentazioni:

<style>
    .gallery {
        display: grid;
        gap: 16px;
    }

    .gallery img {
        width: 100%;
        height: 100%;
    }

    .item {
        width: 128px;
        height: auto;
    }

    .student {
        display: flex;
        flex-direction: row;
        align-items: center;
    }

    .info {
        margin-left: 1rem;
    }

    .info p {
        color: #e2e2e2;
    }

    .name {
        font-size: 18px;
        font-weight: 700;
        line-height: 16px;
    }

    .email, .live {
        font-size: 14px;
        font-weight: 400;
        line-height: 8px;
    }
</style>

<div class="display: flex; justify-content: center; align-items: center;">
    <h2 class="
        color: #e2e2e2;
        font-family: 'Montserrat', sans-serif;
        font-size: 24px;"> Gruppo Nygaard </h2>
</div>

<div class="gallery">
    <div class="student">
        <div class="item">
            <img src="./img/membri/cirilli.jpg" alt="Davy592">
        </div>
        <div class="info">
            <p class="name"> Davide Cirilli</p>
            <p class="live"> 20 anni, Molfetta (BA) </p>
            <p class="email"> d.cirilli2@studenti.uniba.it </p>
        </div>
    </div>
    <div class="student">
        <div class="item">
            <img src="./img/membri/curri.png" alt="mattiacurri">
        </div>
        <div class="info">
            <p class="name"> Mattia Curri </p>
            <p class="live"> 20 anni, Ceglie Messapica (BR) </p>
            <p class="email"> m.curri8@studenti.uniba.it </p>
        </div>
    </div>
    <div class="student">
        <div class="item">
            <img src="./img/membri/fontana.jpg" alt="Fonty02">
        </div>
        <div class="info">
            <p class="name"> Emanuele Fontana </p>
            <p class="live"> 20 anni, Matera (MT) </p>
            <p class="email"> e.fontana7@studenti.uniba.it </p>
        </div>
    </div>
    <div class="student">
        <div class="item">
            <img src="./img/membri/labianca.jpg" alt="Stefano-Labianca">
        </div>
        <div class="info">
            <p class="name"> Stefano Labianca</p>
            <p class="live"> 20 anni, Corato (BA) </p>
            <p class="email"> s.labianca10@studenti.uniba.it </p>
        </div>
    </div>
    <div class="student">
        <div class="item">
             <img src="./img/membri/izzo.jpg" alt="GiudittaIzzo">
        </div>
        <div class="info">
            <p class="name"> Giuditta Izzo </p>
            <p class="live"> 21 anni, Bari (BA) </p>
            <p class="email"> g.izzo2@studenti.uniba.it </p>
        </div>
    </div>
</div>

---

<br>

Il progetto svolto, consiste nella realizzazione della **Battaglia Navale**, sotto forma di applicazione eseguibile da riga di comando (*CLI*).

In questa realizzazione, il giocatore si scontrerà contro il proprio computer che, ad inizio partita, genererà casualmente le posizioni delle navi. 
Spetterà quindi al giocatore trovarle tutte e affondarle prima di esaurire il numero massimo di tentaviti falliti dati.

Il numero massimo di tentativi falliti consentiti, dipende dalla difficoltà scelta:
* **Facile**: Massimo 50;
* **Medio**: Massimo 30;
* **Difficile**: Massimo 10;

# 2. Modello Di Dominio

*I diagrammi che verranno mostrati, all'interno della relazione, sono stati realizzati
con **StarUML**.* (https://staruml.io/)

<br/>

- ### Diagramma delle Classi con prospettiva concettuale

![diagramma](img/ModelloDominio.png)

  <br/>


# 3. Requisiti specifici

## 3.1 Requisiti Funzionali

Di seguito, i ***Requisiti Funzionali*** del progetto, facenti parte della *User Story*.

- *mostrare l'help con elenco comandi e regole del gioco*

  Come giocatore voglio mostrare l'help con elenco comandi.

  **Criteri di accettazione**

  Al comando ```/help```
  o invocando l'app con flag ```--help``` o ```-h```

  Il risultato è una descrizione concisa, che normalmente appare all'avvio del
  programma, seguita da una lista di comandi disponibili,
  uno per riga, come da esempio successivo:

  - gioca
  - esci
  - ...

<br/>

- *chiudere il gioco*

  Come giocatore voglio chiudere il gioco.

  **Criteri di accettazione**
  
  Al comando ```/esci```

    - l'applicazione chiede conferma
        - se la conferma è positiva, l'applicazione si chiude restituendo il controllo al sistema operativo
        - se la conferma è negativa, l'applicazione si predispone a ricevere nuovi tentativi o comandi

<br/>

- *impostare il livello di gioco per variare il numero massimo di tentativi falliti*

  Come giocatore voglio impostare il livello di gioco per variare il numero massimo di tentativi sbagliati.

  **Criteri di accettazione**
  - Al comando ```/facile```

    - l’applicazione risponde con OK e imposta a 50 il numero massimo di tentativi falliti

  - Al comando ```/medio```

    - l’applicazione risponde con OK e imposta a 30 il numero massimo di tentativi falliti

  - Al comando ```/difficile```

    - l’applicazione risponde con OK e imposta a 10 il numero massimo di tentativi falliti

<br/>

- *mostrare i tipi di nave e il numero*

  Come giocatore voglio mostrare i tipi di nave e il numero
  
  **Criteri di accettazione**

  Al comando ```/mostranavi``` l’applicazione risponde visualizzando, per ogni tipo di nave, la dimensione in quadrati e il numero di esemplari da affondare
  
  -    Cacciatorpediniere ⊠⊠ esemplari: 4
  -    Incrociatore ⊠⊠⊠ esemplari: 3 
  -    Corazzata ⊠⊠⊠⊠ esemplari: 2 
  -    Portaerei ⊠⊠⊠⊠⊠ esemplari: 1

<br/>

- *iniziare una nuova partita*

  Come giocatore voglio iniziare una nuova partita

  **Criteri di accettazione**

  Al comando ```/gioca```

    - se nessuna partita è in corso l'applicazione imposta casualmente le navi, in orizzontale o in verticale, mostra la griglia vuota e si predispone a ricevere il primo tentativo o altri comandi

<br/>

- *svelare la griglia con le navi posizionate*

  Come giocatore voglio svelare la griglia con le navi posizionate

  **Criteri di accettazione**

  Al comando ```/svelagriglia```

    - l’applicazione risponde visualizzando, una griglia 10x10, con le righe numerate da 1 a 10 e le colonne numerate da A a J, e tutte le navi posizionate

<br/>

## 3.2 Requisiti non Funzionali

Il funzionamento del software richiede:

- il container docker dell’app deve essere eseguito da terminali che supportano Unicode con encoding UTF-8 o UTF-16.

<br/>