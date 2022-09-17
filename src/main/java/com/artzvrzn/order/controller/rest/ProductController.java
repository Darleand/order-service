package com.artzvrzn.order.controller.rest;

import com.artzvrzn.order.dto.ProductRequest;
import com.artzvrzn.order.dto.ProductResponse;
import com.artzvrzn.order.service.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = {"", "/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> get() {
        return productService.getAll();
    }

    @PostMapping(value = {"", "/"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody ProductRequest dto) {
        productService.create(dto);
    }

    @PutMapping(value = {"/{id}", "/{id}/"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") Long id, @RequestBody ProductRequest dto) {
        productService.update(id, dto);
    }

    @DeleteMapping(value = {"/{id}", "/{id}/"})
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        productService.delete(id);
    }
}
