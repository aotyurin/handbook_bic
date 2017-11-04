package main.java.dto;


public class TypeLocalityDto {
    private String tnp;
    private String name;

    public TypeLocalityDto(String tnp, String name) {
        this.tnp = tnp;
        this.name = name;
    }

    public String getTnp() {
        return tnp;
    }

    public String getName() {
        return name;
    }
}
