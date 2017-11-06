package main.java.model;

public class ParticipantSettlement {
    private String pzn;
    private  String imy;
    private  String name;


    public ParticipantSettlement(String pzn, String imy, String name) {
        this.pzn = pzn;
        this.imy = imy;
        this.name = name;
    }

    public String getPzn() {
        return pzn;
    }

    public String getImy() {
        return imy;
    }

    public String getName() {
        return name;
    }
}
