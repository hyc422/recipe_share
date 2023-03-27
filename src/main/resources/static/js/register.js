
const isValid = true;

document.querySelector("#idcheck").addEventListener('click', function() {
	const id = document.querySelector("#id").value;
	const xhr = new XMLHttpRequest();
	xhr.responseType = 'text';
	xhr.open('GET', '/register/' + id)
	xhr.send()
xhr.onreadystatechange = function() {
  if (xhr.readyState === XMLHttpRequest.DONE) {
    if (xhr.status === 200) {
      const result = parseInt(xhr.responseText);
      console.log(result)
      if (result === 0) {
        document.querySelector('#idOk').innerHTML = '사용 가능한 아이디 입니다.';
        document.querySelector('#idOk').style.color = 'green';
      } else if (result === 1) {
        document.querySelector('#idOk').innerHTML = '사용 중인 아이디 입니다.';
        document.querySelector('#idOk').style.color = 'red';
      }
    }
  }
};
})

//비밀번호 검사
document.querySelector("#password").addEventListener('keyup', function() {
	const pwd = document.join.password.value;
	var pwdchk = /^(?=.[a-zA-Z])(?=.*[!@#$%^&*-])(?=.*[0-9]).{8,25}$/;
	if (!pwdchk.test(pwd)) {
		document.querySelector('#pwdcheckmsg').innerHTML = '사용 불가능'
		document.querySelector('#pwdcheckmsg').style.color = 'red'
		isValid = false;
	} else {
		document.querySelector('#pwdcheckmsg').innerHTML = '사용 가능'
		document.querySelector('#pwdcheckmsg').style.color = 'green'
	}
});
//비밀번호 재입력 검사
document.querySelector("#password2").addEventListener('keyup', function() {
	const pwd = document.join.password.value;
	const pwd2 = document.join.password2.value;
	if (pwd != pwd2) {
		document.querySelector('#pwd2checkmsg').innerHTML = '사용 불가능'
		document.querySelector('#pwd2checkmsg').style.color = 'red'
		isValid = false;
	} else {
		document.querySelector('#pwd2checkmsg').innerHTML = '사용 가능'
		document.querySelector('#pwd2checkmsg').style.color = 'green'
	}
});

document.querySelector('#join').addEventListener('click', function() {
	if (isValid) {
		document.join.submit();
	}
})