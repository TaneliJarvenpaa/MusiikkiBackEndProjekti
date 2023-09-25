package musicapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import musicapp.domain.Album;
import musicapp.domain.AlbumRepository;
import musicapp.domain.Artist;
import musicapp.domain.ArtistRepository;
import musicapp.domain.Genre;
import musicapp.domain.GenreRepository;

@SpringBootApplication
public class MusicAppApplication {
	
	private static final Logger log = LoggerFactory.getLogger(MusicAppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MusicAppApplication.class, args);
		
	}
	@Bean
	public CommandLineRunner tietokanta(AlbumRepository albumrep, ArtistRepository artrep, GenreRepository genrerep) {
		return (args)->{
			Artist artist1=new Artist("Ville","Valo",50,"Suomi");
			Artist artist2=new Artist("Michael","Monroe",62,"Suomi");
			Artist artist3=new Artist("Anna","Puu",42,"Suomi");
			Artist artist4=new Artist("Bruce","Springsteen",78,"USA");
			
			artrep.save(artist1);
			artrep.save(artist2);
			artrep.save(artist3);
			artrep.save(artist4);
			
			
			
			
			
			Genre genre1=new Genre("Rock");
			Genre genre2=new Genre("Metal");
			Genre genre3=new Genre("Metalcore");
			Genre genre4=new Genre("Hardrock");
			
			genrerep.save(genre1);
			genrerep.save(genre2);
			genrerep.save(genre3);
			genrerep.save(genre4);
			
			Album album1=new Album("Hail to the king",2013,artist1,genre1);
			Album album2=new Album("Astronaut in the ocean",2021,artist2,genre2);
			Album album3=new Album("Trauma",2019,artist3,genre3);
			Album album4=new Album("Watch The World Burn",2023,artist3,genre4);
			
			albumrep.save(album1);
			albumrep.save(album2);
			albumrep.save(album3);
			albumrep.save(album4);
			
			log.info("Tallennettiin albumeita, genrejä ja artisteja");
			
		};
	}
}
