package com.itemsharing.itemservice.controller;

import com.itemsharing.itemservice.pojo.Item;
import com.itemsharing.itemservice.pojo.User;
import com.itemsharing.itemservice.service.ItemService;
import com.itemsharing.itemservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<Item> addItem(@RequestBody Item item) throws Exception {
        String username = "jadams";
        Item reqItem = itemService.addItemByUser(item, username);
        if (reqItem != null) {
            return ResponseEntity.status(HttpStatus.OK).body(reqItem);
        } else {
            throw new Exception();
        }
    }

    @RequestMapping(value="/itemsByUser", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<Item>> getAllItemsByUser() throws Exception {
        String username = "jadams";
        List<Item> items = itemService.getItemsByUsername(username);
        if (items != null) {
            return ResponseEntity.status(HttpStatus.OK).body(items);
        } else {
            throw new Exception();
        }

    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @RequestMapping(value ="/{id}", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public Item getItemById(@PathVariable(value = "id") Long id) {
        return itemService.getItemById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    public Item updateItem (@PathVariable(value = "id") Long id, @RequestBody Item item) throws IOException {
        item.setId(id);
        return itemService.updateItem(item);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json", consumes = "application/json")
    public void deleteItemById(@PathVariable(value = "id") Long id) throws IOException {
        itemService.deleteItemById(id);
    }

    @RequestMapping(value = "/user/{username}", method = RequestMethod.GET, produces = "application/json")
    public User getUserByUsername(@PathVariable(value = "username") String username) {
        return itemService.getUserByUsername(username);
    }
}
