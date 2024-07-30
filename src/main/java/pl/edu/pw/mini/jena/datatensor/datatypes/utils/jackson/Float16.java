package pl.edu.pw.mini.jena.datatensor.datatypes.utils.jackson;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("float16")
public class Float16 extends JSONData {
    private float[] data;

    public Float16() {
        super("float16");
    }

    public float[] getData() {
        return data;
    }

    public void setData(float[] data) {
        this.data = data;
    }
}
