package es.agustruiz.deadpoolcomics.presentation.navigator;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import javax.inject.Inject;
import javax.inject.Singleton;

import es.agustruiz.deadpoolcomics.Utils;
import es.agustruiz.deadpoolcomics.presentation.model.ComicPresentation;
import es.agustruiz.deadpoolcomics.presentation.view.activity.BaseActivity;
import es.agustruiz.deadpoolcomics.presentation.view.activity.ComicDetailsActivity;
import es.agustruiz.deadpoolcomics.presentation.view.activity.ComicListActivity;

@Singleton
public class Navigator {

//    private static final String LOG_TAG = Navigator.class.getSimpleName()+ Utils.AGUST_TAG;

    @Inject
    public void Navigator(){
        // Empty
    }

    public void goToComicList(Context context){
        if(context!=null){
            context.startActivity(new Intent(context, ComicListActivity.class));
        }
    }

    public void goToComicDetails(Context context, int comicId){
        if (context != null) {
            context.startActivity(ComicDetailsActivity.getCallingIntent(context, comicId));
        }
    }

}
