package be.vdab.startrek.startrek.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// enkele imports
@ResponseStatus(HttpStatus.CONFLICT)
public class OnvoldoendeBudgetException extends RuntimeException {
    public OnvoldoendeBudgetException() {
        super("Onvoldoende budget");
    }
}