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

import musicapp.domain.Artist;

import musicapp.domain.ArtistRepository;

@RestController
public class RestArtistController {
	@Autowired
	ArtistRepository ar;
	
	@GetMapping("/artists")
	public Iterable<Artist>  getRestArtists(){
		return ar.findAll();
	}
	
	@GetMapping("/artist/{artistId}")
	public Optional<Artist> getOneArtist(@PathVariable("artistId")Long id){
		return ar.findById(id);
	}
	
	@DeleteMapping("/artist/{artistId}")
	public List<Artist> deleteById(@PathVariable("artistId")Long id){
		 ar.deleteById(id);
		 return (List<Artist>) ar.findAll();
	}
	@PostMapping("/artist")
	Artist newArtist(@RequestBody Artist newArtist) {
	return ar.save(newArtist);
	}
	@PutMapping("/artist/{artistId}")
	Artist editRestArtist(@RequestBody Artist editedArtist, @PathVariable("artistId") Long id) {
		editedArtist.setId(id);
		return ar.save(editedArtist);
	}
}
