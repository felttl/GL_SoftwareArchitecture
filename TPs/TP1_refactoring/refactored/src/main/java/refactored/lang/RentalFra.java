package refactored.lang;

import refactored.Rental;

public class RentalFra implements RentalLang{

    /**
     * il va faloir corriger la traduction des
     * valeurs pour les 3 variables 
     * (nomfilm, lePriceCode, le nombre de jours (
     * dans certaines langues les chiffres ne 
     * sont pas écrit en chiffres et certains 
     * alphabets ont un comptage ou 
     * des symboles différents))
     */
    @Override
    public String format(Rental rental, int days) {
        final String plural = days > 1 ? "s" : "";
        return String.format(
            " - \"%s\" de type %s pendant %d jour%s", 
            rental.getMovie().getTitle(),
            rental.getMovie().getPriceCode(),
            rental.getDaysRented(),
            plural
        );
    }


    
}
