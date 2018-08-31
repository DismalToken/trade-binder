package com.dismaltoken.tradebinder;

public class Card {

    private Name name;
    private MTGSet set;
    private Language language;
    private Boolean isFoil;

    //sets the name, set, language, and foilStatus for a card
    public Card(Name name, MTGSet set, Language language, boolean isFoil) {
        this.name = name;
        this.set = set;
        this.language = language;
        this.isFoil = isFoil;
    }

    public MTGSet getSet() {
        return set;
    }

    public void setSet(MTGSet set) {
        this.set = set;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Boolean getFoil() {
        return isFoil;
    }

    public void setFoil(Boolean foil) {
        isFoil = foil;
    }

    public void setName(Name name) {
        this.name = name;
    }

    private Name getName(){
        return name;
    }

    public String toString(){
        return "The card's name is " + name.toString() + ". The set is " + set.toString() +
                ". The language is " + language.toString() + ". The card is foil: " + isFoil + ".";
    }
}

/*
So I still dont know how to really use enums other than simply declaring them.
Like I dont know how to give the user options between them
 */