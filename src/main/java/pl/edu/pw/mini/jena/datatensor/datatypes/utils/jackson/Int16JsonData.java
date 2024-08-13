package pl.edu.pw.mini.jena.datatensor.datatypes.utils.jackson;

import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.Arrays;

@JsonTypeName("int16")
public class Int16JsonData extends JSONData {
    private short[] data;

    public Int16JsonData() {
        super("int16");
    }

    public Int16JsonData(short[] data, long[] shape) {
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
        if (!(o instanceof Int16JsonData)) return false;
        if (!super.equals(o)) return false;

        Int16JsonData that = (Int16JsonData) o;
        return super.equals(that) && Arrays.equals(getData(), that.getData());
    }

}
