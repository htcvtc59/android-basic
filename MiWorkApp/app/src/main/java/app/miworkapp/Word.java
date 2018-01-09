package app.miworkapp;

/**
 * Created by MacOS on 10/11/2017.
 */

public class Word {
    private String mDefaultTranslation;
    private String mMiworkTranslation;

    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }

    public void setmDefaultTranslation(String mDefaultTranslation) {
        this.mDefaultTranslation = mDefaultTranslation;
    }

    public String getmMiworkTranslation() {
        return mMiworkTranslation;
    }

    public void setmMiworkTranslation(String mMiworkTranslation) {
        this.mMiworkTranslation = mMiworkTranslation;
    }

    public Word(String mDefaultTranslation, String mMiworkTranslation) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiworkTranslation = mMiworkTranslation;
    }




}
