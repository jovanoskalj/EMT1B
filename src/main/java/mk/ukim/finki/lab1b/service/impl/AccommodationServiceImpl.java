package mk.ukim.finki.lab1b.service.impl;

import mk.ukim.finki.lab1b.model.Accommodation;
import mk.ukim.finki.lab1b.model.dto.AccommodationDto;
import mk.ukim.finki.lab1b.repository.AccommodationRepository;
import mk.ukim.finki.lab1b.service.AccommodationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccommodationServiceImpl implements AccommodationService {

    private final AccommodationRepository accommodationRepository;

    public AccommodationServiceImpl(AccommodationRepository accommodationRepository) {
        this.accommodationRepository = accommodationRepository;
    }

    @Override
    public List<Accommodation> findAll() {
        return accommodationRepository.findAll();
    }

    @Override
    public Optional<Accommodation> findById(Long id) {
        return Optional.of(accommodationRepository.findById(id).orElseThrow(RuntimeException::new));
    }

    @Override
    public Optional<Accommodation> save(AccommodationDto accommodationDto) {
        return Optional.empty();
    }

    @Override
    public Optional<Accommodation> update(Long id, AccommodationDto accommodationDto) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }
}
