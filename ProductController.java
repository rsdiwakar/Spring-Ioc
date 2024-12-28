package com.example.productcatalog.controller;

import com.example.productcatalog.model.Product;
import com.example.productcatalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    // Show homepage with options
    @GetMapping("/")
    public String index() {
        return "index";
    }

    // Show Add Product form
    @GetMapping("/addProduct")
    public String showAddProductForm() {
        return "addProduct";
    }

    // Handle Add Product form submission
    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute Product product) {
        productService.addProduct(product);
        return "redirect:/";
    }

    // Display all products
    @GetMapping("/displayProducts")
    public String displayProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "displayProducts";
    }
}
