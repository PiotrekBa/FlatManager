package pl.piotrbartoszak.model;

import java.util.ArrayList;
import java.util.List;

import static pl.piotrbartoszak.model.RoomDetailsView.fromRoom;

public class FlatDetailsView {

    private long id;
    private String name;
    private String address;
    private List<RoomDetailsView> rooms;

    public static FlatDetailsView fromFlat(Flat flat) {
        FlatDetailsView flatDetailsView = new FlatDetailsView();
        flatDetailsView.setId(flat.getId());
        flatDetailsView.setName(flat.getName());
        flatDetailsView.setAddress(flat.getAddress());
        return flatDetailsView;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<RoomDetailsView> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomDetailsView> rooms) {
        this.rooms = rooms;
    }

}
