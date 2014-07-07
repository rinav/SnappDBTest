package com.inappstudios.snappdbtest;

import com.google.gson.annotations.SerializedName;

/**
 * Created by riinav on 7/7/14.
 */
public class UserBasicInfo extends User {

    @SerializedName("name")
    private String userName;

    @SerializedName("email")
    private String emailId;

    public UserBasicInfo() {
        super();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserBasicInfo)) return false;
        if (!super.equals(o)) return false;

        UserBasicInfo that = (UserBasicInfo) o;

        if (emailId != null ? !emailId.equals(that.emailId) : that.emailId != null) return false;
        if (!userName.equals(that.userName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + userName.hashCode();
        result = 31 * result + (emailId != null ? emailId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + " UserBasicInfo{" +
                "userName='" + userName + '\'' +
                ", emailId='" + emailId + '\'' +
                '}';
    }
}
