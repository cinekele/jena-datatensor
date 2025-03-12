package pl.edu.pw.mini.jena.datatensor.datatypes.utils.jackson;


import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.Arrays;

@JsonTypeName("int32")
public class Int32JSONData extends JSONData {
    private int[] data;

    public Int32JSONData() {
        super("int32");
    }

    public Int32JSONData(int[] data, long[] shape) {
        super("int32");
        super.setShape(shape);
        this.data = data;
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Int32JSONData)) return false;
        if (!super.equals(o)) return false;

        Int32JSONData that = (Int32JSONData) o;
        return super.equals(that) && Arrays.equals(getData(), that.getData());
    }
}
