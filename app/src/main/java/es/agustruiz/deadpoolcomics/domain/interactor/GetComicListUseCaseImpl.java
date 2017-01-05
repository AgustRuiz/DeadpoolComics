package es.agustruiz.deadpoolcomics.domain.interactor;

import java.util.Collection;

import javax.inject.Inject;

import es.agustruiz.deadpoolcomics.domain.exception.ErrorBundle;
import es.agustruiz.deadpoolcomics.domain.executor.PostExecutionThread;
import es.agustruiz.deadpoolcomics.domain.executor.ThreadExecutor;
import es.agustruiz.deadpoolcomics.domain.model.ComicDomain;
import es.agustruiz.deadpoolcomics.domain.repository.ComicDomainRepository;

public class GetComicListUseCaseImpl implements GetComicListUseCase {

    private final ComicDomainRepository mComicDomainRepository;
    private final ThreadExecutor mThreadExecutor;
    private final PostExecutionThread mPostExecutionThread;
    private final ComicDomainRepository.ComicListCallback repositoryCallback =
            new ComicDomainRepository.ComicListCallback() {
                @Override
                public void onComicListLoaded(Collection<ComicDomain> comicDomainCollection) {
                    notifyGetComicListSuccessfully(comicDomainCollection);
                }

                @Override
                public void onError(ErrorBundle errorBundle) {
                    notifyError(errorBundle);
                }
            };
    private Callback mCallback;

    @Inject
    public GetComicListUseCaseImpl(ComicDomainRepository comicDomainRepository,
                                   ThreadExecutor threadExecutor,
                                   PostExecutionThread postExecutionThread) {
        mComicDomainRepository = comicDomainRepository;
        mThreadExecutor = threadExecutor;
        mPostExecutionThread = postExecutionThread;
    }

    //region [GetComicListUseCase methods]

    @Override
    public void execute(Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("Interactor callback cannot be null");
        }
        mCallback = callback;
        mThreadExecutor.execute(this);
    }

    //endregion

    //region [Interactor methods]

    @Override
    public void run() {
        mComicDomainRepository.getComicList(repositoryCallback);
    }

    //endregion

    //region [private methods]

    private void notifyGetComicListSuccessfully(final Collection<ComicDomain> collection){
        mPostExecutionThread.post(new Runnable(){
            @Override
            public void run() {
                mCallback.onComicListLoaded(collection);
            }
        });
    }

    private void notifyError(final ErrorBundle errorBundle){
        mPostExecutionThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onError(errorBundle);
            }
        });
    }

    //endregion

}
