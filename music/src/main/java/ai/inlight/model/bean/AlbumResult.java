package ai.inlight.model.bean;

import java.util.List;

import model.bean.Album;

public class AlbumResult {
    private List<model.bean.Album> albums;
    private int albumCount;

    public List<model.bean.Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public int getAlbumCount() {
        return albumCount;
    }

    public void setAlbumCount(int albumCount) {
        this.albumCount = albumCount;
    }
}
