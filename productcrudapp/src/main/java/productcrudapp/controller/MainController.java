package productcrudapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import productcrudapp.dao.ProductDao;
import productcrudapp.model.Product;

@Controller
public class MainController {
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping("/")
	public String home(Model m) {
	List<Product> productList=productDao.getproducts();
	m.addAttribute("products",productList);
		return "index";
	}
	@RequestMapping("/add-product")
	public String addProduct(Model m){
		m.addAttribute("title","ADD PRODUCT");
		return "addproduct_form";
	}
	@RequestMapping(value = "/handle-product",method = RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product,HttpServletRequest request) {
		System.out.println(product);
		productDao.createproduct(product);
		RedirectView redirectView=new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
		
		
	}
	@RequestMapping("/delete/{productId}")
	public RedirectView deleteProduct(@PathVariable("productId") int productid,HttpServletRequest request) {
		productDao.deleteproduct(productid);
		RedirectView redirectView=new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	@RequestMapping("/update/{productId}")
	public String updateForm(@PathVariable("productId") int productid,Model m) {
		Product product =productDao.getProduct(productid);
		m.addAttribute("product", product);
		return "update-form";
	}

}
