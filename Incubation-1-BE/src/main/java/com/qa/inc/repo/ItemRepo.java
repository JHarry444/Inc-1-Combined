package com.qa.inc.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.inc.domain.Item;

public interface ItemRepo extends JpaRepository<Item, Long> {

}
