package com.mss.store.videogame.invoice;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.mss.store.videogame.model.Customer;
import com.mss.store.videogame.model.Order;

public class EmailConfirmation {
	
	public EmailConfirmation(Order order, Customer customer)
	{
			
		final String username = "rbjohnson731@gmail.com";
		final String password = "1songoku";
			
		 Properties props = new Properties();
		 props.put("mail.smtp.auth", "true");
		 props.put("mail.smtp.starttls.enable", "true");
		 props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		 props.put("mail.smtp.host", "smtp.gmail.com"); //This is the smtp server address
		 props.put("mail.smtp.port", "587"); //This is the port for the smtp server
		 
	     Session session = Session.getDefaultInstance(props, 
	    		 	new javax.mail.Authenticator(){
	    	 
	    	 			protected PasswordAuthentication getPasswordAuthentication(){
	    	 				return new PasswordAuthentication(username,password); 
	    	 			}
	     });

	     try {
	    	 Message msg = new MimeMessage(session);
	    	 msg.setFrom(new InternetAddress(username));
	    	 msg.setRecipients(Message.RecipientType.TO, 
	    			 new InternetAddress[]{new InternetAddress(customer.getEmail())});
	    	 msg.setSubject("Thanks for your Miracle Games Order " + order.getOrder_Id());
	    	 msg.setText("Thank you for shopping with us. We'd like to let you know that Miracle has received your order, and is preparing it for shipment. Your estimated shipping date is " + order.getShip_Date() 
	    			 		+ ". If you would like to view the status of your order or make any changes to it, please visit Your Orders on Miraclesoft.com."
	    			 		+ "\nOrder Details"
	    			 		+ "\n========================================================================="
	    			 		+ "\nOrder Date: " +  order.getOrder_Date() + "Order Ship Date: " + order.getShip_Date()+ "Paid: " + order.isPaid());
	    	 Transport.send(msg);
	    	 
	    	 System.out.print("Was the email sent: Done");

	     } catch (AddressException e) {
	    	 e.printStackTrace();
	     } catch (MessagingException e) {
	    	 e.printStackTrace();
	     }
	}

}
