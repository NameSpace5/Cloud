package ai.inlight.model.bean;

import java.util.List;


public class AlbumResult {
    private List<Album> albums;
    private int albumCount;

    public List<Album> getAlbums() {
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
