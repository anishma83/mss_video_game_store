package com.ms.store.videogame.invoice;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.ms.store.videogame.model.Customer;
import com.ms.store.videogame.model.Order;

public class EmailConfirmation {
	
	public EmailConfirmation(Order order, Customer customer)
	{
		 Properties props = new Properties();
		 props.setProperty("mail.smtp.host", "localhost");
	     Session session = Session.getDefaultInstance(props, null);

	     try {
	    	 Message msg = new MimeMessage(session);
	    	 msg.setFrom(new InternetAddress("support@miraclesoft.com"));
	    	 msg.setRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress(customer.getEmail())});
	    	 msg.setSubject("Thanks for your Miracle Games Order " + order.getOrder_Id());
	    	 msg.setText("Thank you for shopping with us. We'd like to let you know that Miracle has received your order, and is preparing it for shipment. Your estimated shipping date is " + order.getShip_Date() 
	    			 		+ ". If you would like to view the status of your order or make any changes to it, please visit Your Orders on Miraclesoft.com."
	    			 		+ "\nOrder Details"
	    			 		+ "\n========================================================================="
	    			 		+ "\nOrder Date: " +  order.getOrder_Date() + "Order Ship Date: " + order.getShip_Date()+ "Paid: " + order.isPaid());
	    	 Transport.send(msg);

	     } catch (AddressException e) {
	    	 e.printStackTrace();
	     } catch (MessagingException e) {
	    	 e.printStackTrace();
	     }
	}

}
