package mk.ukim.finki.lab1b.service.impl;

import mk.ukim.finki.lab1b.model.Country;
import mk.ukim.finki.lab1b.repository.CountryRepository;
import mk.ukim.finki.lab1b.service.CountryService;
import org.antlr.v4.runtime.atn.SemanticContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return Optional.of(countryRepository.findById(id).orElseThrow(RuntimeException::new));
    }

    @Override
    public Optional<Country> save(Country country) {
        if (country.getName().equals(null)) {
            return Optional.empty();
        }
        if (country.getContinent().equals(null)) {
            return Optional.empty();
        }
        return Optional.of(countryRepository.save(new Country(country.getName(), country.getContinent())));
    }

    @Override
    public Optional<Country> update(Long id, Country country) {
        Optional<Country> country1 = countryRepository.findById(id);
        if (country.getContinent() != null) {
            country1.get().setContinent(country.getContinent());
        }
        if (country.getName() != null) {
            country1.get().setName(country.getName());
        }
        return Optional.of(countryRepository.save(country1.get()));
    }

    @Override
    public void delete(Long id) {
        Optional<Country> country = countryRepository.findById(id);
        countryRepository.delete(country.get());
    }
}
