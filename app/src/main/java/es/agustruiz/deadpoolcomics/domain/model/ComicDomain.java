package es.agustruiz.deadpoolcomics.domain.model;

import java.util.Date;

public class ComicDomain {

    int mId;
    String mTitle;
    String mImageUrl;
    Date mPublished;

    String mCreators;
    String mDescription;

    public ComicDomain() {
    }

    public ComicDomain(int id, String title, String imageUrl) {
        mId = id;
        mTitle = title;
        mImageUrl = imageUrl;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
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

    public Date getPublished(){
        return mPublished;
    }

    public void setPublished(Date published){
        mPublished = published;
    }


    public String getCreators() {
        return mCreators;
    }

    public void setCreators(String creators) {
        mCreators = creators;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }
}
