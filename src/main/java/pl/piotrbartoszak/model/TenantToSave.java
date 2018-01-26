package pl.piotrbartoszak.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

public class TenantToSave {

    private String firstName;

    private String lastName;

    private String phone;

    private String email;

    private long roomId;

    public TenantToSave fromTenant() {
        return new TenantToSave();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }
}
