var btn = document.querySelectorAll('.btn-next');

function ajax(data) {
	var oReq = new XMLHttpRequest();
	oReq.addEventListener("load", function() {
		console.log(this.responseText);
	});
	oReq.open("GET", "http://www.example.org/getData?data=data");//parameter를 붙여서 보낼수있음. 
	oReq.send();
}

btn.addEventListener('click', ajax);