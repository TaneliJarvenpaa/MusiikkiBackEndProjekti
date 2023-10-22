package musicapp.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ArtistRepository extends CrudRepository<Artist,Long>{
	
	List <Artist> findByEtunimi(String etunimi);
	List <Artist> findBySukunimi(String sukunimi);
	

}
