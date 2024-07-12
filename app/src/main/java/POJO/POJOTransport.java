
package POJO;

import com.google.gson.annotations.SerializedName;

public class POJOTransport {
    @SerializedName("id")
    String id;

    @SerializedName("cat_name")
    String catName;


    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
    public String getCatName() {
        return catName;
    }


}

