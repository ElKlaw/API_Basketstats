package application.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import application.bean.Match;
import application.service.IMatchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = {"Match"})
public class MatchController {
	@Autowired
	private IMatchService matchService;
	
	@ApiOperation(value="Trouver les matchs de l'équipe correspondant à l'ID")
	@GetMapping("equipe/{id}/matchs")
	public ResponseEntity<Page<Match>> getEventsEquipe(@PathVariable("id") Integer id,
			@RequestParam(defaultValue="0", value="page", required=false) int page, 
			@RequestParam(defaultValue="10", value="size", required=false) int size,
			@RequestParam(value="type", required=false) String typeRecherche) {
		Pageable pageable =  PageRequest.of(page, size);
		Page<Match> listMatch = matchService.getMatchsEquipe(id, pageable, typeRecherche);
		return new ResponseEntity<>(listMatch,HttpStatus.OK);
	}
	
	@ApiOperation(value="Trouver les matchs du club correspondant à l'ID")
	@GetMapping("club/{id}/matchs")
	public ResponseEntity<Page<Match>> getEventsMatchsClub(@PathVariable("id") Integer id, 
			@RequestParam(defaultValue="0", value="page", required=false) int page, 
			@RequestParam(defaultValue="10", value="size", required=false) int size,
			@RequestParam(value="type", required=false) String typeRecherche) {
		Pageable pageable =  PageRequest.of(page, size);
		Page<Match> listMatch = matchService.getMatchsClub(id, pageable, typeRecherche);
		return new ResponseEntity<>(listMatch,HttpStatus.OK);
	}
	
	@ApiOperation(value="Trouver les matchs du joueur correspondant à l'ID")
	@GetMapping("joueur/{id}/matchs")
	public ResponseEntity<List<Match>> getEventsJoueur(@PathVariable("id") Integer id) {
		List<Match> listMatch = matchService.getMatchsJoueur(id);
		return new ResponseEntity<>(listMatch,HttpStatus.OK);
	}
	
	
	@ApiOperation(value="Trouver le match correspondant à l'ID")
	@GetMapping("match/{id}")
	public ResponseEntity<Match> getMatchById(@PathVariable("id") Integer id) {
		Optional<Match> match = matchService.getMatchById(id);
		if(match.isPresent()) {
			return new ResponseEntity<>(match.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value="Ajout d'un nouveau match")
	@PostMapping("match")
	public ResponseEntity<Match> addMatch(@RequestBody Match match) {
		Match matchResponse = matchService.addMatch(match);
		return new ResponseEntity<>(matchResponse, HttpStatus.OK);
	}
	
	@ApiOperation(value="Modifier un match")
	@PutMapping("match")
	public ResponseEntity<Match> updateMatch(@RequestBody Match match) {
		Match matchResponse = matchService.updateMatch(match);
		return new ResponseEntity<>(matchResponse, HttpStatus.OK);
	}
	
	@ApiOperation(value="Supprimer le match correspondant à l'ID")
	@DeleteMapping("match/{id}")
	public ResponseEntity<Void> deleteMatch(@PathVariable("id") Integer id) {
		matchService.deleteMatch(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
