package es.agustruiz.deadpoolcomics.presentation.model.mapper;

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
        comicPresentation.setId(comicDomain.getId());
        comicPresentation.setTitle(comicDomain.getTitle());
        comicPresentation.setImageUrl(comicDomain.getImageUrl());
        comicPresentation.setPublished(comicDomain.getPublished());
        comicPresentation.setCreators(comicDomain.getCreators());
        comicPresentation.setDescription(comicDomain.getDescription());
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
