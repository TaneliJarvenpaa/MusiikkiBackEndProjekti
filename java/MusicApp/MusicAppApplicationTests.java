package MusicApp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import musicapp.web.AlbumController;
import musicapp.web.ArtistController;
import musicapp.web.GenreController;
import musicapp.web.RestAlbumController;
import musicapp.web.RestArtistController;


@SpringBootTest

class MusicAppApplicationTests {
	
	@Autowired
	private AlbumController albumcontroller;
	@Autowired
	private ArtistController artistcontroller;
	@Autowired
	private GenreController genrecontroller;
	@Autowired 
	private RestAlbumController restalbumcontroller;
	@Autowired 
	private RestArtistController restartistcontroller;
	@Autowired
	private WebApplicationContext webAppContext;

	private MockMvc mockMvc;

	@BeforeEach 
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
	}


	@Test
	public void statusOk() throws Exception {
		mockMvc.perform(get("/api/albums")).andExpect(status().isOk());
	}

	@Test
	public void responseTypeApplicationJson() throws Exception {
		mockMvc.perform(get("/api/albums"))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	
	

	@Test
	void contextLoads(){
		assertThat(albumcontroller).isNotNull();
		assertThat(artistcontroller).isNotNull();
		assertThat(genrecontroller).isNotNull();
		assertThat(restalbumcontroller).isNotNull();
		assertThat(restartistcontroller).isNotNull();
		
	}
	


}
