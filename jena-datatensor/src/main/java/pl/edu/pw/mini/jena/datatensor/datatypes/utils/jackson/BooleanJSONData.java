package pl.edu.pw.mini.jena.datatensor.datatypes.utils.jackson;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.Arrays;

@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
@JsonIgnoreProperties(value = "type")
@JsonTypeName("boolean")
public class BooleanJSONData extends JSONData {
    private boolean[] data;

    public BooleanJSONData() {
        super("boolean");
    }

    public BooleanJSONData(long[] shape, boolean[] data) {
        super("boolean");
        super.setShape(shape);
        this.data = data;
    }

    public boolean[] getData() {
        return data;
    }

    public void setData(boolean[] data) {
        this.data = data;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BooleanJSONData)) return false;
        if (!super.equals(o)) return false;

        BooleanJSONData that = (BooleanJSONData) o;
        return super.equals(that) && Arrays.equals(getData(), that.getData());
    }
}

