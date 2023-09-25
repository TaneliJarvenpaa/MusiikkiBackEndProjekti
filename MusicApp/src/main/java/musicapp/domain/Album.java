package musicapp.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Album {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long albumId;
	
	@NotEmpty(message="anna albumin nimi!")
	private String nimi;
	
	@Min(value=1800, message="vuosi pitää olla välillä 1800-2023")
    @Max(value=2023, message="vuosi pitää olla välillä 1800-2023")
	private int vuosi;
	
	
	@ManyToOne
    @JsonIgnoreProperties ("albums")
    @JoinColumn(name="genreId")
    private Genre genre;
	
	@ManyToOne
    @JsonIgnoreProperties ("albums")
    @JoinColumn(name="artistId")
    private Artist artist;
	
	public Album() {}
	
	public Album( String nimi, int vuosi, Artist artist, Genre genre) {
		super();
		this.nimi = nimi;
		this.vuosi = vuosi;
		this.genre = genre;
		this.artist=artist;
	}

	public Long getId() {
		return albumId;
	}

	public void setId(Long id) {
		this.albumId = id;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public int getVuosi() {
		return vuosi;
	}

	public void setVuosi(int vuosi) {
		this.vuosi = vuosi;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Album [id=" + albumId + ", nimi=" + nimi + ", vuosi=" + vuosi + ", artisti=" + artist + ", genre=" + genre
				+ "]";
	}
}
