package ir.pahmadvand.jokeslist.mvp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class BaseModel {
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("value")
    @Expose
    private List<DataModel> value = null;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<DataModel> getValue() {
        return value;
    }

    public void setValue(List<DataModel> value) {
        this.value = value;
    }

}
