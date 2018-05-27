package ai.inlight.model.bean;

import java.util.List;

import model.bean.Song;

public class SongsResult {
    private List<model.bean.Song> songs;
    private int songCount;

    public List<model.bean.Song> getSongs() {
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
