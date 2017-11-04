package main.java.dto;


public class ElectParticipantDto {
    private String uer;
    private String name;

    public ElectParticipantDto(String uer, String name) {
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
