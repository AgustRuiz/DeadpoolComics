package es.agustruiz.deadpoolcomics.presentation.view;

import android.content.Context;

public interface LoadDataView {

    void showLoading();

    void hideLoading();

    void showError(String message);

    void hideError();

    Context context();

}
