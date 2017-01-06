package es.agustruiz.deadpoolcomics.presentation.presenter;

import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import java.util.Collection;

import javax.inject.Inject;

import butterknife.OnClick;
import es.agustruiz.deadpoolcomics.R;
import es.agustruiz.deadpoolcomics.Utils;
import es.agustruiz.deadpoolcomics.domain.exception.ErrorBundle;
import es.agustruiz.deadpoolcomics.domain.interactor.GetComicListUseCase;
import es.agustruiz.deadpoolcomics.domain.model.ComicDomain;
import es.agustruiz.deadpoolcomics.presentation.di.scope.PerActivityScope;
import es.agustruiz.deadpoolcomics.presentation.exception.ErrorMessageFactory;
import es.agustruiz.deadpoolcomics.presentation.mapper.ComicDomainToPresentationMapper;
import es.agustruiz.deadpoolcomics.presentation.model.ComicPresentation;
import es.agustruiz.deadpoolcomics.presentation.view.ComicListView;

@PerActivityScope
public class ComicListPresenter implements Presenter {

    private static final String LOG_TAG =
            Utils.buildLogTag(ComicListPresenter.class.getSimpleName());

    private final GetComicListUseCase mGetComicListUseCase;
    private final ComicDomainToPresentationMapper mComicDomainToPresentationMapper;
    private ComicListView mComicListView;
    private final GetComicListUseCase.Callback comicListCallback = new GetComicListUseCase.Callback() {
        @Override
        public void onComicListLoaded(Collection<ComicDomain> comicDomainCollection) {
            showComicsCollectionInView(comicDomainCollection);
            hideLoading();
        }

        @Override
        public void onError(ErrorBundle errorBundle) {
            hideLoading();
            showErrorMessage(errorBundle);
        }
    };

    @Inject
    public ComicListPresenter(GetComicListUseCase getComicListUseCase,
                              ComicDomainToPresentationMapper comicDomainToPresentationMapper) {
        mGetComicListUseCase = getComicListUseCase;
        mComicDomainToPresentationMapper = comicDomainToPresentationMapper;
    }

    @Override
    public void resume() {
        // Empty
    }

    @Override
    public void pause() {
        // Empty
    }

    public void setView(@NonNull ComicListView view) {
        mComicListView = view;
    }

    public void initialize() {
        loadComicList();
    }

    private void loadComicList() {
        hideErrorMessage();
        showLoading();
        getComicList();
    }

    public void onComicClicked(ComicPresentation comicPresentation) {
        //TODO
        Toast.makeText(mComicListView.context(),
                String.format("GO TO %s", comicPresentation.getTitle()),
                Toast.LENGTH_SHORT).show();
    }

    private void showLoading() {
        mComicListView.showLoading();
    }

    private void hideLoading() {
        mComicListView.hideLoading();
    }

    private void showErrorMessage(ErrorBundle errorBundle) {
        String errorMsg = ErrorMessageFactory.create(mComicListView.context(),
                errorBundle.getException());
        mComicListView.showError(errorMsg);
    }

    private void hideErrorMessage(){
        mComicListView.hideError();
    }

    private void showComicsCollectionInView(Collection<ComicDomain> comicDomainCollection) {
        final Collection<ComicPresentation> comicPresentationCollection =
                mComicDomainToPresentationMapper.map(comicDomainCollection);
        mComicListView.renderComicList(comicPresentationCollection);
    }

    private void getComicList() {
        Log.d(LOG_TAG, "Getting comic list...");
        mGetComicListUseCase.execute(comicListCallback);
    }

}
