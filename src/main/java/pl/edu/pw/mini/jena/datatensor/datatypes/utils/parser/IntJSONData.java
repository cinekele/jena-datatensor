package pl.edu.pw.mini.jena.datatensor.datatypes.utils.parser;


import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("int")
public class IntJSONData extends JSONData {
    private int[] data;

    public IntJSONData() {
        super();
        super.setType("int");
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }


}
