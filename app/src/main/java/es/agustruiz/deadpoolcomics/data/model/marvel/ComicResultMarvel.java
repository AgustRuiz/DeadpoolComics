
package es.agustruiz.deadpoolcomics.data.model.marvel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ComicResultMarvel {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("digitalId")
    @Expose
    private Integer digitalId;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("issueNumber")
    @Expose
    private Integer issueNumber;
    @SerializedName("variantDescription")
    @Expose
    private String variantDescription;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("modified")
    @Expose
    private String modified;
    @SerializedName("isbn")
    @Expose
    private String isbn;
    @SerializedName("upc")
    @Expose
    private String upc;
    @SerializedName("diamondCode")
    @Expose
    private String diamondCode;
    @SerializedName("ean")
    @Expose
    private String ean;
    @SerializedName("issn")
    @Expose
    private String issn;
    @SerializedName("format")
    @Expose
    private String format;
    @SerializedName("pageCount")
    @Expose
    private Integer pageCount;
    @SerializedName("textObject")
    @Expose
    private List<TextObjectMarvel> textObjectMarvels = null;
    @SerializedName("resourceURI")
    @Expose
    private String resourceURI;
    @SerializedName("url")
    @Expose
    private List<UrlMarvel> urlMarvels = null;
    @SerializedName("series")
    @Expose
    private SeriesMarvel seriesMarvel;
    @SerializedName("variant")
    @Expose
    private List<VariantMarvel> variantMarvels = null;
    @SerializedName("collections")
    @Expose
    private List<Object> collections = null;
    @SerializedName("collectedIssues")
    @Expose
    private List<Object> collectedIssues = null;
    @SerializedName("dates")
    @Expose
    private List<DateMarvel> dateMarvels = null;
    @SerializedName("prices")
    @Expose
    private List<PriceMarvel> priceMarvels = null;
    @SerializedName("thumbnails")
    @Expose
    private ThumbnailMarvel thumbnailMarvel;
    @SerializedName("images")
    @Expose
    private List<ImageMarvel> imageMarvels = null;
    @SerializedName("creators")
    @Expose
    private CreatorsMarvel creatorsMarvel;
    @SerializedName("characters")
    @Expose
    private CharactersMarvel charactersMarvel;
    @SerializedName("stories")
    @Expose
    private StoriesMarvel storiesMarvel;
    @SerializedName("events")
    @Expose
    private EventsMarvel eventsMarvel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDigitalId() {
        return digitalId;
    }

    public void setDigitalId(Integer digitalId) {
        this.digitalId = digitalId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(Integer issueNumber) {
        this.issueNumber = issueNumber;
    }

    public String getVariantDescription() {
        return variantDescription;
    }

    public void setVariantDescription(String variantDescription) {
        this.variantDescription = variantDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getDiamondCode() {
        return diamondCode;
    }

    public void setDiamondCode(String diamondCode) {
        this.diamondCode = diamondCode;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public List<TextObjectMarvel> getTextObjectMarvels() {
        return textObjectMarvels;
    }

    public void setTextObjectMarvels(List<TextObjectMarvel> textObjectMarvels) {
        this.textObjectMarvels = textObjectMarvels;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public List<UrlMarvel> getUrlMarvels() {
        return urlMarvels;
    }

    public void setUrlMarvels(List<UrlMarvel> urlMarvels) {
        this.urlMarvels = urlMarvels;
    }

    public SeriesMarvel getSeriesMarvel() {
        return seriesMarvel;
    }

    public void setSeriesMarvel(SeriesMarvel seriesMarvel) {
        this.seriesMarvel = seriesMarvel;
    }

    public List<VariantMarvel> getVariantMarvels() {
        return variantMarvels;
    }

    public void setVariantMarvels(List<VariantMarvel> variantMarvels) {
        this.variantMarvels = variantMarvels;
    }

    public List<Object> getCollections() {
        return collections;
    }

    public void setCollections(List<Object> collections) {
        this.collections = collections;
    }

    public List<Object> getCollectedIssues() {
        return collectedIssues;
    }

    public void setCollectedIssues(List<Object> collectedIssues) {
        this.collectedIssues = collectedIssues;
    }

    public List<DateMarvel> getDateMarvels() {
        return dateMarvels;
    }

    public void setDateMarvels(List<DateMarvel> dateMarvels) {
        this.dateMarvels = dateMarvels;
    }

    public List<PriceMarvel> getPriceMarvels() {
        return priceMarvels;
    }

    public void setPriceMarvels(List<PriceMarvel> priceMarvels) {
        this.priceMarvels = priceMarvels;
    }

    public ThumbnailMarvel getThumbnailMarvel() {
        return thumbnailMarvel;
    }

    public void setThumbnailMarvel(ThumbnailMarvel thumbnailMarvel) {
        this.thumbnailMarvel = thumbnailMarvel;
    }

    public List<ImageMarvel> getImageMarvels() {
        return imageMarvels;
    }

    public void setImageMarvels(List<ImageMarvel> imageMarvels) {
        this.imageMarvels = imageMarvels;
    }

    public CreatorsMarvel getCreatorsMarvel() {
        return creatorsMarvel;
    }

    public void setCreatorsMarvel(CreatorsMarvel creatorsMarvel) {
        this.creatorsMarvel = creatorsMarvel;
    }

    public CharactersMarvel getCharactersMarvel() {
        return charactersMarvel;
    }

    public void setCharactersMarvel(CharactersMarvel charactersMarvel) {
        this.charactersMarvel = charactersMarvel;
    }

    public StoriesMarvel getStoriesMarvel() {
        return storiesMarvel;
    }

    public void setStoriesMarvel(StoriesMarvel storiesMarvel) {
        this.storiesMarvel = storiesMarvel;
    }

    public EventsMarvel getEventsMarvel() {
        return eventsMarvel;
    }

    public void setEventsMarvel(EventsMarvel eventsMarvel) {
        this.eventsMarvel = eventsMarvel;
    }

}
