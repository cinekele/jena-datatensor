package pl.edu.pw.mini.jena.datatensor.datatypes.utils.jackson;


import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("float64")
public class Float64 extends JSONData {
    private double[] data;

    public Float64() {
        super("float64");
    }

    public double[] getData() {
        return data;
    }

    public void setData(double[] data) {
        this.data = data;
    }
}
