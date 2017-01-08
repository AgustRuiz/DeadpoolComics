package es.agustruiz.deadpoolcomics.domain.interactor;

import android.util.Log;

import javax.inject.Inject;

import es.agustruiz.deadpoolcomics.Utils;
import es.agustruiz.deadpoolcomics.domain.exception.ErrorBundle;
import es.agustruiz.deadpoolcomics.domain.executor.PostExecutionThread;
import es.agustruiz.deadpoolcomics.domain.executor.ThreadExecutor;
import es.agustruiz.deadpoolcomics.domain.model.ComicDomain;
import es.agustruiz.deadpoolcomics.domain.repository.ComicDomainRepository;

public class GetComicDetailsUseCaseImpl implements GetComicDetailsUseCase {

    static final String LOG_TAG =
            Utils.buildLogTag(GetComicDetailsUseCaseImpl.class.getSimpleName());

    private final ComicDomainRepository mComicDomainRepository;
    private final ThreadExecutor mThreadExecutor;
    private final PostExecutionThread mPostExecutionThread;

    private int mComicId = -1;
    private GetComicDetailsUseCase.Callback mCallback;

    @Inject
    public GetComicDetailsUseCaseImpl(ComicDomainRepository comicDomainRepository,
                                      ThreadExecutor threadExecutor,
                                      PostExecutionThread postExecutionThread) {
        mComicDomainRepository = comicDomainRepository;
        mThreadExecutor = threadExecutor;
        mPostExecutionThread = postExecutionThread;
    }

    //region [GetComicDetailsUseCase methods]

    @Override
    public void execute(int comicId, Callback callback) {
        Log.d(LOG_TAG,String.format("execute"));
        if(comicId < 0 || callback == null){
            throw new IllegalArgumentException("Not valid parameters!");
        }
        mComicId = comicId;
        mCallback = callback;
        mThreadExecutor.execute(this);
    }

    //endregion

    //region [Interactor methods]

    @Override
    public void run() {
        Log.d(LOG_TAG,String.format("run"));
        mComicDomainRepository.getComicDetails(mComicId, new ComicDomainRepository.ComicDetailsCallback() {
            @Override
            public void onComicDetailsLoaded(ComicDomain comicDomain) {
                Log.d(LOG_TAG,String.format("onComicDetailsLoaded"));
                notifyGetComicDetailsSuccessfully(comicDomain);
            }
            @Override
            public void onError(ErrorBundle errorBundle) {
                Log.d(LOG_TAG,String.format("onError"));
                notifyError(errorBundle);
            }
        });
    }

    //endregion

    //region [Private methods]

    private void notifyGetComicDetailsSuccessfully(final ComicDomain comicDomain){
        mPostExecutionThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onComicDataLoaded(comicDomain);
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
