package br.com.marvel.resources;

import java.util.List;

import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.marvel.model.ComicModel;
import br.com.marvel.services.ComicService;

@Controller
@Produces(MediaType.APPLICATION_JSON_VALUE)
public class Comics {

	@Autowired
	public ComicService comicService;

	/**
	 * Simple comics request, does not consumes more then 1 API. Test purpose only.
	 * 
	 * @param refresh
	 *            forces services to refresh the existent cached data Accepted
	 *            value: true
	 * @return JSON Collection representation of ComicModel
	 */
	@ResponseBody
	@RequestMapping(value = "/marvel/comics", method = RequestMethod.GET)
	public List<ComicModel> comics() {
		return this.comicService.getComics();
	}
}
