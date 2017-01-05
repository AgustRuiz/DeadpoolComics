package es.agustruiz.deadpoolcomics.domain.executor;

public interface PostExecutionThread {

    void post(Runnable runnable);

}
