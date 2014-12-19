package com.ms.store.videogame.invoice;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


import com.ms.store.videogame.model.Invoice;
import com.ms.store.videogame.model.Product;

/**
 * 
 * @author Anton Franklin
 *
 */
public class ReorderProduct {
	
	/**
	 * Creates ReorderProduct that will check the reorder status of 
	 * every product from current order.
	 * @param invoice - contains the products list to be checked
	 */
	public ReorderProduct(Invoice invoice)
	{		
		List<Product> prodReorder = new ArrayList<Product>();
		
		for(Product product : invoice.getProducts())
		{
			if(product.getUnits_In_Stock() <= product.getReorder_Level() && product.getUnits_On_Order() <= 0)
			{
				prodReorder.add(product);
				
			}
		}
		emailAdmin(prodReorder);
	}
	
	/**
	 * Sends email to Admin of products that need reordering
	 * @param reorderList - list of reordering products
	 */
	public void emailAdmin(List<Product> reorderList)
	{
		 Properties props = new Properties();
		 props.setProperty("mail.smtp.host", "localhost");
	     Session session = Session.getDefaultInstance(props, null);
	     String list = "";

	     try {
	    	 Message msg = new MimeMessage(session);
	    	 msg.setFrom(new InternetAddress("support@miraclesoft.com"));
	    	 msg.setRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress("kbissell@miraclesoft.com")});
	    	 msg.setSubject("Reorder Products Alert");
	    	 
	    	 for(int i=0; i<reorderList.size(); i++)
	    	 {
	    		 list.concat(reorderList.get(i).getSupplier_Id() + reorderList.get(i).getSupplier_Product_Id() + reorderList.get(i).getProduct_Name() + "\n");
	    	 }
	    	 
	    	 msg.setText("The Following Products must be reordered. [Supplier ID, Supplier Product ID, Product Name]" + "\n " + list);
	    	 
	    	 
	    	 Transport.send(msg);

	     } catch (AddressException e) {
	    	 e.printStackTrace();
	     } catch (MessagingException e) {
	    	 e.printStackTrace();
	     }
		
	}

}
