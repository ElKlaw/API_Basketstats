package application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import application.bean.Sport;
import application.service.IParametreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = {"Configuration"})
public class ParametreController {
	@Autowired
	private IParametreService parametreService;
	
	@ApiOperation(value="Obtenir l'ensemble des sports")
	@GetMapping("/sports")
	public ResponseEntity<List<Sport>> getAllSport() {
		List<Sport> listSport = parametreService.getAllSports();
		return new ResponseEntity<List<Sport>>(listSport, HttpStatus.OK);
	}
}
