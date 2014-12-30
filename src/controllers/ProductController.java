package com.mss.store.videogame.web.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mss.store.videogame.dao.CategoryDao;
import com.mss.store.videogame.dao.ProductDao;
import com.mss.store.videogame.model.CartService;
import com.mss.store.videogame.model.Category;
import com.mss.store.videogame.model.Product;

@Controller
public class ProductController {
	private CartService cartService;
	
	
	@Autowired
	private ProductDao	productDao;
	@Autowired
	private CategoryDao	categoryDao;
	
	@RequestMapping("/products")
	protected String mainLoad(ModelMap map ,
					HttpServletRequest request,
					HttpServletResponse response) throws Exception {
		PagedListHolder pagedListHolder = new PagedListHolder<Product>( productDao.list());
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		int pageSize = 10;
		pagedListHolder.setPageSize(pageSize);
		map.addAttribute("pagedListHolder", pagedListHolder);
		
		
		map.addAttribute("URIPATH","products");
		map.addAttribute("categories",categoryDao.list());
		map.addAttribute("pr", new Product());//pricerange
		map.addAttribute("catnames", new Category());
		map.addAttribute("mainpage", "products.jsp");
		
		return "Template";
	}
	
	@RequestMapping("/search")
	protected String search(ModelMap map,
			HttpServletRequest request,
			HttpServletResponse response, @RequestParam(value = "searchValue") String searchValue) throws Exception
	{
		PagedListHolder pagedListHolder = new PagedListHolder<Product>( productDao.search("product_Name", searchValue));
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		int pageSize = 10;
		pagedListHolder.setPageSize(pageSize);
		map.addAttribute("pagedListHolder", pagedListHolder);
		
		map.addAttribute("searchValue",searchValue);
		map.addAttribute("URIPATH","search");
		map.addAttribute("categories",categoryDao.list());
		map.addAttribute("pr", new Product());//pricerange
		map.addAttribute("catnames", new Category());
		map.addAttribute("mainpage", "products.jsp");
		
		return "Template";
	}
	
	@RequestMapping("/genre")
	protected String searchByCat(@RequestParam(value = "genreSearch") String searchValue,
			ModelMap map ,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		PagedListHolder pagedListHolder = new PagedListHolder<Product>( productDao.lookupByCategoryId(Integer.parseInt(searchValue)));
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		int pageSize = 10;
		pagedListHolder.setPageSize(pageSize);
		map.addAttribute("pagedListHolder", pagedListHolder);
		
		map.addAttribute("categories",categoryDao.list());
		
		map.addAttribute("genreSearch",searchValue);
		map.addAttribute("URIPATH","genre");
		map.addAttribute("pr", new Product());//pricerange
		map.addAttribute("catnames", new Category());
		map.addAttribute("mainpage", "products.jsp");
		return "Template";
	}
	@RequestMapping("/pricing")
	protected String searchByPricing(@RequestParam(value = "pID") String pricerange,
			ModelMap map,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		StringTokenizer st = new StringTokenizer(pricerange);
		int start=Integer.parseInt(st.nextToken());
		st.nextToken();
		int end=Integer.parseInt(st.nextToken());
		
		
		PagedListHolder pagedListHolder = new PagedListHolder<Product>( productDao.lookupByPrice(start, end));
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		int pageSize = 10;
		pagedListHolder.setPageSize(pageSize);
		map.addAttribute("pagedListHolder", pagedListHolder);
		
		map.addAttribute("categories",categoryDao.list());
		map.addAttribute("pID",pricerange);
		map.addAttribute("URIPATH","pricing");
		map.addAttribute("pr", new Product());//pricerange
		map.addAttribute("catnames", new Category());
		map.addAttribute("mainpage", "products.jsp");
		return "Template";
	}
	
	@Deprecated
	@RequestMapping("/productssss")
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
	@Deprecated
	@RequestMapping("/searchDEP")
	protected ModelAndView searchProd(HttpServletRequest request,
			HttpServletResponse response, @RequestParam("searchValue") String searchValue) throws Exception
	{

		ModelAndView mav = new ModelAndView();
		mav.setViewName("Template");
		
		List<Category> categories = categoryDao.list();
		
		mav.addObject("categories", categories);
		mav.addObject("products", productDao.list());
		
		mav.addObject("pr", new Product());//pricerange
		mav.addObject("catnames", new Category());
		mav.addObject("mainpage", "products.jsp");
		return mav;
	}
	@Deprecated
	@RequestMapping("/genreDEP")
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
	@Deprecated
	@RequestMapping("/pricingDEP")
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
	
	//GETS/SETS
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
	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}
	//Support 
	public void addPagnation(String type,String[] params){
		
	}
}



/*<form:form id="priceSlider" commandName="pr" method="POST" action="/Mss_Video_Game_Store/pricing">
<form:input path ="pr" value="document.getElementsByClassName('tooltip-inner').innerHTML" style="display:none;"/>
<a onclick="document.getElementById('priceSlider').submit();">GO</a>
</form:form>*/
