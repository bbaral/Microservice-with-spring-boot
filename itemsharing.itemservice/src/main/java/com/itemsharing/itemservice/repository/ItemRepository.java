package com.itemsharing.itemservice.repository;

import com.itemsharing.itemservice.pojo.Item;
import com.itemsharing.itemservice.pojo.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ItemRepository extends CrudRepository<Item, Long> {
    List<Item> findByUser(User user);
    Item findByName(String name);
}
