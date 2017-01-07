package es.agustruiz.deadpoolcomics.data.model.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import es.agustruiz.deadpoolcomics.data.model.marvel.ComicMarvel;
import es.agustruiz.deadpoolcomics.data.model.marvel.ComicResultMarvel;
import es.agustruiz.deadpoolcomics.domain.model.ComicDomain;

@Singleton
public class ComicMapper {

    @Inject
    public ComicMapper() {
        // Empty
    }

    public List<ComicDomain> mapComicMarvelToComic(Collection<ComicResultMarvel> comicMarvel) {
        List<ComicDomain> output = new ArrayList<>();
        for (ComicResultMarvel item : comicMarvel) {
            ComicDomain comicDomain = new ComicDomain();
            comicDomain.setTitle(item.getTitle());
            if (item.getThumbnailMarvel() != null) {
                comicDomain.setImageUrl(String.format("%s.%s", item.getThumbnailMarvel().getPath(),
                        item.getThumbnailMarvel().getExtension()));
            } else {
                comicDomain.setImageUrl(null);
            }
            output.add(comicDomain);
        }
        return output;
    }

    public List<ComicResultMarvel> mapComicMarvelToCollection(ComicMarvel comicMarvel) {
        List<ComicResultMarvel> output = new ArrayList<>();
        output.addAll(comicMarvel.getDataMarvel().getComicResultMarvels());
        return output;
    }

}
