package es.agustruiz.deadpoolcomics.presentation.view;

import java.util.Collection;

import es.agustruiz.deadpoolcomics.presentation.model.ComicPresentation;

public interface ComicListView extends LoadDataView {

    void renderComicList(Collection<ComicPresentation> comicPresentationCollection);

    void viewComic(ComicPresentation comicPresentation);

}
