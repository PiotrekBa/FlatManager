package pl.piotrbartoszak.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import pl.piotrbartoszak.repository.RoomRepository;
import pl.piotrbartoszak.repository.TenantRepository;

import javax.persistence.*;
import java.util.List;

public class RoomDetailsView {

    @Autowired
    TenantRepository tenantRepository;

    private double area;

    private long rent;

    private Flat flat;

    private List<Tenant> tenant;

    public RoomDetailsView() {
    }

    public static RoomDetailsView fromRoom(Room room) {
        RoomDetailsView roomDetailsView = new RoomDetailsView();
        roomDetailsView.setArea(room.getArea());
        roomDetailsView.setRent(room.getRent());
        return roomDetailsView;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public long getRent() {
        return rent;
    }

    public void setRent(long rent) {
        this.rent = rent;
    }

    public Flat getFlat() {
        return flat;
    }

    public void setFlat(Flat flat) {
        this.flat = flat;
    }

    public List<Tenant> getTenant() {
        return tenant;
    }

    public void setTenant(List<Tenant> tenant) {
        this.tenant = tenant;
    }

}
