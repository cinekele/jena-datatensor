package pl.edu.pw.mini.jena.datatensor.datatypes.utils.jackson;


import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.Arrays;

@JsonTypeName("float32")
public class Float32JSONData extends JSONData {
    private float[] data;

    public Float32JSONData() {
        super("float32");
    }

    public Float32JSONData(float[] data, long[] shape) {
        super("float32");
        super.setShape(shape);
        this.data = data;
    }

    public float[] getData() {
        return data;
    }

    public void setData(float[] data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Float32JSONData)) return false;
        if (!super.equals(o)) return false;

        Float32JSONData that = (Float32JSONData) o;
        return super.equals(that) && Arrays.equals(getData(), that.getData());
    }
}
