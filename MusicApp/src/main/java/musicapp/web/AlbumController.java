package musicapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import musicapp.domain.AlbumRepository;
import musicapp.domain.ArtistRepository;

@Controller
public class AlbumController {
	@Autowired
	private AlbumRepository albumrep;
	@Autowired
	private ArtistRepository artistrep;
	
	@GetMapping("/albumlist")
	public String getAlbums(Model model) {
		model.addAttribute("albums",albumrep.findAll());
		return "albumlist";
	};

}
