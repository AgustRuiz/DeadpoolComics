package es.agustruiz.deadpoolcomics.domain.exception;

public interface ErrorBundle {

    Exception getException();
    String getErrorMessage();

}
