package be.vdab.startrek.startrek.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// enkele imports
@ResponseStatus(HttpStatus.NOT_FOUND)
public class WerknemerNietGevondenException extends RuntimeException {
    public WerknemerNietGevondenException(long id) {
        super("Werknemer niet gevonden. Id: " + id);
    }
}