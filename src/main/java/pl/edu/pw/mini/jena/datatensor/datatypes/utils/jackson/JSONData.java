package pl.edu.pw.mini.jena.datatensor.datatypes.utils.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import static com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type")
@JsonSubTypes({
        @Type(value = FloatJSONData.class, name = "float"),
        @Type(value = DoubleJSONData.class, name = "double"),
        @Type(value = ShortJSONData.class, name = "short"),
        @Type(value = IntJSONData.class, name = "int"),
        @Type(value = LongJSONData.class, name = "long"),
        @Type(value = StringJSONData.class, name = "string"),
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

