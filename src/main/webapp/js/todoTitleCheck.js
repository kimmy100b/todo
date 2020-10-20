const title = document.getElementById('title');

const MAX_MESSAGE_LEN = 24;

function checkLen() {
	if (title.value.length >  MAX_MESSAGE_LEN) {
		alert("24자까지 입력가능합니다.");
		document.getElementById('title').value = title.value.substr(0,MAX_MESSAGE_LEN);
	}
}

title.addEventListener('keyup', checkLen);
