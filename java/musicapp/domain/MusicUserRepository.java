package musicapp.domain;
import org.springframework.data.repository.CrudRepository;

public interface MusicUserRepository extends CrudRepository <MusicUser,Long>{
	
	MusicUser findByUsername(String username);
	
}
