package pl.edu.pw.mini.jena.datatensor.datatypes.utils.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Arrays;

import static com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type")
@JsonSubTypes({
        @Type(value = Float16JSONData.class, name = "float16"),
        @Type(value = Float32JSONData.class, name = "float32"),
        @Type(value = Float64JSONData.class, name = "float64"),
        @Type(value = Int16JSONData.class, name = "int16"),
        @Type(value = Int32JSONData.class, name = "int32"),
        @Type(value = Int64JSONData.class, name = "int64"),
        @Type(value = BooleanJSONData.class, name = "boolean")
})
@JsonPropertyOrder({"type", "shape"})
abstract public class JSONData {
    @JsonProperty("type")
    private final String type;
    private long[] shape;

    public JSONData(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public long[] getShape() {
        return shape;
    }

    public void setShape(long[] shape) {
        this.shape = shape;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JSONData)) return false;

        JSONData jsonData = (JSONData) o;
        return getType().equals(jsonData.getType()) && Arrays.equals(getShape(), jsonData.getShape());
    }
}

