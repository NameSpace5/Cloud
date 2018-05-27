package ai.inlight.model.bean;

import java.util.List;


public class SongsResult {
    private List<Song> songs;
    private int songCount;

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public int getSongCount() {
        return songCount;
    }

    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }
}
