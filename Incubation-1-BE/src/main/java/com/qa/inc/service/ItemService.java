package com.qa.inc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.inc.domain.Item;
import com.qa.inc.exceptions.ItemNotFoundException;
import com.qa.inc.repo.ItemRepo;

@Service
public class ItemService {

	private ItemRepo repo;

	public ItemService(ItemRepo repo) {
		super();
		this.repo = repo;
	}

	public Item create(Item item) {
		return this.repo.save(item);
	}

	public List<Item> getAll() {
		return this.repo.findAll();
	}

	public Item get(Long id) {
		return this.repo.findById(id).orElseThrow(ItemNotFoundException::new);
	}

	public Item update(Long id, Item newItem) {
		Item found = this.get(id);

		if (newItem.getName() != null && !newItem.getName().isEmpty())
			found.setName(newItem.getName());

		if (newItem.getPrice() != null && newItem.getPrice() > 0)
			found.setPrice(newItem.getPrice());

		return this.repo.save(found);
	}

	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

	public Item addToCart(Long id) {
		Item found = this.get(id);

		found.setInCart(true);

		return this.repo.save(found);
	}

	public Item removeFromCart(Long id) {
		Item found = this.get(id);

		found.setInCart(false);

		return this.repo.save(found);
	}
}
