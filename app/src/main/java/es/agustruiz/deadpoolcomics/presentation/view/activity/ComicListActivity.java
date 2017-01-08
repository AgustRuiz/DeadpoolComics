package es.agustruiz.deadpoolcomics.presentation.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.agustruiz.deadpoolcomics.R;
import es.agustruiz.deadpoolcomics.Utils;
import es.agustruiz.deadpoolcomics.presentation.di.HasComponent;
import es.agustruiz.deadpoolcomics.presentation.di.component.ComicComponent;
import es.agustruiz.deadpoolcomics.presentation.di.component.DaggerComicComponent;
import es.agustruiz.deadpoolcomics.presentation.model.ComicPresentation;
import es.agustruiz.deadpoolcomics.presentation.presenter.ComicListPresenter;
import es.agustruiz.deadpoolcomics.presentation.view.fragment.ComicListFragment;

public class ComicListActivity extends BaseActivity implements HasComponent<ComicComponent>,
        ComicListFragment.ComicListListener {

    private static final String LOG_TAG = ComicListActivity.class.getSimpleName()+ Utils.AGUST_TAG;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    ComicComponent mComicComponent;

    //region [BaseActivity methods]

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic_list);
        ButterKnife.bind(this);
        initializeInjector();
        initializeViews();
    }

    //endregion

    //region [HasComponent methods]

    @Override
    public ComicComponent getComponent() {
        return mComicComponent;
    }

    //endregion

    //region [Public static methods]

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, ComicListActivity.class);
    }

    //endregion

    //region [Private methods]

    private void initializeInjector() {
        mComicComponent = DaggerComicComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    private void initializeViews() {
        if(mToolbar!=null){
            setSupportActionBar(mToolbar);
        }
    }

    //endregion

    //region [ComicListFragment.ComicListListener]

    @Override
    public void onComicClick(ComicPresentation comicPresentation) {
        navigator.goToComicDetails(this, comicPresentation.getId());
    }

    //endregion

}
