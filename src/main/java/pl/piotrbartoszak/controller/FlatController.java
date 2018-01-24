package pl.piotrbartoszak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.bind.annotation.*;
import pl.piotrbartoszak.converter.FlatConverter;
import pl.piotrbartoszak.model.Flat;
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


    @GetMapping
    public List<Flat> flats() {

        return flatRepository.findAll();
    }

    @PostMapping
    public void addFlat(@RequestBody Flat flat) {
        Owner owner = ownerRepository.findOne(1L);
        flat.setOwner(owner);
        flatRepository.save(flat);
    }

    public void addFormatter(FormatterRegistry registry) {
        registry.addConverter(getFlatConverter());
    }

    @Bean
    public FlatConverter getFlatConverter() {
        return new FlatConverter();
    }


}
