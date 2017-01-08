package es.agustruiz.deadpoolcomics.presentation.view;

import es.agustruiz.deadpoolcomics.presentation.model.ComicPresentation;

public interface ComicDetailsView extends LoadDataView {

    void renderComic(ComicPresentation comicPresentation);

}
