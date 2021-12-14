package model;

public class Track {
	
	private long trackId;
	private String name;
	private long albumId;
	private long mediatypeId;
	private long genreId;
	private String composer;
	private long milliseconds;
	private long bytes;
	private long unitprice;
	
	public Track(long trackId, String name, long albumId, long mediatypeId, long genreId, String composer,
			long milliseconds, long bytes, long unitprice) {
		this.trackId = trackId;
		this.name = name;
		this.albumId = albumId;
		this.mediatypeId = mediatypeId;
		this.genreId = genreId;
		this.composer = composer;
		this.milliseconds = milliseconds;
		this.bytes = bytes;
		this.unitprice = unitprice;
	}
	public long getTrackId() {
		return trackId;
	}
	public void setTrackId(long trackId) {
		this.trackId = trackId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getAlbumId() {
		return albumId;
	}
	public void setAlbumId(long albumId) {
		this.albumId = albumId;
	}
}
