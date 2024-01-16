package be.vdab.startrek.services;

import be.vdab.startrek.domain.Bestelling;
import be.vdab.startrek.dto.NieuweBestelling;
import be.vdab.startrek.exceptions.WerknemerNietGevondenException;
import be.vdab.startrek.repositories.BestellingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

// enkele imports
@Service
@Transactional(readOnly = true)
public class BestellingService {
    private final BestellingRepository bestellingRepository;
    // constructor met parameter (dependency injection)
    public List<Bestelling> findByWerknemerId(long werknemerId) {
        return bestellingRepository.findByWerknemerId(werknemerId);
    }
    @Transactional
    public void create(long werknemerId, NieuweBestelling nieuweBestelling) {
        var werknemer = werknemerRepository.findAndLockById(werknemerId)
                .orElseThrow(() -> new WerknemerNietGevondenException(werknemerId));
        var bestelling = new Bestelling(werknemerId,
                nieuweBestelling.omschrijving(), nieuweBestelling.bedrag(),
                LocalDateTime.now());
        bestellingRepository.create(bestelling);
        werknemer.bestel(nieuweBestelling.bedrag());
        werknemerRepository.updateBudget(werknemerId, werknemer.getBudget());
    }
}