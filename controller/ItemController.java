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
import com.monapp.dao.ItemDao;
import com.monapp.entity.Item;

@RestController
@CrossOrigin
public class ItemController {

	@Autowired	
	ItemDao itemDao;
	
	@GetMapping("/items/{id}")
	public ResponseEntity<Item> findOne(@PathVariable("id") Integer id){
		
		Item b = itemDao.findByPrimaryKey(id);
		
		if(b == null) {
			return new ResponseEntity<Item>(b, HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Item>(b, HttpStatus.OK);
		}
	}
	
	@GetMapping("/items")
	public ResponseEntity<List<Item>> findAll() {
		List<Item> items = itemDao.findAll();
		return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
	}
	
	@DeleteMapping("/items/{id}")
	public ResponseEntity<Item> delete(@PathVariable("id") Integer id){
		Item tmp = itemDao.findByPrimaryKey(id);
		if (tmp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			itemDao.delete(tmp);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}	
	}
	
	@PostMapping("/items")
	public ResponseEntity<Item> create(@Valid @RequestBody Item item) {
		if (item.getId() > 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		itemDao.save(item);
		return new ResponseEntity<Item>(item, HttpStatus.CREATED);
	}
	@PutMapping("/items")
	public ResponseEntity<Item> update(@RequestBody Item item) {
		if (item.getId() == 0) {
			return create(item);
		}
		item = itemDao.update(item);

		return new ResponseEntity<Item>(item, HttpStatus.OK);
	}
	
    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> errors(){
    		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
    }
}
