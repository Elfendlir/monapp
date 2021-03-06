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
import com.monapp.dao.InventaireDao;
import com.monapp.entity.Inventaire;

@RestController
@CrossOrigin
public class InventaireController {

	@Autowired	
	InventaireDao inventaireDao;
	
	@GetMapping("/inventaires/{id}")
	public ResponseEntity<Inventaire> findOne(@PathVariable("id") Integer id){
		
		Inventaire b = inventaireDao.findByPrimaryKey(id);
		
		if(b == null) {
			return new ResponseEntity<Inventaire>(b, HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Inventaire>(b, HttpStatus.OK);
		}
	}
	
	@GetMapping("/inventaires")
	public ResponseEntity<List<Inventaire>> findAll() {
		List<Inventaire> inventaires = inventaireDao.findAll();
		return new ResponseEntity<List<Inventaire>>(inventaires, HttpStatus.OK);
	}
	
	@DeleteMapping("/inventaires/{id}")
	public ResponseEntity<Inventaire> delete(@PathVariable("id") Integer id){
		Inventaire tmp = inventaireDao.findByPrimaryKey(id);
		if (tmp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			inventaireDao.delete(tmp);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}	
	}
	
	@PostMapping("/inventaires")
	public ResponseEntity<Inventaire> create(@Valid @RequestBody Inventaire inventaire) {
		if (inventaire.getId() > 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		inventaireDao.save(inventaire);
		return new ResponseEntity<Inventaire>(inventaire, HttpStatus.CREATED);
	}
	@PutMapping("/inventaires")
	public ResponseEntity<Inventaire> update(@RequestBody Inventaire inventaire) {
		if (inventaire.getId() == 0) {
			return create(inventaire);
		}
		inventaire = inventaireDao.update(inventaire);

		return new ResponseEntity<Inventaire>(inventaire, HttpStatus.OK);
	}
	
    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> errors(){
    		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
    }
}
