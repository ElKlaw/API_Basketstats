package application.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import application.bean.StatistiqueJoueur;
import application.service.IStatistiqueJoueurService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = {"StatistiqueJoueur"})
public class StatistiqueJoueurController {
	@Autowired
	private IStatistiqueJoueurService statistiqueJoueurService;

	@ApiOperation(value="Trouver la statistique du match correspondant à l'ID")
	@GetMapping("match/{id}/joueurs/statistique")
	public ResponseEntity<List<StatistiqueJoueur>> getStatistiqueJoueurByMatch(@PathVariable("id") Integer id) {
		List<StatistiqueJoueur> statistiqueEquipe = statistiqueJoueurService.getStatistiqueJoueurMatch(id);
		return new ResponseEntity<>(statistiqueEquipe, HttpStatus.OK);
	}
	
	@ApiOperation(value="Trouver les statistiques de l'équipe correspondant à l'ID")
	@GetMapping("joueur/{id}/statistiques")
	public ResponseEntity<List<StatistiqueJoueur>> getStatistiqueByJoueur(@PathVariable("id") Integer id) {
		List<StatistiqueJoueur> listStatJoueur = statistiqueJoueurService.getStatistiquesJoueur(id);
		return new ResponseEntity<>(listStatJoueur,HttpStatus.OK);
	}
	
	@ApiOperation(value="Trouver la statistique correspondant à l'ID")
	@GetMapping("joueur/statistique/{id}")
	public ResponseEntity<StatistiqueJoueur> getStatistiqueJoueurById(@PathVariable("id") Integer id) {
		Optional<StatistiqueJoueur> statistiqueJoueur = statistiqueJoueurService.getStatistiqueJoueurById(id);
		if(statistiqueJoueur.isPresent()) {
			return new ResponseEntity<>(statistiqueJoueur.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value="Ajout d'une nouvelle statistique joueur")
	@PostMapping("joueur/statistique")
	public ResponseEntity<StatistiqueJoueur> addStatistiqueJoueur(@RequestBody StatistiqueJoueur statistiqueJoueur) {
		StatistiqueJoueur statistiqueJoueurResponse = statistiqueJoueurService.addStatistiqueJoueur(statistiqueJoueur);
		return new ResponseEntity<>(statistiqueJoueurResponse, HttpStatus.OK);
	}
	
	@ApiOperation(value="Modifier une statistique joueur")
	@PutMapping("joueur/statistique")
	public ResponseEntity<StatistiqueJoueur> updateStatistiqueJoueur(@RequestBody StatistiqueJoueur statistiqueJoueur) {
		StatistiqueJoueur statistiqueJoueurResponse = statistiqueJoueurService.updateStatistiqueJoueur(statistiqueJoueur);
		return new ResponseEntity<>(statistiqueJoueurResponse, HttpStatus.OK);
	}
	
	@ApiOperation(value="Supprimer la statistique joueur correspondant à l'ID")
	@DeleteMapping("joueur/statistique/{id}")
	public ResponseEntity<Void> deleteStatistiqueJoueur(@PathVariable("id") Integer id) {
		statistiqueJoueurService.deleteStatistiqueJoueur(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
