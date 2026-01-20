

problèmes rebcontrés : 

- mauvais format (très difficile a lire et très long 
    (cf etude qui démontre qu'un code bien fomatté permet 
    d'accélerer sa lecture par 100))

- le code présente des underscore a ses variables 
    on est pas en python et c'est donc inutile en java

- on ne doit pas utiliser de classe (voir class Movie) pour
    s'en servire comme énumération on utilise un type 
    enumeration à la place

(on dirrait que le code a été écrit par une personne qui fait
du python, je sais car j'ai déja fait un bot en python pour
me forcer a avoir d'excellentes pratiques de traitement d'erreurs
et d'organisation du code (car typage non statique) et c'est un
excellente exercice pour coder proprement, j'ai forcé le typage
avec vscode pour avoir un projet plus propre avec plus de 
contraintes (j'ai gratté des contraintes oui oui))


- il n'y a pas de commentaire et c'est 
    difficile de savoir a quoi sert Customers.statement()

---

- dans Movie on a une confusion de variable le programme ne sait 
    pas quelle variable est la bonne :

    voici une correction sur la preière ligne après la signature : 
```java
public Movie(String title, int priceCode) {
    this.title = title;
    priceCode = priceCode;
}
```


- il importe tout mais se sert d'une petite partie :
    dans la classe Customer : `import java.util.*;`

- Les classes sont toujours au singuliers sauf pour des
    gestionnaire de groupe d'objet

- ne jamais réutiliser des mots clef "this" par exemple
    dans la méthode statement il y a "thisAmount". Car
    ça peut rajouter des beug d'étourderie...


- les énumération ne sont même pas dans l'ordre

- magic numbers (on ne sait pas d'ou ils 
    sortent) on ne sait pas lequel sert a quoi...

# end page