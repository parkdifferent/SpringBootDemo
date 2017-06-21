package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.mapper.ProductMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by admin on 2017/6/2.
 */

@RestController
@RequestMapping("/product")
public class ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductMapper productMapper;

    @GetMapping("/index")
    @ResponseBody
    public String index() {
        return "hello,world";
    }

    @GetMapping("/{id}")
    public Product getProductInfo(@PathVariable("id") Long id)  {
        Product product = productMapper.select(id);
        LOGGER.info("product = {}",product.toString());
        return product;

    }

    @PutMapping("/{id}")
    public void updateProductInfo(@PathVariable("id") Long id, @RequestBody Product product) {

        productMapper.update(product);

    }
}
