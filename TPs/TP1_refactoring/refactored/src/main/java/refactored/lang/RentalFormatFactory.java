package refactored.lang;

import java.util.HashMap;


public class RentalFormatFactory {

    private HashMap<ELang, RentalLang> selector;

    public RentalFormatFactory(){
        this.selector = new HashMap<>();
        this.selector.put(ELang.FRA, new RentalFra());
        this.selector.put(ELang.ENG, new RentalEng());
    }



    
}
