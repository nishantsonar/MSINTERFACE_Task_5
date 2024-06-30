/* Author @ Nishant Suresh Sonar 
created on 26/06/24 
inside the package - com.Msinterface.demo.Controller */
package com.Msinterface.demo.Controller;

import com.Msinterface.demo.Entities.Product;
import com.Msinterface.demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController()
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/scrape")
    public List<Product> scrapeProducts(@RequestParam String url) throws IOException {
        return productService.scrapeAndSaveProducts(url);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.findAll();
    }
}
