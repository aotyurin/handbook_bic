package main.java.model;

public class ElectParticipant {
    private String pzn;
    private String name;

    public ElectParticipant(String pzn, String name) {
        this.pzn = pzn;
        this.name = name;
    }

    public String getPzn() {
        return pzn;
    }

    public String getName() {
        return name;
    }
}
