package pl.edu.pw.mini.jena.datatensor.datatypes.utils.parser;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type", visible = true)
@JsonSubTypes({
        @Type(value = FloatJSONData.class, name = "float"),
        @Type(value = DoubleJSONData.class, name = "double"),
        @Type(value = ShortJSONData.class, name = "short"),
        @Type(value = IntJSONData.class, name = "int"),
        @Type(value = LongJSONData.class, name = "long"),
})
@JsonPropertyOrder({"type", "shape"})
abstract public class JSONData {
    @JsonProperty("type")
    private String type;
    private List<Long> shape;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Long> getShape() {
        return shape;
    }

    public void setShape(List<Long> shape) {
        this.shape = shape;
    }
}

