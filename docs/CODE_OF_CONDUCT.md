# **CODICE DI CONDOTTA**

## **PREFAZIONE**
### Il mio obiettivo è quello di contribuire al progetto in modo costruttivo e positivo, e di aiutare gli altri a fare lo stesso. Per questo motivo, mi impegno a rispettare il codice di condotta del progetto, e a seguire le linee guida di comportamento che seguono.
<br >

## **Partecipazione al progetto**

* Eseguire fixing sulle build non funzionanti è la mia priorità
* Partecipare alla revisione del codice dei miei colleghi è la mia seconda priorità
* Darò più importanza al lavoro di squadra che al lavoro individuale
* Darò più importanza a un codice funzionante e leggibile che a una documentazione lunga ed esaustiva
* Rispetterò le scadenze stabilite
* Non esiterò a chiedere aiuto dopo una prima ricerca online, se necessario
* Non esiterò nell'aiutare i miei colleghi quando chiederanno il mio aiuto
* Non esiterò a chiedere chiarimenti se non sono sicuro di cosa devo fare

<br >

## **Revisione di coppia**


* Sarò disponibile per revisionare il codice dei miei colleghi
* Sarò disponibile per essere revisionato dal mio team
* Accetterò le critiche e i suggerimenti con professionalità
* Eserciterò la mia critica e i miei suggerimenti con professionalità e rispetto per il mio team nelle revisioni di codice
* Sarò disponibile a discutere di come migliorare il codice e il processo di sviluppo

<br>

## **Scrittura del codice**

Per la stesura del codice seguiamo le linee guida forniteci dal file _checkstyle.xml_ .

Segue un esempio di codice ben formattato che segue le linee guida fornite:

```java
/**
 * <h2> Main </h2>
 * Classe di esempio.
 */
public final class Main {

  private Main() { }

  /**
   * Punto di ingresso dell'applicazione.
   *
   * @param args Parametri di ingresso da linea di comando
   */
  public static void main(final String[] args) {
    final int min = 49;
    final int max = 1;

    System.out.println(range(min, max));
  }

  /**
   * <p>
   * Genera un numero intero casuale, compreso nell'intervallo {@code [min, max]}.
   * </p>
   * <p>
   * Se {@code min > max} gli estremi vengono scambiati.
   * </p>
   * @param min Valore minimo dell'intervallo
   * @param max Valore massimo dell'intervallo
   * @return Numero casuale compreso fra min e max inclusi
   */
  public static int range(final int min, final int max) {
    if (min == max) {
      return min;
    }

    int minValue = min;
    int maxValue = max;

    if (min > max) {
      int temp = maxValue;
      maxValue = minValue;
      minValue = temp;
    }

    return (int) Math.floor(Math.random() * (maxValue - minValue + 1) + minValue);
  }
}

```

Insieme alle linee guida date dal CheckStyle, ogni membro del gruppo deve rispettare le seguenti linee guida:

* Esprimerò le mie idee chiaramente e in modo conciso
* Aggiungerò commenti al codice quando necessario
* Scriverò codice che aderisce alle convenzioni di formattazione e stile del mio team
* Non pubblicherò codice che non funziona
* Non pubblicherò codice che non è stato revisionato e testato
* Dovrò essere in grado di spiegare il codice che scrivo
<br >

## **Regole di pull request e commit**

* Le mie revisioni e i miei commenti saranno costruttivi, rispettosi, semplici e chiari
* Non terminerò i commit, le revisioni, le pull request e i commenti con un punto
* Inizierò ogni commit, revisione, pull request e commento con una lettera maiuscola
* Il titolo del commit deve essere breve e chiaro
* Inizierò i commit con un verbo al presente oppure con un sostantivo
* Il titolo della pull request deve essere breve e chiaro
* Inizierò le pull request con un verbo al passato oppure con un sostantivo che richiami la *issue* che è stata risolta
* La descrizione della pull request indicherà in maniera semplice la *issue* che è stata risolta
* Non pubblicherò una pull request se non sono sicuro che il codice funzioni
* Ogni pull request deve essere revisionata da almeno due membri del team
* Gli Assignees sono il membro del team che ha creato la issue e il membro del team che l'ha risolta. Una singola persona può aver assunto entrambi i ruoli
* I Reviewers sono coloro che devono revisionare il lavoro; dunque chi ha già esperienza su quella particolare area di codice/documentazione

