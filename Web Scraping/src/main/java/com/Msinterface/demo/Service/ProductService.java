/* Author @ Nishant Suresh Sonar 
created on 26/06/24 
inside the package - com.Msinterface.demo.Service */
package com.Msinterface.demo.Service;

import com.Msinterface.demo.Entities.Product;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface ProductService {

    List<Product> scrapeAndSaveProducts(String url) throws IOException;

    List<Product> findAll();
}
