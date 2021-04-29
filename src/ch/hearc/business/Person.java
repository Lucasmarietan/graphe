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
        setCity(city);
    }

    /**
     * Fonctions
     */

    public void addFriend(String edgeName, Person dest, int metric){
        // la metric peut signifier le nombre de jours d'amitié ou ce qu'on veut
        this.addEdge(new IsFriend(edgeName, dest, metric));
    }

 //  Relation de cuisine
    public void cook(String edgeName, Receipt dest, int metric){
        this.addEdge(new Cook(edgeName, dest, metric));
    }

    //  Relation de cuisine
    public void watch(String edgeName, WebSite dest, int metric){
        this.addEdge(new Watch(edgeName, dest, metric));
    }



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
