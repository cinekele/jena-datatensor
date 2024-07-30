package pl.edu.pw.mini.jena.datatensor.datatypes.utils.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import static com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type")
@JsonSubTypes({
        @Type(value = Float16.class, name = "float16"),
        @Type(value = Float32.class, name = "float32"),
        @Type(value = Float64.class, name = "float64"),
        @Type(value = Int16.class, name = "int16"),
        @Type(value = Int32.class, name = "int32"),
        @Type(value = Int64.class, name = "int64"),
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
}

