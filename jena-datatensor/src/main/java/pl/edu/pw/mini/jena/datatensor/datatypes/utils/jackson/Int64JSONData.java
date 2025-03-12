package pl.edu.pw.mini.jena.datatensor.datatypes.utils.jackson;


import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("int64")
public class Int64JSONData extends JSONData {
    private long[] data;

    public Int64JSONData() {
        super("int64");
    }

    public Int64JSONData(long[] data, long[] shape) {
        super("int64");
        super.setShape(shape);
        this.data = data;
    }

    public long[] getData() {
        return data;
    }

    public void setData(long[] data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Int64JSONData)) return false;
        if (!super.equals(o)) return false;

        Int64JSONData that = (Int64JSONData) o;
        return super.equals(that) && java.util.Arrays.equals(getData(), that.getData());
    }
}
