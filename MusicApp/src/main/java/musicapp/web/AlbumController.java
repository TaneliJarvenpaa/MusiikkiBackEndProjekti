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

	@GetMapping("albumlist/delete/{id}")
	public String deleteAlbum(@PathVariable("id") Long id) {
		albumrep.deleteById(id);
		return "redirect:../albumlist";
	}
	@GetMapping("/addalbum")
	public String addAlbum(Model model) {
		model.addAttribute("album",new Album());
		return "addalbum";
	}
	@PostMapping("/save")
	public String saveAlbum(@Valid @ModelAttribute("album") Album album,BindingResult br) {
		if(br.hasErrors()) {
			return "albumlist";
		}
		albumrep.save(album);
		return "redirect:albumlist";
	}
}
