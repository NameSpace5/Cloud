package ai.inlight.model.bean;

import java.util.List;

public class PlaylistResult {
    private List<PlayList> playlist;
    private int playListCount;

    public List<PlayList> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(List<PlayList> playlist) {
        this.playlist = playlist;
    }

    public int getPlayListCount() {
        return playListCount;
    }

    public void setPlayListCount(int playListCount) {
        this.playListCount = playListCount;
    }
}
