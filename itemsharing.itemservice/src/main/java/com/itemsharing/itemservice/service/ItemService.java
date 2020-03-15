package com.itemsharing.itemservice.service;

import com.itemsharing.itemservice.pojo.Item;
import com.itemsharing.itemservice.pojo.User;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ItemService {
    Item addItemByUser(Item item, String username);

    List<Item> getAllItems();

    List<Item> getItemsByUsername(String username);

    Item getItemById(Long id);

    Item updateItem(Item item) throws IOException;

    void deleteItemById(Long id);

    User getUserByUsername(String username);
}
