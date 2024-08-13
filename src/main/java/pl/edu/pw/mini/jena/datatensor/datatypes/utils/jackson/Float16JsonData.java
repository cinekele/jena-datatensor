package pl.edu.pw.mini.jena.datatensor.datatypes.utils.jackson;

import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.Arrays;

@JsonTypeName("float16")
public class Float16JsonData extends JSONData {
    private float[] data;

    public Float16JsonData() {
        super("float16");
    }

    public Float16JsonData(float[] data, long[] shape) {
        super("float16");
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
        if (!(o instanceof Float16JsonData)) return false;
        if (!super.equals(o)) return false;

        Float16JsonData that = (Float16JsonData) o;
        return super.equals(that) && Arrays.equals(getData(), that.getData());
    }
}
