package com.example.mybatisdemo.mapper;

import com.example.mybatisdemo.entity.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {
  Item findById(int id);
  List<Item> findAll();
}
