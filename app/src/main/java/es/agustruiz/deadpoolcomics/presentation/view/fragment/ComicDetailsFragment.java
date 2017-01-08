package es.agustruiz.deadpoolcomics.presentation.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import es.agustruiz.deadpoolcomics.R;
import es.agustruiz.deadpoolcomics.Utils;
import es.agustruiz.deadpoolcomics.presentation.di.component.ComicComponent;
import es.agustruiz.deadpoolcomics.presentation.model.ComicPresentation;
import es.agustruiz.deadpoolcomics.presentation.presenter.ComicDetailsPresenter;
import es.agustruiz.deadpoolcomics.presentation.view.ComicDetailsView;
import es.agustruiz.deadpoolcomics.presentation.view.activity.BaseActivity;
import uk.co.senab.photoview.PhotoViewAttacher;

public class ComicDetailsFragment extends BaseFragment implements ComicDetailsView {

    private static final String LOG_TAG = Utils.buildLogTag(ComicDetailsFragment.class.getSimpleName());

    private static final String ARGUMENT_COMIC_ID_KEY = "ARGUMENT_COMIC_ID_KEY";

    @BindView((R.id.toolbar))
    Toolbar mToolbar;

    @BindView((R.id.toolbar_layout))
    CollapsingToolbarLayout mAppBarLayout;

    @BindView(R.id.rl_progress_bar)
    RelativeLayout mRlProgressBar;

    @BindView(R.id.rl_error_and_retry)
    RelativeLayout mRlErrorAndRetry;

    @BindView(R.id.tv_error)
    TextView mTvError;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    @BindView(R.id.tv_published)
    TextView mTvPublished;

    @BindView(R.id.tv_creators)
    TextView mTvCreators;

    @BindView(R.id.tv_description)
    TextView mTvDescription;

    @BindView(R.id.iv_comic_cover)
    ImageView mIvComicCover;
    PhotoViewAttacher mPhotoViewAttacher;

    @Inject
    ComicDetailsPresenter mPresenter;

    private int mComicId;

    //region [Fragment methods]

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comic_details, container, false);
        ButterKnife.bind(this, view);
        initializeViews();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initialize();
        initializePresenter();
    }

    //endregion

    //region [ComicListView methods]

    @Override
    public void renderComic(ComicPresentation comicPresentation) {
        mAppBarLayout.setTitle(comicPresentation.getTitle());
        mTvTitle.setText(comicPresentation.getTitle());
        mTvPublished.setText(comicPresentation
                .getPublished(getString(R.string.date_pattern)).toString());
        mTvCreators.setText(comicPresentation.getCreators());
        mTvDescription.setText(comicPresentation.getDescription());

        Picasso.with(context()).load(comicPresentation.getImageUrl()).into(mIvComicCover);
        mPhotoViewAttacher = new PhotoViewAttacher(mIvComicCover);
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
    public void hideError() {
        mRlErrorAndRetry.setVisibility(View.GONE);
    }

    @Override
    public Context context() {
        return getContext();
    }

    //endregion

    //region [Public methods]

    public static ComicDetailsFragment newInstance(int comicId){
        ComicDetailsFragment fragment = new ComicDetailsFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(ARGUMENT_COMIC_ID_KEY, comicId);
        fragment.setArguments(arguments);
        return fragment;
    }

    //endregion

    //region [Private methods]

    private void initializeViews(){
        BaseActivity baseActivity = (BaseActivity)getActivity();
        baseActivity.setSupportActionBar(mToolbar);
        baseActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mAppBarLayout.setTitle(" "); // Blank space
        hideLoading();
        hideError();
    }

    private void initialize(){
        Bundle arguments = getArguments();



        getComponent(ComicComponent.class).inject(this);
        mComicId = getArguments().getInt(ARGUMENT_COMIC_ID_KEY);
        mPresenter.setView(this);
    }

    private void initializePresenter(){
        mPresenter.initialize(mComicId);
    }

    //endregion

    //region [ButterKnife injections]

    @OnClick(R.id.btn_retry)
    protected void OnClickRetry(){
        initializePresenter();
        hideError();
    }

    @OnClick(R.id.btn_cancel)
    protected void OnClickCancel(){
        hideError();
    }

    //endregion
}
