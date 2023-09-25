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
import musicapp.domain.Genre;
import musicapp.domain.GenreRepository;

@Controller
public class AlbumController {
	@Autowired
	private AlbumRepository albumrep;
	@Autowired
	private ArtistRepository artistrep;
	@Autowired
	private GenreRepository genrerep;
	
	@GetMapping("/albumlist")
	public String getAlbums(Model model) {
		model.addAttribute("albums",albumrep.findAll());
		return "albumlist";
	};

	@GetMapping("delete/{id}")
	public String deleteAlbum(@PathVariable("id") Long id) {
		albumrep.deleteById(id);
		return "redirect:../albumlist";
	}
	@GetMapping("/addalbum")
	public String addAlbum(Model model) {
	    model.addAttribute("album", new Album());
	    model.addAttribute("artists", artistrep.findAll()); 
	    model.addAttribute("genres",genrerep.findAll());
	    return "addalbum";
	}

	@PostMapping("/save")
	public String saveAlbum(@Valid @ModelAttribute("album") Album album, BindingResult br) {
	    if(br.hasErrors()) {
	 	   return "addalbum";
	    }

	    Artist artist = artistrep.findById(album.getArtist().getId()).orElse(null);
	    Genre genre = genrerep.findById(album.getGenre().getGenreId()).orElse(null);
	    if(artist != null & genre!=null) {
	 	   album.setArtist(artist);
	 	   album.setGenre(genre);
	 	   albumrep.save(album);
	    }
	    
	    
	    return "redirect:albumlist";
	}

	@GetMapping("/editalbum/{albumId}")
	public String editAlbum(@PathVariable("albumId") Long albumId, Model model) {
		model.addAttribute("album", albumrep.findById(albumId).get());
		return "editalbum";
	}
}
