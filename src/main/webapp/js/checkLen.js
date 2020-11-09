const frm = document.querySelector('#todoForm');
const title = frm.querySelector('#title');
const content = frm.querySelector('#lenAlert');
const MAX_MESSAGE_LEN = 24;

function checkLen() {
    if (title.value.length > MAX_MESSAGE_LEN) {
        alert("24자까지 입력가능합니다.");
        title.value = title.value.substr(0, MAX_MESSAGE_LEN);
    }
}

title.addEventListener('keyup', checkLen);