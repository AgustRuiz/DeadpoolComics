package es.agustruiz.deadpoolcomics.domain.executor;

public interface ThreadExecutor {

    void execute(final Runnable runnable);

}
