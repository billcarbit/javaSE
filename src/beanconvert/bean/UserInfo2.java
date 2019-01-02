package beanconvert.bean;

import beanconvert.ValueFrom;

public class UserInfo2 extends UserInfo {
    @ValueFrom(superFiled = "ID", replaced = true)
    private String id;
    @ValueFrom(superFiled = "USER_TYPE", replaced = true)
    private String userType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
