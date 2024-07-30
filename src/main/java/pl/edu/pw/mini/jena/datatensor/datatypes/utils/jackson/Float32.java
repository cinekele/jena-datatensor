package pl.edu.pw.mini.jena.datatensor.datatypes.utils.jackson;


import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("float32")
public class Float32 extends JSONData {
    private float[] data;

    public Float32() {
        super("float32");
    }

    public float[] getData() {
        return data;
    }

    public void setData(float[] data) {
        this.data = data;
    }

}
