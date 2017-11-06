package main.java.bd.preparedParams;

public class PreparedParams {
    private String name;
    private String value;

    PreparedParams(String name, Object value) {
        this.name = name;
        if (value instanceof String) {
            this.value = "'" + value + "'";
        } else {
            this.value = value.toString();
        }
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
