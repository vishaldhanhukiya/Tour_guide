package POJO;

import com.google.gson.annotations.SerializedName;

public class POJOATM {
    @SerializedName("user_name")
    String userName;

    @SerializedName("email")
    String email;

    @SerializedName("name")
    String name;


    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}