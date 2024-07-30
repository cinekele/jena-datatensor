package pl.edu.pw.mini.jena.datatensor.datatypes.utils.jackson;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("int16")
public class Int16 extends JSONData {
    private short[] data;

    public Int16() {
        super("int16");
    }

    public short[] getData() {
        return data;
    }

    public void setData(short[] data) {
        this.data = data;
    }

}
