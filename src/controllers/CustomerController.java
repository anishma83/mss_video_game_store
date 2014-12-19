package com.mss.store.videogame.web.controllers;



import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mss.store.videogame.dao.CustomerDao;
import com.mss.store.videogame.dao.OrderDao;
import com.mss.store.videogame.model.Customer;
import com.mss.store.videogame.model.Order;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerDao customerDao; 
	
	@Autowired
	OrderDao orderDao;
	
	@RequestMapping(value="/signIn",method = RequestMethod.GET)
	public ModelAndView signInPage(){
		ModelAndView model=new ModelAndView("login");
		Customer customer = new Customer();
		model.addObject("mainpage", "login");
		model.addObject("customer", customer);
		return model;
	}
	
	@RequestMapping(value="/signInCheck",method = RequestMethod.GET)
	public ModelAndView SignIn(@Valid @ModelAttribute("customer") Customer customer, BindingResult result, HttpSession session)
	{
		
		ModelAndView model = new ModelAndView();
		List<Customer> customerSignInCheck = customerDao.signedIn(customer.getEmail());
		
		if(customerSignInCheck.get(0).getPassword().equals(customer.getPassword())){
			
			session.setAttribute("is_Logged_In", true);
			customer.setAddress_1(customerSignInCheck.get(0).getAddress_1());
			customer.setAddress_2(customerSignInCheck.get(0).getAddress_2());
			customer.setBilling_Address(customerSignInCheck.get(0).getBilling_Address());
			customer.setBilling_Address_1(customerSignInCheck.get(0).getBilling_Address_1());
			customer.setBilling_City(customerSignInCheck.get(0).getBilling_City());
			customer.setBilling_Country(customerSignInCheck.get(0).getBilling_Country());
			customer.setBilling_Postal(customerSignInCheck.get(0).getBilling_Postal());
			customer.setBilling_State(customerSignInCheck.get(0).getBilling_State());
			customer.setCity(customerSignInCheck.get(0).getCity());
			customer.setCountry(customerSignInCheck.get(0).getCountry());
			customer.setCredit_Card(customerSignInCheck.get(0).getCredit_Card());
			customer.setCredit_Card_Id(customerSignInCheck.get(0).getCredit_Card_Id());
			customer.setCredit_Expiration_Month(customerSignInCheck.get(0).getCredit_Expiration_Month());
			customer.setCredit_Expiration_Year(customerSignInCheck.get(0).getCredit_Expiration_Year());
			customer.setCustomer_Id(customerSignInCheck.get(0).getCustomer_Id());
			customer.setDate_Entered(customerSignInCheck.get(0).getDate_Entered());
			customer.setEmail(customerSignInCheck.get(0).getEmail());
			customer.setFirst_Name(customerSignInCheck.get(0).getFirst_Name());
			customer.setLast_Name(customerSignInCheck.get(0).getLast_Name());
			customer.setMember(customerSignInCheck.get(0).getMember());
			customer.setPassword(customerSignInCheck.get(0).getPassword());
			customer.setPhone(customerSignInCheck.get(0).getPhone());
			customer.setPostal(customerSignInCheck.get(0).getPostal());
			customer.setUs_State(customerSignInCheck.get(0).getUs_State());
			System.out.println("the information that came back from dao is: "+customer.getAddress_1());
					
			
			session.setAttribute("customerInfo", customer);
			model.setViewName("product");
		}
		else if(customerSignInCheck.isEmpty()){
			model.setViewName("login");
			model.addObject("Login_Info", "Username or Password not found");
			session.setAttribute("is_Logged_In", false);
		}
		
		System.out.println(session.getAttribute("is_Logged_In").toString());
		return model;
		 
	}


	@RequestMapping(value="/signUp",method= RequestMethod.GET)
	public ModelAndView signUpPage() {
		ModelAndView model = new ModelAndView("signUp");
		Customer customer = new Customer();
		model.addObject("signUpPage", "signUp");
		model.addObject("customer", customer);
		return model;		
	}
	
		
	@RequestMapping(value="/saveCustomer", method= RequestMethod.GET)
	public ModelAndView saveCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult result, HttpSession session) throws ParseException {
		ModelAndView model = new ModelAndView("viewProfile");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date currentDate = new java.util.Date();
		String cDate=sdf.format(currentDate);
		customer.setDate_Entered(Date.valueOf(cDate));
		customer.setMember("t");
		System.out.println("The record values are: "+customer.toString());
		customerDao.save(customer);	
		session.setAttribute("customerInfo", customer);
		return model;
	}
	
	@RequestMapping(value="/viewProfile", method= RequestMethod.GET)
	public ModelAndView viewProfile(HttpSession session ) {
		ModelAndView model = new ModelAndView("memberProfile");
		Customer customer = (Customer) session.getAttribute("customerInfo");
		model.addObject("customer", customer);
		System.out.println(customer.getAddress_1());
		model.addObject("profilePage", "viewProfile");
	return model;
	}
}

