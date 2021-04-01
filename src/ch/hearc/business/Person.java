package ch.hearc.business;

public class Person extends Node {
    private String name;
    private String city;

    /**
     * Constructeurs
     */

    public Person(String name){
        super(name);
    }

    public Person(String name, String city){
        super(name);
        setName(name);
    }

    /**
     * Fonctions
     */

    /**
     * Getter/Setter
     */

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
