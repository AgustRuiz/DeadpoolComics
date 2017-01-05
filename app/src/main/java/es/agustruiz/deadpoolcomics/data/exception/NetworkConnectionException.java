package es.agustruiz.deadpoolcomics.data.exception;

public class NetworkConnectionException extends Exception{

    //region [Exception methods]

    public NetworkConnectionException() {
        super();
    }

    public NetworkConnectionException(String message) {
        super(message);
    }

    public NetworkConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public NetworkConnectionException(Throwable cause) {
        super(cause);
    }

    //endregion

}
