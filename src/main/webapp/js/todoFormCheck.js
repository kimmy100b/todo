const frm = document.querySelector('#todoForm');
const title = frm.querySelector('#title');
const name = frm.querySelector('#name');
const MAX_MESSAGE_LEN = 24;

function checkLen() {
	if (title.value.length > MAX_MESSAGE_LEN) {
		alert("24자까지 입력가능합니다.");
		title.value = title.value.substr(0, MAX_MESSAGE_LEN);
	}
}

function checkForm() {
	if (title.value.trim() == "") {
		alert("해야할 일을 입력하세요");
		title.focus();
		return;
	}

	if (name.value.trim() == "") {
		alert("이름을 입력하세요");
		name.focus();
		return;
	} else {
		if (confirm("등록하시겠습니까?"))
			frm.submit();
	}
}

title.addEventListener('keyup', checkLen);
