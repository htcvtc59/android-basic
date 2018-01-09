package app.miworkapp;

/**
 * Created by MacOS on 11/11/2017.
 */

public class WordAudio {
    private String mDefaultTranslation;
    private String mMiworkTranslation;
    private int audioResourceId;

    public WordAudio() {
    }

    public int getAudioResourceId() {
        return audioResourceId;
    }

    public void setAudioResourceId(int audioResourceId) {
        this.audioResourceId = audioResourceId;
    }

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

    public WordAudio(String mDefaultTranslation, String mMiworkTranslation, int audioResourceId) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiworkTranslation = mMiworkTranslation;
        this.audioResourceId = audioResourceId;
    }
}
