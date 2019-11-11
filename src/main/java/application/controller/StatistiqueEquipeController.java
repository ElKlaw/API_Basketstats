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

import application.bean.StatistiqueEquipe;
import application.service.IStatistiqueEquipeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = {"StatistiqueEquipe"})
public class StatistiqueEquipeController {
	@Autowired
	private IStatistiqueEquipeService statistiqueEquipeService;
	
	
	@ApiOperation(value="Trouver la statistique du match correspondant à l'ID")
	@GetMapping("match/{id}/equipe/statistique")
	public ResponseEntity<StatistiqueEquipe> getStatistiqueEquipeByMatch(@PathVariable("id") Integer id) {
		StatistiqueEquipe statistiqueEquipe = statistiqueEquipeService.getStatistiqueEquipeMatch(id);
		return new ResponseEntity<>(statistiqueEquipe, HttpStatus.OK);
	}
	
	@ApiOperation(value="Trouver les statistiques de l'équipe correspondant à l'ID")
	@GetMapping("equipe/{id}/statistiques")
	public ResponseEntity<List<StatistiqueEquipe>> getStatistiqueByEquipe(@PathVariable("id") Integer id) {
		List<StatistiqueEquipe> listStatEquipe = statistiqueEquipeService.getStatistiquesEquipe(id);
		return new ResponseEntity<>(listStatEquipe,HttpStatus.OK);
	}
	
	@ApiOperation(value="Trouver la statistique correspondant à l'ID")
	@GetMapping("equipe/statistique/{id}")
	public ResponseEntity<StatistiqueEquipe> getStatistiqueEquipeById(@PathVariable("id") Integer id) {
		Optional<StatistiqueEquipe> statistiqueEquipe = statistiqueEquipeService.getStatistiqueEquipeById(id);
		if(statistiqueEquipe.isPresent()) {
			return new ResponseEntity<>(statistiqueEquipe.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value="Ajout d'une nouvelle statistique equipe")
	@PostMapping("equipe/statistique")
	public ResponseEntity<StatistiqueEquipe> addStatistiqueEquipe(@RequestBody StatistiqueEquipe statistiqueEquipe) {
		StatistiqueEquipe statistiqueEquipeResponse = statistiqueEquipeService.addStatistiqueEquipe(statistiqueEquipe);
		return new ResponseEntity<>(statistiqueEquipeResponse, HttpStatus.OK);
	}
	
	@ApiOperation(value="Modifier une statistique equipe")
	@PutMapping("equipe/statistique")
	public ResponseEntity<StatistiqueEquipe> updateStatistiqueEquipe(@RequestBody StatistiqueEquipe statistiqueEquipe) {
		StatistiqueEquipe statistiqueEquipeResponse = statistiqueEquipeService.updateStatistiqueEquipe(statistiqueEquipe);
		return new ResponseEntity<>(statistiqueEquipeResponse, HttpStatus.OK);
	}
	
	@ApiOperation(value="Supprimer la statistique equipe correspondant à l'ID")
	@DeleteMapping("equipe/statistique/{id}")
	public ResponseEntity<Void> deleteStatistiqueEquipe(@PathVariable("id") Integer id) {
		statistiqueEquipeService.deleteStatistiqueEquipe(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}

