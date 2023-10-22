package musicapp.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import musicapp.domain.Album;
import musicapp.domain.AlbumRepository;

@RestController
public class RestAlbumController {
	
	@Autowired
	AlbumRepository ar;
	
	@GetMapping("/albums")
	public Iterable<Album>  getAlbums(){
		return ar.findAll();
	}
	
	@GetMapping("/album/{albumId}")
	public Optional<Album> getOneAlbum(@PathVariable("albumId")Long id){
		return ar.findById(id);
	}
	
	@DeleteMapping("/album/{albumId}")
	public List<Album> deleteById(@PathVariable("albumId")Long id){
		 ar.deleteById(id);
		 return (List<Album>) ar.findAll();
	}
	@PostMapping("/album")
	Album newAlbum(@RequestBody Album newAlbum) {
	return ar.save(newAlbum);
	}
	@PutMapping("/album/{albumId}")
	Album editAlbum(@RequestBody Album editedAlbum, @PathVariable("albumId") Long id) {
		editedAlbum.setId(id);
		return ar.save(editedAlbum);
	}
}
