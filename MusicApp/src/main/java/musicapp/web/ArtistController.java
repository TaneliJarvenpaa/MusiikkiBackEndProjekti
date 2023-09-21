package musicapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import musicapp.domain.Album;
import musicapp.domain.AlbumRepository;
import musicapp.domain.Artist;
import musicapp.domain.ArtistRepository;
import musicapp.domain.GenreRepository;

@Controller
public class ArtistController {
	@Autowired
	private AlbumRepository albumrep;
	@Autowired
	private ArtistRepository artistrep;
	@Autowired
	private GenreRepository genrerep;
	
	@GetMapping("/artistlist")
	public String getArtists(Model model) {
		model.addAttribute("artists",artistrep.findAll());
		return "artistlist";
	};
	
	@GetMapping("artistlist/delete/{id}")
	public String deleteArtist(@PathVariable("id") Long id) {
		artistrep.deleteById(id);
		return "redirect:../artistlist";
	}
	@GetMapping("/addartist")
	public String addArtist(Model model) {
		model.addAttribute("artist",new Artist());
		return "addartist";
	}
	@PostMapping("/saveartist")
	public String saveArtist(@Valid @ModelAttribute("artist") Artist artist,BindingResult br) {
		if(br.hasErrors()) {
			return "artistlist";
		}
		artistrep.save(artist);
		return "redirect:artistlist";
	}
	

}
