package musicapp.domain;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
import jakarta.validation.constraints.Size;

@Entity
public class Artist {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "artist_id")
	private Long artistId;
	
	@NotEmpty(message="Artistilla pitää olla etunimi!")
	private String etunimi;
	
	@NotEmpty(message="Artistilla pitää olla sukunimi!")
	private String sukunimi;
	
	@Min(value=10, message="Ikä pitää olla vähintään 10 vuotta.")
    @Max(value=99, message="Ikä voi olla enintään 99 vuotta..")
	private int ika;
	
	@NotEmpty(message="Artistilla pitää olla kotimaa!")
	private String kotimaa;


	@OneToMany(cascade=CascadeType.ALL, mappedBy="artist")
	private List<Album> albums;
	
	
	public Artist() {}
	
	public Artist( String etunimi, String sukunimi, int ika, String kotimaa) {
		super();
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.ika = ika;
		this.kotimaa = kotimaa;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

	public Long getId() {
		return artistId;
	}

	public void setId(Long id) {
		this.artistId = id;
	}

	public String getEtunimi() {
		return etunimi;
	}

	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}

	public String getSukunimi() {
		return sukunimi;
	}

	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}

	public int getIka() {
		return ika;
	}

	public void setIka(int ika) {
		this.ika = ika;
	}

	public String getKotimaa() {
		return kotimaa;
	}

	public void setKotimaa(String kotimaa) {
		this.kotimaa = kotimaa;
	}

	@Override
	public String toString() {
		return "Artist [id=" + artistId + ", etunimi=" + etunimi + ", sukunimi=" + sukunimi + ", ika=" + ika + ", kotimaa="
				+ kotimaa + "]";
	}
	

}
