package MusicApp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import musicapp.MusicAppApplication;
import musicapp.domain.Album;
import musicapp.domain.AlbumRepository;
import musicapp.domain.Artist;
import musicapp.domain.ArtistRepository;
import musicapp.domain.Genre;
import musicapp.domain.GenreRepository;


@DataJpaTest



class MusicRepositoryTests {
	@Autowired
	AlbumRepository albumrep;
	@Autowired 
	ArtistRepository artistrep;
	@Autowired
	GenreRepository genrerep;
	@Test 
	public void findAlbumByName() {
		List<Album> album=albumrep.findByNimi("Watch The World Burn");
		assertThat(album).hasSize(1);
		assertThat(album.get(0).getNimi()).isEqualTo("Watch The World Burn");
	}
	@Test
	public void findAllArtists() {
		Iterable<Artist> artists=(List<Artist>) artistrep.findAll();
		assertThat(artists).hasSize(4);
		assertThat(artists).isNotEmpty();
	}
	@Test
	public void addNewAlbumWithArtistAndGenre() {
		Artist artist=new Artist("testi","keissi",22,"testimaa");
		artistrep.save(artist);
		Genre genre=new Genre("testigenre");
		genrerep.save(genre);
		Album album=new Album("albumin nimi",2022,artist,genre);
		albumrep.save(album);
		assertThat(album.getArtist()).isEqualTo(artist);
		assertThat(album.getGenre()).isEqualTo(genre);
		assertThat(album.getNimi()).isEqualTo("albumin nimi");
		assertThat(album.getVuosi()).isEqualByComparingTo(2022);
		assertThat(album.getArtist().getEtunimi()).isEqualTo("testi");
		assertThat(album.getGenre().getNimi()).isEqualTo("testigenre");
	}
	@Test
	public void deleteAlbumByName() {
		Artist artist=new Artist("testi","keissi",22,"testimaa");
		Genre genre=new Genre("testigenre");
		Album album=new Album("albumin nimi",2022,artist,genre);
		albumrep.save(album);
		albumrep.delete(album);
		assertThat(albumrep.findById(album.getId())).isEmpty();
	}

}
