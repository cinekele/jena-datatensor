package pl.edu.pw.mini.jena.datatensor.datatypes.utils.parser;


import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("double")
public class DoubleJSONData extends JSONData {
    private double[] data;

    public DoubleJSONData() {
        super();
        super.setType("double");
    }

    public double[] getData() {
        return data;
    }

    public void setData(double[] data) {
        this.data = data;
    }
}
