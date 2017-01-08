package es.agustruiz.deadpoolcomics.presentation.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import javax.inject.Inject;

import es.agustruiz.deadpoolcomics.Utils;
import es.agustruiz.deadpoolcomics.domain.exception.ErrorBundle;
import es.agustruiz.deadpoolcomics.domain.interactor.GetComicDetailsUseCase;
import es.agustruiz.deadpoolcomics.domain.model.ComicDomain;
import es.agustruiz.deadpoolcomics.presentation.exception.ErrorMessageFactory;
import es.agustruiz.deadpoolcomics.presentation.model.mapper.ComicDomainToPresentationMapper;
import es.agustruiz.deadpoolcomics.presentation.view.ComicDetailsView;

public class ComicDetailsPresenter implements Presenter {

    static final String LOG_TAG = Utils.buildLogTag(ComicDetailsPresenter.class.getSimpleName());

    private final GetComicDetailsUseCase mGetComicDetailsUseCase;
    private final ComicDomainToPresentationMapper mComicDomainToPresentationMapper;
    private int mComicId;
    private ComicDetailsView mComicDetailsView;

    @Inject
    public ComicDetailsPresenter(GetComicDetailsUseCase useCase,
                                 ComicDomainToPresentationMapper mapper) {
        mGetComicDetailsUseCase = useCase;
        mComicDomainToPresentationMapper = mapper;
    }

    public void setView(@NonNull ComicDetailsView view) {
        mComicDetailsView = view;
    }

    //region [Presenter methods]

    @Override
    public void resume() {
        // Empty
    }

    @Override
    public void pause() {
        // Empty
    }

    //endregion

    public void initialize(int comicId) {
        mComicId = comicId;
        loadComicDetails();
    }

    private void loadComicDetails() {
        hideError();
        showLoading();
        getComicDetails();
    }

    private void showLoading() {
        mComicDetailsView.showLoading();
    }

    private void hideLoading() {
        mComicDetailsView.hideLoading();
    }

    private void showError(ErrorBundle errorBundle) {
        mComicDetailsView.showError(ErrorMessageFactory.create(mComicDetailsView.context(),
                errorBundle.getException()));
    }

    private void hideError() {
        mComicDetailsView.hideError();
    }

    private void getComicDetails() {
        Log.d(LOG_TAG,String.format("Get comic details..."));
        mGetComicDetailsUseCase.execute(mComicId, new GetComicDetailsUseCase.Callback() {
            @Override
            public void onComicDataLoaded(ComicDomain comicDomain) {
                Log.d(LOG_TAG,String.format("onComicDataLoaded"));
                hideLoading();
                showComicDetailsInView(comicDomain);
            }

            @Override
            public void onError(ErrorBundle errorBundle) {
                Log.d(LOG_TAG,String.format("onError"));
                hideLoading();
                showError(errorBundle);
            }
        });
    }

    private void showComicDetailsInView(ComicDomain comicDomain){
        mComicDetailsView.renderComic(mComicDomainToPresentationMapper.map(comicDomain));
    }


}
