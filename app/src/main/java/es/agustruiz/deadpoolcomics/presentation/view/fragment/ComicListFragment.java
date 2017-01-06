package es.agustruiz.deadpoolcomics.presentation.view.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import es.agustruiz.deadpoolcomics.R;
import es.agustruiz.deadpoolcomics.Utils;
import es.agustruiz.deadpoolcomics.presentation.di.component.ComicComponent;
import es.agustruiz.deadpoolcomics.presentation.model.ComicPresentation;
import es.agustruiz.deadpoolcomics.presentation.presenter.ComicListPresenter;
import es.agustruiz.deadpoolcomics.presentation.view.ComicListView;
import es.agustruiz.deadpoolcomics.presentation.view.adapter.ComicAdapter;
import es.agustruiz.deadpoolcomics.presentation.view.adapter.ComicLayoutManager;

public class ComicListFragment extends BaseFragment implements ComicListView {

    private static final String LOG_TAG = Utils.buildLogTag(ComicListFragment.class.getSimpleName());

    public interface ComicListListener {
        void onComicClick(final ComicPresentation comicPresentation);
    }

    @Inject
    ComicListPresenter mComicListPresenter;

    @BindView(R.id.rv_comic_list)
    RecyclerView mRvComicList;
    ComicAdapter mComicAdapter;
    ComicLayoutManager mComicLayoutManager;

    @BindView(R.id.rl_progress_bar)
    RelativeLayout mRlProgressBar;

    @BindView(R.id.rl_error_and_retry)
    RelativeLayout mRlErrorAndRetry;

    @BindView(R.id.tv_error)
    TextView mTvError;

    private ComicListListener mComicListListener;

    //region [Fragment methods]

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comic_list, container, false);
        ButterKnife.bind(this, view);
        initializeViews();
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mComicListListener =
                (activity instanceof ComicListListener?(ComicListListener) activity:null);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initialize();
        loadComicList();
    }

    //endregion

    //region [LoadDataView methods]

    @Override
    public void showLoading() {
        mRlProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mRlProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError(String message) {
        mTvError.setText(message);
        mRlErrorAndRetry.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideError(){
        mRlErrorAndRetry.setVisibility(View.GONE);
    }

    @Override
    public Context context() {
        return getContext();
    }


    //endregion

    //region [ComicListView methods]

    @Override
    public void renderComicList(Collection<ComicPresentation> comicPresentationCollection) {
        if (comicPresentationCollection != null) {
            mComicAdapter.setComicCollection(comicPresentationCollection);
        }
    }

    @Override
    public void viewComic(ComicPresentation comicPresentation) {
        if (mComicListListener != null) {
            mComicListListener.onComicClick(comicPresentation);
        }
    }

    //endregion

    //region [Private methods]

    private void initializeViews() {
        mComicLayoutManager = new ComicLayoutManager(getActivity());
        mRvComicList.setLayoutManager(mComicLayoutManager);
        mComicAdapter = new ComicAdapter(getContext(), new ArrayList<ComicPresentation>());
        mRvComicList.setAdapter(mComicAdapter);
        hideLoading();
        hideError();
    }

    private void loadComicList(){
        Log.d(LOG_TAG, "Load comic list");
        mComicListPresenter.initialize();
    }

    private void initialize(){
        getComponent(ComicComponent.class).inject(this);
        mComicListPresenter.setView(this);
    }

    //endregion

    @OnClick(R.id.btn_retry)
    protected void OnClickRetry(){
        Log.d(LOG_TAG, "Retry load comic list");
        loadComicList();
    }

}
