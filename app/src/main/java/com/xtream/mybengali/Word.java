package com.xtream.mybengali;

/**
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains a default(English)and a Bengali translation.
 */

public class Word {

    //Default Translation
    private String mDefaultTranslation;

    //Bengali Translation
    private String mBengaliTranslation;

    //Audio Resource ID for Word;
    private int mAudioResourceID;

    //Image Resource Id for Word
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    public static final int NO_IMAGE_PROVIDED = -1;

    //The Word Class Constructor
    public Word(String defaultTranslation, String bengaliTranslation, int audioResourceID) {
        mDefaultTranslation = defaultTranslation;
        mBengaliTranslation = bengaliTranslation;
        mAudioResourceID = audioResourceID;
    }

    //The Word Class Constructor which has an image
    public Word(String defaultTranslation, String bengaliTranslation, int imageResourceId, int audioResourceID) {
        mDefaultTranslation = defaultTranslation;
        mBengaliTranslation = bengaliTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceID = audioResourceID;
    }

    //get the default translation
    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    //get the Bengali translation
    public String getBengaliTranslation(){
        return mBengaliTranslation;
    }

    //return the resource ID of the image.
    public int getImageResourceId(){
        return mImageResourceId;
    }

    //returns whether or not there is an image in this word view
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public int getAudioResourceId(){
        return mAudioResourceID;
    }
}
