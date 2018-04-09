package br.com.marvel.resources;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.marvel.model.ComicModel;
import br.com.marvel.services.ComicService;

@RestController
@Produces(MediaType.APPLICATION_JSON_VALUE)
public class Comics {

	@Autowired
	public ComicService comicService;

	@GetMapping("/marvel/comics")
	public List<ComicModel> comics() {
		return this.comicService.getComics();
	}
	
	@GetMapping("/marvel/comics/{comicId}")
	public ComicModel getComicById(@NotNull @PathVariable("getComicById") Integer comicId) {
		return this.comicService.getComicById(comicId);
	}
}
