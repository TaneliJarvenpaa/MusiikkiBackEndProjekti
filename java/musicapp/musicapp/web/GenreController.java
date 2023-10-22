package musicapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import musicapp.domain.AlbumRepository;
import musicapp.domain.ArtistRepository;
import musicapp.domain.GenreRepository;

@Controller
public class GenreController {
	@Autowired
	private AlbumRepository albumrep;
	
	@Autowired
	private ArtistRepository artistrep;
	
	@Autowired
	private GenreRepository genrerep;
	
	@GetMapping("/genrelist")
	public String getGenre(Model model) {
		model.addAttribute("genres",genrerep.findAll());
		return "genrelist";
	}

}
