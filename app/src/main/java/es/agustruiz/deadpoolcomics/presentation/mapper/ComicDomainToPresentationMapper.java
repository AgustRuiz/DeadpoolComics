package es.agustruiz.deadpoolcomics.presentation.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.inject.Inject;

import es.agustruiz.deadpoolcomics.domain.model.ComicDomain;
import es.agustruiz.deadpoolcomics.presentation.di.scope.PerActivityScope;
import es.agustruiz.deadpoolcomics.presentation.model.ComicPresentation;

@PerActivityScope
public class ComicDomainToPresentationMapper {

    @Inject
    public ComicDomainToPresentationMapper() {
        // Empty
    }

    public ComicPresentation map(ComicDomain comicDomain) {
        ComicPresentation comicPresentation = new ComicPresentation();
        comicPresentation.setTitle(comicDomain.getTitle());
        comicPresentation.setImageUrl(comicDomain.getImageUrl());
        return comicPresentation;
    }

    public Collection<ComicPresentation> map(Collection<ComicDomain> collection) {
        Collection<ComicPresentation> outCollection;
        if (collection != null && !collection.isEmpty()) {
            outCollection = new ArrayList<>();
            for (ComicDomain item : collection) {
                outCollection.add(map(item));
            }
        } else {
            outCollection = Collections.emptyList();
        }
        return outCollection;
    }
}
