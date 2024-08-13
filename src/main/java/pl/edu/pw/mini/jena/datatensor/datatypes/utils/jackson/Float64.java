package pl.edu.pw.mini.jena.datatensor.datatypes.utils.jackson;


import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.Arrays;

@JsonTypeName("float64")
public class Float64 extends JSONData {
    private double[] data;

    public Float64() {
        super("float64");
    }

    public Float64(double[] data, long[] shape) {
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
        if (!(o instanceof Float64)) return false;
        if (!super.equals(o)) return false;

        Float64 that = (Float64) o;
        return super.equals(that) && Arrays.equals(getData(), that.getData());
    }
}
