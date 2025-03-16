package mk.ukim.finki.lab1b.service;


import mk.ukim.finki.lab1b.model.Accommodation;
import mk.ukim.finki.lab1b.model.dto.AccommodationDto;

import java.util.List;
import java.util.Optional;

public interface AccommodationService {

     List<Accommodation> findAll();
     Optional<Accommodation> findById();
     Optional <Accommodation> save (AccommodationDto accommodationDto);
     Optional <Accommodation> update (Long id, AccommodationDto accommodationDto);
     void delete (Long id, AccommodationDto accommodationDto);
}
