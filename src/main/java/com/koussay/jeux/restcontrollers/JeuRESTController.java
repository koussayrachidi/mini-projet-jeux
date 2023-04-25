package com.koussay.jeux.restcontrollers;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.koussay.jeux.entities.Jeu;
import com.koussay.jeux.service.JeuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class JeuRESTController {
	@Autowired
	JeuService jeuService;
	@RequestMapping(method = RequestMethod.GET)
	public List<Jeu> getAllProduits() {
	return jeuService.getAllJeux();
}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Jeu getJeuById(@PathVariable("id") Long id) {
	return jeuService.getJeu(id);
	 }
	@RequestMapping(method = RequestMethod.POST)
	public Jeu createJeu(@RequestBody Jeu jeu) {
	return jeuService.saveJeu(jeu);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Jeu updateJeu(@RequestBody Jeu jeu) {
	return jeuService.updateJeu(jeu);
	}

	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteJeu(@PathVariable("id") Long id)
	{
		jeuService.deleteJeuById(id);
	}

	@RequestMapping(value="/jeuxent/{idEnt}",method = RequestMethod.GET)
	public List<Jeu> getJeuxByEntId(@PathVariable("idEnt") Long idEnt) {
	return jeuService.findByEntrepriseIdEnt(idEnt);
	}
	
	
	}
