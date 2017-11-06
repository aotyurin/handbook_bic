package main.java.bd.preparedParams;

import java.util.ArrayList;
import java.util.List;

public class PreparedParamsSetter {
    List<PreparedParams> preparedParamsList = new ArrayList<>();

    public void setValues(String name, Object value) {
        preparedParamsList.add(new PreparedParams(name, value));
    }

    public List<PreparedParams> getPreparedParamsList() {
        return preparedParamsList;
    }

}
