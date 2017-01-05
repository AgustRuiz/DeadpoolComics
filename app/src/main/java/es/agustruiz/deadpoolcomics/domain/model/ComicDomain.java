package es.agustruiz.deadpoolcomics.domain.model;

public class ComicDomain {

    String mTitle;
    String mImageUrl;

    public ComicDomain() {
    }

    public ComicDomain(String title, String imageUrl) {
        mTitle = title;
        mImageUrl = imageUrl;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.mImageUrl = imageUrl;
    }

}
