package ai.inlight.model.bean;

import java.util.List;

public class ArtistsResult {
    private List<Artist> artists;
    private int artistCount;

    public List<Artist> getArtists() {
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
