package dev.hotel.exception;

//@ResponseStatus(HttpStatus.BAD_REQUEST) // 400
public class ClientNotFoundException extends HotelWebApiException {

    public ClientNotFoundException() {
    }

    public ClientNotFoundException(String message) {
        super(message);
    }

    public ClientNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClientNotFoundException(Throwable cause) {
        super(cause);
    }
}
