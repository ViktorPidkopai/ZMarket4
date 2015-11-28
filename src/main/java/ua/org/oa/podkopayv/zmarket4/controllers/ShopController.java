package ua.org.oa.podkopayv.zmarket4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.org.oa.podkopayv.zmarket4.model.Product;
import ua.org.oa.podkopayv.zmarket4.repository.ProductRepository;

import java.util.List;

@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(produces = "application/json", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Product> getAll() {
        List<Product> result = productRepository.getAll();
        System.out.println("getAll() method is work.");
        if (result.isEmpty()) {
            System.out.println("Empty result.");
        } else {
            for (Product p : result) {
                System.out.println(p);
            }
        }
        return result;
    }


}
