
function resultClient()
{
try{
fetch("http://localhost:8080/api/cart").then(
	  res => {
	    res.json().then(
	      data => {
	        if (data.length > 0) {
	          var temp = "";
	          let cont =0;
	          data.forEach((itemData) => {
	            temp += "<tr>";
	            temp += "<td>" + itemData.id + "</td>";
	            temp += "<td>" + itemData.name + "</td>";
	            temp += "<td>" + itemData.description + "</td>";
	            temp += "<td>" + itemData.price + "</td>";
	          	temp += "<td>"+ `<a class="btn btn-danger" href="http://localhost:8080/api/cart/delete/${itemData.id}">Borrar</a>`+ "</td>";
	          	cont = cont + itemData.price;
	          });
	          document.getElementById('cartList').innerHTML = temp;
	          document.getElementById('customAlert').style.display="block";
	          document.getElementById('total').innerHTML = `El total de su carrito es ${cont}`;
	        }
	      }
	    )
	  }
	)
}
catch(error){
	alert("Agregue elementos a su carrito");
}
	

}

window.onload = resultClient();