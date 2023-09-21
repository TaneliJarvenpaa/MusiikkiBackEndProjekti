package musicapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Genre {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nimi;
	
	public Genre() {}
	
	public Genre(String nimi) {
		super();
		this.nimi = nimi;
	}
	public String getNimi() {
		return nimi;
	}
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	@Override
	public String toString() {
		return "Genre [nimi=" + nimi + "]";
	}
	
	

}
