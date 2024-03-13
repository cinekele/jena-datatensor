package pl.edu.pw.mini.jena.datatensor.datatypes.utils.jackson;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
@JsonIgnoreProperties(value = "type")
@JsonTypeName("boolean")
public class BooleanJSONData extends JSONData {
    private boolean[] data;

    public BooleanJSONData() {
        super("boolean");
    }

    public boolean[] getData() {
        return data;
    }

    public void setData(boolean[] data) {
        this.data = data;
    }
}

