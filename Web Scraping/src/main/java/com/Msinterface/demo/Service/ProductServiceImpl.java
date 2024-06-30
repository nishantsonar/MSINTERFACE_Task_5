/* Author @ Nishant Suresh Sonar 
created on 26/06/24 
inside the package - com.Msinterface.demo.Service */
package com.Msinterface.demo.Service;

import com.Msinterface.demo.Entities.Product;
import com.Msinterface.demo.Repository.ProductRepository;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> scrapeAndSaveProducts(String url) throws IOException {
        List<Product> products = new ArrayList<>();
//        Document document = Jsoup.connect(url).get();
//        Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) " +
//                "Gecko/20070725 Firefox/2.0.0.6").get();
        Connection connection = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36")
                .header("Accept-Language", "en-US,en;q=0.5")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Referer", "https://www.google.com/")
                .timeout(10000);

        Document doc = connection.get();
        System.out.println(doc);
        Element amazonPriceElement = doc.select(".a-price-whole").first();
        Element amazonProductTitleElem = doc.select("#productTitle").first();
        Element amazonRatingElement = doc.select("span.a-icon-alt").first();
        System.out.println("Name:: " + amazonProductTitleElem + " Price::: " + amazonPriceElement + " rating::: " + amazonRatingElement);

        String productName = doc.select("#productTitle").first().text();
        String productPrice = doc.select(".a-price-whole").first().text();
        ;
        String productRating = doc.select("span.a-icon-alt").first().text();
//        System.out.println("Name:: "+productName);
//        System.out.println("Price:: "+productPrice);
//        System.out.println(" rating::: "+productRating);
        Product product = new Product();
        product.setName(productName);
        product.setPrice(Double.parseDouble(productPrice));
        product.setRating(productRating);
        return productRepository.saveAll(products);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
