package main.java.dto;


public class RegionDto {
    private String rgn;
    private String name;

    public RegionDto(String rgn, String name) {
        this.rgn = rgn;
        this.name = name;
    }

    public String getRgn() {
        return rgn;
    }

    public String getName() {
        return name;
    }
}
