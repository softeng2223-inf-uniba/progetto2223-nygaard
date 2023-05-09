# Report
# 3. Requisiti specifici

## 3.1 Requisiti Funzionali

Di seguito, i ***Requisiti Funzionali*** del progetto, facenti parte della *User Story*.

- *mostrare l'help con elenco comandi e regole del gioco*

  Come giocatore voglio mostrare l'help con elenco comandi.

  **Criteri di accettazione**
  Al comando ```/help```
  o invocando l'app con flag ```--help``` o ```-h```

il risultato è una descrizione concisa, che normalmente appare all'avvio del
programma, seguita da una lista di comandi disponibili,
uno per riga, come da esempio successivo:

- gioca
- esci
- ...

<br/>

- *chiudere il gioco*

  Come giocatore voglio chiudere il gioco.

  **Criteri di accettazione:**
  Al comando ```/esci```

    - l'applicazione chiede conferma
        - se la conferma è positiva, l'applicazione si chiude restituendo il controllo al sistema operativo
        - se la conferma è negativa, l'applicazione si predispone a ricevere nuovi tentativi o comandi

<br/>