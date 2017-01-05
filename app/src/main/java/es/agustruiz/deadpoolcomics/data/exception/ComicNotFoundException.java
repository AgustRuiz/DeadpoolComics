package es.agustruiz.deadpoolcomics.data.exception;

public class ComicNotFoundException extends Exception {

    //region [Exception methods]

    public ComicNotFoundException() {
        super();
    }

    public ComicNotFoundException(String message) {
        super(message);
    }

    public ComicNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ComicNotFoundException(Throwable cause) {
        super(cause);
    }

    //endregion

}
