package com.inappstudios.snappdbtest;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by riinav on 7/7/14.
 */
public class User implements Serializable {

    @SerializedName("facebook_id")
    private String userFBId;

    @SerializedName("status")
    private String registrationStatus;


    private transient Date registeredOnDate;

    public User() {
    }

    public String getUserFBId() {
        return userFBId;
    }

    public void setUserFBId(String userFBId) {
        this.userFBId = userFBId;
    }

    public String getRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(String registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    public Date getRegisteredOnDate() {
        return registeredOnDate;
    }

    public void setRegisteredOnDate(Date registeredOnDate) {
        this.registeredOnDate = registeredOnDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (registeredOnDate != null ? !registeredOnDate.equals(user.registeredOnDate) : user.registeredOnDate != null)
            return false;
        if (registrationStatus != null ? !registrationStatus.equals(user.registrationStatus) : user.registrationStatus != null)
            return false;
        if (!userFBId.equals(user.userFBId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userFBId.hashCode();
        result = 31 * result + (registrationStatus != null ? registrationStatus.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "userFBId='" + userFBId + '\'' +
                ", registrationStatus='" + registrationStatus + '\'' +
                ", registeredOnDate=" + registeredOnDate +
                '}';
    }
}
