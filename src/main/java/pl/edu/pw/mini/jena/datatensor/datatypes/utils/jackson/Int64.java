package pl.edu.pw.mini.jena.datatensor.datatypes.utils.jackson;


import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("int64")
public class Int64 extends JSONData {
    private long[] data;

    public Int64() {
        super("int64");
    }

    public long[] getData() {
        return data;
    }

    public void setData(long[] data) {
        this.data = data;
    }

}
