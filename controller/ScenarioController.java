package com.monapp.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.monapp.dao.ScenarioDao;
import com.monapp.entity.Scenario;

@RestController
@CrossOrigin
public class ScenarioController {

	@Autowired	
	ScenarioDao scenarioDao;
	
	@GetMapping("/scenarios/{id}")
	public ResponseEntity<Scenario> findOne(@PathVariable("id") Integer id){
		
		Scenario b = scenarioDao.findByPrimaryKey(id);
		
		if(b == null) {
			return new ResponseEntity<Scenario>(b, HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Scenario>(b, HttpStatus.OK);
		}
	}
	
	@GetMapping("/scenarios")
	public ResponseEntity<List<Scenario>> findAll() {
		List<Scenario> scenarios = scenarioDao.findAll();
		return new ResponseEntity<List<Scenario>>(scenarios, HttpStatus.OK);
	}
	
	@DeleteMapping("/scenarios/{id}")
	public ResponseEntity<Scenario> delete(@PathVariable("id") Integer id){
		Scenario tmp = scenarioDao.findByPrimaryKey(id);
		if (tmp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			scenarioDao.delete(tmp);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}	
	}
	
	@PostMapping("/scenarios")
	public ResponseEntity<Scenario> create(@Valid @RequestBody Scenario scenario) {
		if (scenario.getId() > 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		scenarioDao.save(scenario);
		return new ResponseEntity<Scenario>(scenario, HttpStatus.CREATED);
	}
	
	@PutMapping("/scenarios")
	public ResponseEntity<Scenario> update(@RequestBody Scenario scenario) {
		if (scenario.getId() == 0) {
			return create(scenario);
		}
		scenario = scenarioDao.update(scenario);

		return new ResponseEntity<Scenario>(scenario, HttpStatus.OK);
	}
	
    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> errors(){
    		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
    }

}
