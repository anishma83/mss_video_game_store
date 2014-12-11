package com.mss.store.videogame.web.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mss.store.videogame.dao.CategoryDao;
import com.mss.store.videogame.dao.ProductDao;
import com.mss.store.videogame.model.Category;
import com.mss.store.videogame.model.Product;

@Controller
public class ProductController {
	
	@Autowired
	private ProductDao	productDao;
	@Autowired
	private CategoryDao	categoryDao;
	
	@RequestMapping("/products")
	protected ModelAndView load(HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Template");
		
		List<Category> categories = categoryDao.list();
		
		mav.addObject("products", productDao.list());
		mav.addObject("categories", categories);
		
		mav.addObject("pr", new Product());//pricerange
		mav.addObject("catnames", new Category());
		mav.addObject("mainpage", "products.jsp");
		return mav;
	}
	@RequestMapping("/search")
	protected ModelAndView searchProd(HttpServletRequest request,
			HttpServletResponse response, @RequestParam("searchValue") String searchValue) throws Exception
	{

		ModelAndView mav = new ModelAndView();
		mav.setViewName("Template");
		List<Product> pi = new ArrayList<Product>();
		List<Category> categories = categoryDao.list();
		
		mav.addObject("categories", categories);
		mav.addObject("products", productDao.list());
		
		mav.addObject("pr", new Product());//pricerange
		mav.addObject("catnames", new Category());
		mav.addObject("mainpage", "products.jsp");
		return mav;
	}
	@RequestMapping("/genre")
	public ModelAndView wtf(@ModelAttribute("Mss_Video_Game_Store") Category cat, ModelAndView mav)throws Exception {
		//ModelAndView mav = new ModelAndView()	
		mav.setViewName("Template");
		List<Category> cl =  categoryDao.list();
		List<Product> li = productDao.list();
		List<Product> tmp = new ArrayList<Product>();
		
		String name = cat.getName();
		int id = -1;
		for(Category c : cl){
			if(name.equals(c.getName())){
				id=c.getCategory_Id();
			}
		}
		System.out.println(name+"  "+id);
		for(Product p : li){
			if(id==p.getCategory_Id()){
				tmp.add(p);
			}
		}
		
		mav.addObject("categories", cl);
		mav.addObject("products", (List<Product>)tmp);
		
		mav.addObject("pr", new Product());//pricerange
		mav.addObject("catnames", new Category());
		mav.addObject("mainpage", "products.jsp");
		return mav;
	}
	@RequestMapping("/pricing")
	public ModelAndView plt(@ModelAttribute() Product priceRange, ModelAndView mav)throws Exception {
		mav.setViewName("Template");
		List<Product> pi = new ArrayList<Product>();
		List<Category> categories = categoryDao.list();
			
		String pr = priceRange.getNotes();
		StringTokenizer st = new StringTokenizer(pr);
		int start=Integer.parseInt(st.nextToken());
		st.nextToken();
		int end=Integer.parseInt(st.nextToken());
		for(Product p : productDao.list()){
			if(p.getUnit_Price()>start&&p.getUnit_Price()<end){
				pi.add(p);
			}
		}
		
		mav.addObject("products", pi);
		mav.addObject("categories", categories);
		
		mav.addObject("pr", new Product());//pricerange
		mav.addObject("catnames", new Category());
		mav.addObject("mainpage", "products.jsp");
		return mav;
	}
	public ProductDao getProductDao() {
		return productDao;
	}
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	public CategoryDao getCategoryDao() {
		return categoryDao;
	}
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	public void addProductPageObjects(ModelAndView mav){
/*		mav.addObject("", );
		mav.addObject("", );
		mav.addObject("", );
		mav.addObject("", );
*/	}
}



/*<form:form id="priceSlider" commandName="pr" method="POST" action="/Mss_Video_Game_Store/pricing">
<form:input path ="pr" value="document.getElementsByClassName('tooltip-inner').innerHTML" style="display:none;"/>
<a onclick="document.getElementById('priceSlider').submit();">GO</a>
</form:form>*/
