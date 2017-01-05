package es.agustruiz.deadpoolcomics.data.exception;

import es.agustruiz.deadpoolcomics.domain.exception.ErrorBundle;

public class RepositoryErrorBundle implements ErrorBundle {

    private final Exception mException;

    public RepositoryErrorBundle(Exception exception) {
        mException = exception;
    }

    //region [ErrorBundle methods]

    @Override
    public Exception getException() {
        return mException;
    }

    @Override
    public String getErrorMessage() {
        return (mException != null ? mException.getMessage() : "");
    }

    //endregion
}
