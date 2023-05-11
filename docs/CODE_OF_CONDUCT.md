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

Per la stesura del codice seguiamo le linee guida fornitoci dal file _checkstyle.xml_ .

Segue un esempio di codice ben formattato che segue le linee guida fornite:
```java
import java.lang.Math;
public class Main() {
    public static void main (String[] args) {
        int i = Math.random();
        if (i > 10) {
            System.out.println("Il numero è maggiore di 10");
        } else {
            for (j = 0; j < 10; j++) {
                i += 1;
                System.out.println("Il valore del numero è il seguente: " + i);
            }
        }
    }
}
```
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

