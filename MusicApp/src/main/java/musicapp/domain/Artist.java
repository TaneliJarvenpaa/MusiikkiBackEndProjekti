package musicapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Artist {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String etunimi;
	private String sukunimi;
	private int ika;
	private String kotimaa;
	
	public Artist() {}
	
	public Artist( String etunimi, String sukunimi, int ika, String kotimaa) {
		super();
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.ika = ika;
		this.kotimaa = kotimaa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return "Artist [id=" + id + ", etunimi=" + etunimi + ", sukunimi=" + sukunimi + ", ika=" + ika + ", kotimaa="
				+ kotimaa + "]";
	}
	

}
