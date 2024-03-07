package pl.edu.pw.mini.jena.datatensor.datatypes.utils.parser;


import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("float")
public class FloatJSONData extends JSONData {
    private float[] data;

    public FloatJSONData() {
        super();
        super.setType("float");
    }

    public float[] getData() {
        return data;
    }

    public void setData(float[] data) {
        this.data = data;
    }

}
