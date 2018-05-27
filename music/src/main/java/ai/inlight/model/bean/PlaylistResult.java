package ai.inlight.model.bean;

import java.util.List;

import model.bean.PlayList;

public class PlaylistResult {
    private List<model.bean.PlayList> playlist;
    private int playListCount;

    public List<model.bean.PlayList> getPlaylist() {
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
