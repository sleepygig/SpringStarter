package com.aditya.ecom_project1.Controllers;

import com.aditya.ecom_project1.Models.Product;
import com.aditya.ecom_project1.Service.ProdService;
import jdk.jshell.Snippet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin  // Set the exact origin
public class ProductController {
    @Autowired
    private ProdService p; // Assume this service fetches the product data

    // Change this method to serve the HTML page
    @GetMapping("/api/products")
    public List<Product> getAllProducts(Model model) {
        List<Product> products = p.getproducts(); // Fetch the product list
//        model.addAttribute("products", products);
//        return "home";  // Return the Thymeleaf template
        return products;


    }



    @PostMapping("/api/products/add")
    public ResponseEntity<Snippet.Status> add(@RequestBody Product pro, Model model) {
        p.add(pro);
        return new ResponseEntity<>(HttpStatus.OK);

    }
    @GetMapping("api/products/{id}")
    public ResponseEntity<Product> byid(@PathVariable int id)
    {
        Product qw=p.byid(id);
        if(qw!=null)
            return  new ResponseEntity<>(qw, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("api/products/update")
    ResponseEntity<Snippet.Status> update(@RequestBody Product q)
    {
        p.update(q);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("api/products/delete/{id}")
    void delete(@PathVariable int id)
    {
        p.delete(id);
    }



}
