package com.example.demo.mapper;

import com.example.demo.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by admin on 2017/6/2.
 */

@Mapper
public interface ProductMapper {

    Product select(@Param("id") Long id);

    void update(Product product);
}
