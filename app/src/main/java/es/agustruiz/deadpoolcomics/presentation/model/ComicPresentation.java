package es.agustruiz.deadpoolcomics.presentation.model;

public class ComicPresentation {

    String mTitle;
    String mImageUrl;

    public ComicPresentation() {
    }

    public ComicPresentation(String title, String imageUrl) {
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
