package com.qa.inc.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.inc.domain.Item;
import com.qa.inc.service.ItemService;

@RestController
@RequestMapping("/item")
@CrossOrigin
public class ItemController {

	private ItemService service;

	public ItemController(ItemService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Item> create(@RequestBody Item item) {
		return new ResponseEntity<Item>(this.service.create(item), HttpStatus.CREATED);
	}

	@GetMapping("/read")
	public ResponseEntity<List<Item>> getAll() {
		return ResponseEntity.ok(this.service.getAll());
	}

	@GetMapping("/read/{id}")
	public ResponseEntity<Item> get(@PathVariable Long id) {
		return ResponseEntity.ok(this.service.get(id));
	}

	@PatchMapping("/update/{id}")
	public ResponseEntity<Item> update(@PathVariable Long id, @RequestBody Item newItem) {
		return ResponseEntity.ok(this.service.update(id, newItem));
	}

	@PatchMapping("/addCart/{id}")
	public ResponseEntity<Item> addToCart(@PathVariable Long id) {
		return ResponseEntity.ok(this.service.addToCart(id));
	}

	@PatchMapping("/removeCart/{id}")
	public ResponseEntity<Item> removeFromCart(@PathVariable Long id) {
		return ResponseEntity.ok(this.service.removeFromCart(id));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Item> delete(@PathVariable Long id) {
		return new ResponseEntity<>(this.service.delete(id) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
