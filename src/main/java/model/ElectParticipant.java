package main.java.model;

public class ElectParticipant {
    private String uer;
    private String name;

    public ElectParticipant(String uer, String name) {
        this.uer = uer;
        this.name = name;
    }

    public String getUer() {
        return uer;
    }

    public String getName() {
        return name;
    }
}
