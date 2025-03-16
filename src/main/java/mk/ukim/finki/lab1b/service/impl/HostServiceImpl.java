package mk.ukim.finki.lab1b.service.impl;

import mk.ukim.finki.lab1b.model.Host;
import mk.ukim.finki.lab1b.model.dto.HostDto;
import mk.ukim.finki.lab1b.repository.CountryRepository;
import mk.ukim.finki.lab1b.repository.HostRepository;
import mk.ukim.finki.lab1b.service.CountryService;
import mk.ukim.finki.lab1b.service.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostServiceImpl implements HostService {

    private final HostRepository hostRepository;
    private final CountryService countryService;

    public HostServiceImpl(HostRepository hostRepository, CountryService countryService) {
        this.hostRepository = hostRepository;
        this.countryService = countryService;

    }

    @Override
    public List<Host> findAll() {
        return hostRepository.findAll();
    }

    @Override
    public Optional<Host> findById(Long id) {
        return Optional.of(hostRepository.findById(id).orElseThrow(RuntimeException::new));
    }

    @Override
    public Optional<Host> save(HostDto hostDto) {

        if(hostDto.getName()==null && hostDto.getSurname()==null && !countryService.findById(hostDto.getCountry()).isPresent()){
            return Optional.empty();
        }
        return Optional.of(hostRepository.save(new Host(hostDto.getName(), hostDto.getSurname(),countryService.findById(hostDto.getCountry()).get())));
    }

    @Override
    public Optional<Host> update(Long id, HostDto hostDto) {
        if(hostRepository.findById(id).isPresent()) {
            Host host = hostRepository.findById(id).get();
            host.setName(hostDto.getName());
            host.setCountry(countryService.findById(hostDto.getCountry()).get());
            host.setSurname(hostDto.getSurname());
            return Optional.of(hostRepository.save(new Host(host.getName(), host.getSurname(),host.getCountry())));

        }

        return Optional.empty();
    }

    @Override
    public void delete(Long id) {
        if(hostRepository.findById(id).isPresent()){
            hostRepository.delete(hostRepository.findById(id).get());
        }
    }
}
