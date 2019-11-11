package application.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.bean.Sport;
import application.repository.ParametreRepository;
import application.service.IParametreService;

@Service
public class ParametreService implements IParametreService{
	@Autowired
	private ParametreRepository parametreRepository;
	
	public List<Sport> getAllSports(){
		return StreamSupport.stream(parametreRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}
}
