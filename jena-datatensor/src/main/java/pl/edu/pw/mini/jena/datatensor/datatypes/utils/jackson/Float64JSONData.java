package pl.edu.pw.mini.jena.datatensor.datatypes.utils.jackson;


import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.Arrays;

@JsonTypeName("float64")
public class Float64JSONData extends JSONData {
    private double[] data;

    public Float64JSONData() {
        super("float64");
    }

    public Float64JSONData(double[] data, long[] shape) {
        super("float64");
        super.setShape(shape);
        this.data = data;
    }

    public double[] getData() {
        return data;
    }

    public void setData(double[] data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Float64JSONData)) return false;
        if (!super.equals(o)) return false;

        Float64JSONData that = (Float64JSONData) o;
        return super.equals(that) && Arrays.equals(getData(), that.getData());
    }
}
