package com.example.android.miwok;

/**
 * Created by amartiushov on 25/03/17.
 */
public class Word {

    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private Integer imageResourceId = NO_IMAGE_PROVIDED;
    private Integer audioResourceId;
    private static final int NO_IMAGE_PROVIDED = -1;

    public Word(String mDefaultTranslation, String mMiwokTranslation) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
    }

    public Word(String mDefaultTranslation, String mMiwokTranslation, Integer imageResourceId) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.imageResourceId = imageResourceId;
    }

    public Word(String mDefaultTranslation, String mMiwokTranslation, Integer imageResourceId, Integer audioResourceId) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.imageResourceId = imageResourceId;
        this.audioResourceId = audioResourceId;
    }

    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getmMiwokTranslation() {
        return mMiwokTranslation;
    }

    public Integer getImageResourceId() {
        return imageResourceId;
    }

    public boolean hasImage(){
        return imageResourceId != NO_IMAGE_PROVIDED;
    }

    public Integer getAudioResourceId() {
        return audioResourceId;
    }
}
