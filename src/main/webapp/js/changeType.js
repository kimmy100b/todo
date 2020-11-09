function resultType(type, eventNode) {
	var insertItem = eventNode.parentNode;

	if (type == "TODO")
		type = 'DOING';
	else if (type == "DOING") {
		type = 'DONE';
		insertItem.removeChild(eventNode);
	}

	var list = document.querySelector("section[id=" + type + "]");

	list.appendChild(insertItem);
}


function changeButtonClick(id, eventNode) {
	var oReq = new XMLHttpRequest();
	var type = eventNode.parentNode.parentNode.getAttribute("id");
	var url = "./todoType";

	oReq.addEventListener("load", function() {
		if (this.readyState == 4 && this.status == 200) {
			resultType(type, eventNode);
		} else {
			console.log("실패");
		}

	});

	oReq.open("POST", url, true);
	oReq.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	oReq.send("id=" + id + "&type=" + type);
}
