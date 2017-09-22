package cz.etn.etnshop.controller;

import cz.etn.etnshop.dao.Product;
import cz.etn.etnshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("product/list");
        modelAndView.addObject("products", productService.getProducts());
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("product/create");
        modelAndView.addObject("productForm", new Product());
        return modelAndView;
    }

    // TODO: bean validation
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView addStudent(@ModelAttribute("productForm") Product product, ModelMap model, BindingResult result) {
        if (productService.serialNumberExist(product)) {
            result.rejectValue("serialNumber", "error.serialNumber", "Serial number is already used!");
        }
        if (product.getName().length() == 0) {
            result.rejectValue("name", "error.name", "Name of the product cannot be empty!");
        }

        if (!result.hasErrors()) {
            productService.saveProduct(product);
            ModelAndView modelAndView = new ModelAndView("redirect:/product/list");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("product/create", result.getModel());
            modelAndView.addObject("productForm", product);
            return modelAndView;
        }


    }
}
