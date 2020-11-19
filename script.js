function sendAjax() {
	var xhr = new XMLHttpRequest();
	xhr.open('GET', 'http://127.0.0.1:8080/rest/list-cars', false);
	xhr.onreadystatechange = function() { 
		  if (xhr.readyState != 4) {
			  return;
		  } else if(xhr.status == 200)  {
			  var cars = JSON.parse(xhr.responseText);
			  var carsElement = document.getElementById('cars');
			  for(let car of cars) {
				  var carElement = document.createElement('div');
				  carElement.innerHTML = car.name;
				  carsElement.appendChild(carElement); 
			  }
		  }
	}
	xhr.send();
}

window.onload = sendAjax;
