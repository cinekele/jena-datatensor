package pl.edu.pw.mini.jena.datatensor.datatypes.utils.jackson;

import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.Arrays;

@JsonTypeName("int16")
public class Int16JSONData extends JSONData {
    private short[] data;

    public Int16JSONData() {
        super("int16");
    }

    public Int16JSONData(short[] data, long[] shape) {
        super("int16");
        super.setShape(shape);
        this.data = data;
    }

    public short[] getData() {
        return data;
    }

    public void setData(short[] data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Int16JSONData)) return false;
        if (!super.equals(o)) return false;

        Int16JSONData that = (Int16JSONData) o;
        return super.equals(that) && Arrays.equals(getData(), that.getData());
    }

}
