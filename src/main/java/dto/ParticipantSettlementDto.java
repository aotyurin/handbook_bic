package main.java.dto;



public class ParticipantSettlementDto {
    private String pzn;
    private  String name;


    public ParticipantSettlementDto(String pzn, String name) {
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
