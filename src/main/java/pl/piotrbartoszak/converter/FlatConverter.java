package pl.piotrbartoszak.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.piotrbartoszak.model.Flat;
import pl.piotrbartoszak.repository.FlatRepository;

public class FlatConverter implements Converter<String, Flat> {

    @Autowired
    private FlatRepository flatRepository;

    @Override
    public Flat convert(String s) {
        Flat flat = flatRepository.findOne(Long.valueOf(s));
        return flat;
    }
}
