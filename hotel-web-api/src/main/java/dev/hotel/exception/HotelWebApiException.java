package dev.hotel.exception;

public class HotelWebApiException extends RuntimeException {

    public HotelWebApiException() {
    }

    public HotelWebApiException(String message) {
        super(message);
    }

    public HotelWebApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public HotelWebApiException(Throwable cause) {
        super(cause);
    }
}
