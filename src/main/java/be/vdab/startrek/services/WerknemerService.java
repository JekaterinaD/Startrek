package be.vdab.startrek.services;

import be.vdab.startrek.domain.Werknemer;
import be.vdab.startrek.repositories.WerknemerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// enkele imports
@Service
@Transactional(readOnly = true)
public class WerknemerService {

    private final WerknemerRepository werknemerRepository;
    // constructor met parameter (dependency injection)
    public WerknemerService(WerknemerRepository werknemerRepository) {
        this.werknemerRepository = werknemerRepository;
    }
    public List<Werknemer> findAll() {
        return werknemerRepository.findAll();
    }
}