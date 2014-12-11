<tr>
	<td class="cart_product"> 
	<a href="#" ><img src="${products[loop.index].image}" alt="" class="img-thumbnail img-responsive" /></a>
	</td>
	<td class="cart_description">
		<h4>
			<a href="">#{products[loop.index].product_Name}</a>
		</h4>
		<p>${products[loop.index].sku}</p></td>
	<td class="cart_price">
		<p>${orderDetail.price}</p></td>
	<td class="cart_quantity">
		<div class="cart_quantity_button">
			<a class="cart_quantity_up" href=""> + </a> <input
				class="cart_quantity_input" type="text" name="quantity"
				value="${orderDetail.quantity}" autocomplete="off" size="2">
			<a class="cart_quantity_down" href=""> - </a>
		</div></td>
	<td class="cart_total">
		<p class="cart_total_price">${orderDetail.total}</p></td>
	<td class="cart_delete"><a class="cart_quantity_delete" href=""><i
			class="fa fa-times"></i>
	</a></td>
</tr>