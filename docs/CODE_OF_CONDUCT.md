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

* Esprimerò le mie idee chiaramente e in modo conciso
* Aggiungerò commenti al codice quando necessario
* Scriverò codice che aderisce alle convenzioni di formattazione e stile del mio team
* Non pubblicherò codice che non funziona
* Non pubblicherò codice che non è stato revisionato e testato
* Dovrò essere in grado di spiegare il codice che scrivo
* Viene scritta solamente un'istruzione per riga
* Ogni dichiarazione di variabile (attributo o locale) contiene una sola variabile. Dichiarazioni come` int a, b;` sono vietate 
  * Eventuali dichiarazioni multiple nell'header di un ciclo for sono permesse
* Le dichiarazioni di array in stile C sono vietate: le parentesi quadre fanno parte del tipo, non del nome della variabile (es. `int[] a;` invece di `int a[];`)
* Per dichiarare variabili di tipo Long e Float si utilizza il suffisso con la lettera maiuscola (es. `3000L` e `300.04F`)
* I nome dei package possono includere solo lettere minuscole e cifre numeriche. Per esempio, `com.example.deepspace`, no `com.example.deepSpace` o `com.example.deep_space`.
* I nomi delle classi e delle interfacce sono scritte in ***UpperCamelCase***. Tipicamente sono nomi o frasi nominative, ma eventualmente possono essere usati anche gli aggettivi (es. `Readable`)
* I nomi dei metodi sono scritti in ***lowerCamelCase***. Tipicamente sono verbi o frasi verbali
* I nomi delle costanti sono scritte in ***UPPER_SNAKE_CASE***
* I nomi degli attributi (statici o di istanza) sono scritti in ***lowerCamelCase***. Tipicamente sono nomi o frasi nominali
* I nomi dei parametri sono scritti in ***lowerCamelCase***. Nei metodi pubblici bisogna evitare di usare nomi di un solo carattere
* I nomi delle variabili locali sono scritti in ***lowerCamelCase***. 
  * I nomi delle variabili locali possono essere abbreviate se il loro significato è chiaro dal contesto (es. `i` per `index`)
* I membri statici di una classe devono essere qualificati mediante il nome della classe, e non mediante un oggetto istanza di quella classe
* Viene usata la lingua inglese per il codice, mentre viene usata la lingua italiana per la documentazione e i commenti del codice
* Il codice deve essere ben formattato e indentato
  * L'indentazione avviene mediante l'uso del tasto *tab* settato per 4 blank spaces
  * Le parentesi graffe vengono utilizzate anche se il corpo del blocco (es. `if`, `for`) contiene una sola istruzione
    * La parentesi graffa aperta viene posizionata sulla stessa riga dell'istruzione che la precede, mentre quella chiusa viene posizionata nella riga successiva all'ultima istruzione del blocco

*Segue un esempio di codice ben formattato e indentato:*
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

