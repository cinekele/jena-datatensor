package pl.edu.pw.mini.jena.datatensor.datatypes.utils.jackson;


import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("int32")
public class Int32 extends JSONData {
    private int[] data;

    public Int32() {
        super("int32");
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }


}
