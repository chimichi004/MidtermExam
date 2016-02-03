package sidespell.tech.midtermexam.utils;

import android.graphics.Bitmap;

/**
 * Created by pak on 2/2/2016.
 */
public class Music {

    private String artist;
    private String album;
    private String musicId;
    private String mDescription;
    private String musicImage;


    private Bitmap musicIcon;


    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getMusicId() {
        return musicId;
    }

    public void setMusicId(String musicId) {
        this.musicId = musicId;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public Bitmap getMusicIcon() {
        return musicIcon;
    }

    public void setMusicIcon(Bitmap musicIcon) {
        this.musicIcon = musicIcon;
    }

    public String getMusicImage() {
        return musicImage;
    }

    public void setMusicImage(String musicImage) {
        this.musicImage = MusicApi.IMG_BASE_URL + musicImage + ".png";
    }
}
