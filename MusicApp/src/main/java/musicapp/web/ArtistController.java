package musicapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import musicapp.domain.AlbumRepository;
import musicapp.domain.ArtistRepository;

@Controller
public class ArtistController {
	@Autowired
	private AlbumRepository albumrep;
	@Autowired
	private ArtistRepository artistrep;
	
	@GetMapping("/artistlist")
	public String getArtists(Model model) {
		model.addAttribute("artists",artistrep.findAll());
		return "artistlist";
	};
	

}
