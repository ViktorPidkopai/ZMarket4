package ua.org.oa.podkopayv.zmarket4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.org.oa.podkopayv.zmarket4.repository.ProductRepository;

@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ProductRepository productRepository;



}
