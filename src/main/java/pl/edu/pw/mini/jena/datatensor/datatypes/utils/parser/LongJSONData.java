package pl.edu.pw.mini.jena.datatensor.datatypes.utils.parser;


import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("long")
public class LongJSONData extends JSONData {
    private long[] data;

    public LongJSONData() {
        super();
        super.setType("long");
    }

    public long[] getData() {
        return data;
    }

    public void setData(long[] data) {
        this.data = data;
    }

}
