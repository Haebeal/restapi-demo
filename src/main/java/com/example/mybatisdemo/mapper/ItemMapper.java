package com.example.mybatisdemo.mapper;

import com.example.mybatisdemo.entity.Item;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemMapper {
  Item findById(int id);
}
