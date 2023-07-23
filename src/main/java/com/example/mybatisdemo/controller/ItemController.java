package com.example.mybatisdemo.controller;

import com.example.mybatisdemo.dto.ItemResponse;
import com.example.mybatisdemo.entity.Item;
import com.example.mybatisdemo.mapper.ItemMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController {

  @Autowired
  ItemMapper itemMapper;

  @GetMapping("/{id}")
  public ItemResponse findById(@PathVariable int id) {
    // DBからidをキーにデータ取得
    Item item = itemMapper.findById(id);

    // Responseにデータをコピーしてreturn
    ItemResponse itemResponse = new ItemResponse();
    BeanUtils.copyProperties(item, itemResponse);
    return itemResponse;
  }
}
