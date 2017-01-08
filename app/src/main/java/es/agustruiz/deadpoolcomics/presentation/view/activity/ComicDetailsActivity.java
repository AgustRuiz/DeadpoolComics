package es.agustruiz.deadpoolcomics.presentation.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import butterknife.ButterKnife;
import es.agustruiz.deadpoolcomics.R;
import es.agustruiz.deadpoolcomics.Utils;
import es.agustruiz.deadpoolcomics.presentation.di.HasComponent;
import es.agustruiz.deadpoolcomics.presentation.di.component.ComicComponent;
import es.agustruiz.deadpoolcomics.presentation.di.component.DaggerComicComponent;
import es.agustruiz.deadpoolcomics.presentation.view.fragment.ComicDetailsFragment;

public class ComicDetailsActivity extends BaseActivity implements HasComponent<ComicComponent> {

    static final String LOG_TAG = Utils.buildLogTag(ComicDetailsActivity.class.getSimpleName());

    static final String INTENT_EXTRA_PARAM_COMIC_ID = "INTENT_EXTRA_PARAM_COMIC_ID";
    static final String INSTANCE_STATE_PARAM_COMIC_ID = "INSTANCE_STATE_PARAM_COMIC_ID";
    int mComicId;

    ComicComponent mComicComponent;

    //region [Activity methods]

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic_details);
        ButterKnife.bind(this);
        initializeInjector();
        initializeActivity(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if(outState!=null){
            outState.putInt(INSTANCE_STATE_PARAM_COMIC_ID, mComicId);
        }
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    //endregion

    //region [HasComponent methods]

    @Override
    public ComicComponent getComponent() {
        return mComicComponent;
    }

    //endregion

    //region [Public methods]

    public static Intent getCallingIntent(Context context, int comicId) {
        Intent intent = new Intent(context, ComicDetailsActivity.class);
        intent.putExtra(INTENT_EXTRA_PARAM_COMIC_ID, comicId);
        return intent;
    }

    //endregion

    //region [Private methods]

    private void initializeInjector() {
        mComicComponent = DaggerComicComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    private void initializeActivity(Bundle savedInstanceState){
        if (savedInstanceState == null) {
            mComicId = getIntent().getIntExtra(INTENT_EXTRA_PARAM_COMIC_ID, -1);
            addFragment(R.id.frameComicDetails, ComicDetailsFragment.newInstance(mComicId));
        } else {
            mComicId = savedInstanceState.getInt(INTENT_EXTRA_PARAM_COMIC_ID);
        }
    }

    //endregion

}
