package pl.piotrbartoszak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.bind.annotation.*;
import pl.piotrbartoszak.converter.FlatConverter;
import pl.piotrbartoszak.model.Flat;
import pl.piotrbartoszak.model.FlatDetailsView;
import pl.piotrbartoszak.model.Owner;
import pl.piotrbartoszak.repository.FlatRepository;
import pl.piotrbartoszak.repository.OwnerRepository;

import java.util.List;

@RestController
@RequestMapping("/flats")
public class FlatController {

    @Autowired
    FlatRepository flatRepository;

    @Autowired
    OwnerRepository ownerRepository;


    @GetMapping("")
    public List<Flat> allFlats() {
        return flatRepository.findByOwnerId(1l);

    }

    @PostMapping("")
    public void addFlat(@RequestBody Flat flat) {
        Owner owner = ownerRepository.findOne(1L);
        flat.setOwner(owner);
        flatRepository.save(flat);
    }

    @GetMapping("/{id}")
    public Flat showFlat(@PathVariable long id) {
        Flat flat = flatRepository.findOne(id);
        return flat;
    }

    @DeleteMapping("/{id}")
    public void deleteFlat(@PathVariable long id) {
        Flat flat = flatRepository.findOne(id);
        flat.setEnable(false);
        flatRepository.save(flat);
    }

    @PutMapping("/{id}")
    public void updateFlat(@PathVariable long id, @RequestBody Flat flat){
        Owner owner = ownerRepository.findOne(1l);
        flat.setOwner(owner);
        flatRepository.save(flat);
    }



}
