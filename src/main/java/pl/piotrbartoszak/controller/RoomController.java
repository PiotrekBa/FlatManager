package pl.piotrbartoszak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.piotrbartoszak.model.Flat;
import pl.piotrbartoszak.model.Room;
import pl.piotrbartoszak.model.RoomToSave;
import pl.piotrbartoszak.repository.FlatRepository;
import pl.piotrbartoszak.repository.RoomRepository;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    FlatRepository flatRepository;

    @PostMapping("")
    public void saveRoom(@RequestBody RoomToSave roomToSave) {
        Room room = new Room();
        room.setArea(roomToSave.getArea());
        room.setRent(roomToSave.getRent());
        Flat flat = flatRepository.findOne(roomToSave.getFlatId());
        room.setFlat(flat);
        roomRepository.save(room);
    }

    @GetMapping("/{id}")
    public Room showRoom(@PathVariable long id) {
        return roomRepository.findOne(id);
    }

    @PutMapping("/{id}")
    public void updateRoom(@RequestBody RoomToSave roomToSave) {
        Room room = roomRepository.findOne(roomToSave.getId());
        room.setRent(roomToSave.getRent());
        room.setArea(roomToSave.getArea());
        roomRepository.save(room);
    }
}
