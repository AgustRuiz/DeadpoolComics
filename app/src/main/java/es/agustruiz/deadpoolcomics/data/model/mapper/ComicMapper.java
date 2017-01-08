package es.agustruiz.deadpoolcomics.data.model.mapper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import es.agustruiz.deadpoolcomics.Utils;
import es.agustruiz.deadpoolcomics.data.model.marvel.ComicMarvel;
import es.agustruiz.deadpoolcomics.data.model.marvel.ComicResultMarvel;
import es.agustruiz.deadpoolcomics.data.model.marvel.ItemMarvel;
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

            comicDomain.setId(item.getId());

            comicDomain.setTitle(item.getTitle());

            if (item.getThumbnailMarvel() != null) {
                comicDomain.setImageUrl(String.format("%s.%s", item.getThumbnailMarvel().getPath(),
                        item.getThumbnailMarvel().getExtension()));
            } else {
                comicDomain.setImageUrl(null);
            }

            try {
                String dateString = item.getDateMarvels().get(0).getDate();
                String formatPattern = "yyyy-MM-dd'T'HH:mm:ssZ";
                DateFormat format = new SimpleDateFormat(formatPattern);
                Date date = format.parse(dateString);
                comicDomain.setPublished(date);
            } catch (Exception e) {
                comicDomain.setPublished(null);
            }

            List<String> creators = new ArrayList<>();
            for (ItemMarvel itemMarvel : item.getCreatorsMarvel().getItemMarvels()) {
                creators.add(itemMarvel.getName());
            }
            comicDomain.setCreators(Utils.stringJoiner(", ", creators));


            comicDomain.setDescription(item.getDescription());


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
