package dev.hotel.exception;

import java.util.ArrayList;
import java.util.List;

public class ReservationException extends HotelWebApiException {

    List<String> erreurs = new ArrayList<>();

    public ReservationException(List<String> erreurs) {
        this.erreurs = erreurs;
    }

    public ReservationException() {
    }

    public ReservationException(String message) {
        super(message);
        this.erreurs.add(message);
    }

    public ReservationException(String message, Throwable cause) {
        super(message, cause);
        this.erreurs.add(message);
    }

    public ReservationException(Throwable cause) {
        super(cause);
    }

    public List<String> getErreurs() {
        return erreurs;
    }
}
