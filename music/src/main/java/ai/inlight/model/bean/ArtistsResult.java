package ai.inlight.model.bean;

import java.util.List;

import model.bean.Artist;

public class ArtistsResult {
    private List<model.bean.Artist> artists;
    private int artistCount;

    public List<model.bean.Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public int getArtistCount() {
        return artistCount;
    }

    public void setArtistCount(int artistCount) {
        this.artistCount = artistCount;
    }
}
