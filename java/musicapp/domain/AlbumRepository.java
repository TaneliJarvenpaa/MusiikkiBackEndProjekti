package musicapp.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<Album,Long>{



	List<Album> findByNimi(String string);
	
}
