package com.example.mybatisdemo.controller;

import com.example.mybatisdemo.dto.ItemRequest;
import com.example.mybatisdemo.dto.ItemResponse;
import com.example.mybatisdemo.entity.Item;
import com.example.mybatisdemo.mapper.ItemMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

  @Autowired
  ItemMapper itemMapper;

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ItemResponse findById(@PathVariable int id) {
    // DBからidをキーにデータ取得
    Item item = itemMapper.findById(id);

    // Responseにデータをコピーしてreturn
    ItemResponse itemResponse = new ItemResponse();
    BeanUtils.copyProperties(item, itemResponse);
    return itemResponse;
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<ItemResponse> getItems() {
    List<ItemResponse> itemResponsesList = new ArrayList<>();

    List<Item> itemList = itemMapper.findAll();

    itemList.forEach(item -> {
      ItemResponse itemResponse = new ItemResponse();
      BeanUtils.copyProperties(item, itemResponse);
      itemResponsesList.add(itemResponse);
    });

    return itemResponsesList;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @Transactional
  public ItemResponse doPost(@RequestBody ItemRequest itemRequest) {
    Item item = new Item();
    BeanUtils.copyProperties(itemRequest, item);

    int ret = itemMapper.insert(item);

    ItemResponse itemResponse = new ItemResponse();
    BeanUtils.copyProperties(item, itemResponse);

    return itemResponse;
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  @Transactional
  public ItemResponse doPut(@PathVariable int id, @RequestBody ItemRequest itemRequest) {
    Item item = new Item();
    BeanUtils.copyProperties(itemRequest, item);
    item.setId(id);
    itemMapper.update(item);

    ItemResponse itemResponse = new ItemResponse();
    BeanUtils.copyProperties(item, itemResponse);

    return itemResponse;
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void doDelete(@PathVariable int id) {
    boolean ret = itemMapper.delete(id);
  }
}
