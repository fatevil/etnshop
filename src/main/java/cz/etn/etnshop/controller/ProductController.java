package cz.etn.etnshop.controller;

import cz.etn.etnshop.dao.Product;
import cz.etn.etnshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


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
    public ModelAndView create(@ModelAttribute("productForm") Product product, ModelMap model, BindingResult result) {
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

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView update(@PathVariable(value = "id") int id) {
        ModelAndView modelAndView = new ModelAndView("product/update");
        modelAndView.addObject("productForm", productService.find(id));
        return modelAndView;
    }

    @RequestMapping(value = "/fulltext", method = RequestMethod.GET)
    public ModelAndView fulltext() {
        ModelAndView modelAndView = new ModelAndView("product/fulltextsearch");
        return modelAndView;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(@ModelAttribute("productForm") Product product, ModelMap model, BindingResult result) {
        if (productService.serialNumberExistAndIsNotMe(product)) {
            result.rejectValue("serialNumber", "error.serialNumber", "Serial number is already used!");
        }
        if (product.getName().length() == 0) {
            result.rejectValue("name", "error.name", "Name of the product cannot be empty!");
        }

        if (!result.hasErrors()) {
            productService.updateProduct(product);
            ModelAndView modelAndView = new ModelAndView("redirect:/product/list");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("product/update", result.getModel());
            modelAndView.addObject("productForm", product);
            return modelAndView;
        }
    }

    @RequestMapping(value = "/list/fulltext", method = RequestMethod.POST)
    public ModelAndView fulltext(@RequestBody MultiValueMap<String, String> formData) {

        if (formData.containsKey("name")) {
            List<Product> products = productService.fullTextSearch(formData.getFirst("name"));

            ModelAndView modelAndView = new ModelAndView("product/list");
            modelAndView.addObject("products", products);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("product/fulltextsearch");
            return modelAndView;
        }


    }
}
