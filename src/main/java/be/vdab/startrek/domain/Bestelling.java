package be.vdab.startrek.startrek.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

// enkele imports
public class Bestelling {
    private final long id;
    private final long werknemerId;
    private final String omschrijving;
    private final BigDecimal bedrag;
    private final LocalDateTime moment;
    // constructor met parameters
// nog een constructor:
    public Bestelling(long werknemerId, String omschrijving, BigDecimal bedrag,
                      LocalDateTime moment) {
        this(0, werknemerId, omschrijving, bedrag, moment);
    }

    public Bestelling(long id, long werknemerId, String omschrijving, BigDecimal bedrag, LocalDateTime moment) {
        this.id = id;
        this.werknemerId = werknemerId;
        this.omschrijving = omschrijving;
        this.bedrag = bedrag;
        this.moment = moment;
    }

    public long getId() {
        return id;
    }

    public long getWerknemerId() {
        return werknemerId;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public BigDecimal getBedrag() {
        return bedrag;
    }

    public LocalDateTime getMoment() {
        return moment;
    }
// getters
}