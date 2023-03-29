
document.querySelector("#idcheck").addEventListener('click', function() {
	const id = document.querySelector("#email").value;
	const xhr = new XMLHttpRequest();
	xhr.responseType = 'text';
	xhr.open('GET', '/find/' + id)
	xhr.send()
	xhr.onreadystatechange = function() {
		if (xhr.readyState === XMLHttpRequest.DONE) {
			if (xhr.status === 200) {
				const result = parseInt(xhr.responseText);
				console.log(result)
				if (result === 0) {
					document.querySelector('#idOk').innerHTML = '사용 가능한 아이디 입니다.<br>';
					document.querySelector('#idOk').style.color = 'green';
				} else if (result === 1) {
					document.querySelector('#idOk').innerHTML = '사용 중인 아이디 입니다.';
					document.querySelector('#idOk').style.color = 'red';
				}
			}
		}
	};
})

document.querySelector('#email').addEventListener('keyup', function() {
	const email = document.join.email.value;
	var emchk = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	if (!emchk.test(email)) {
		document.querySelector('#emchk').innerHTML = '사용 불가능'
		document.querySelector('#emchk').style.color = 'red'
	} else {
		document.querySelector('#emchk').innerHTML = '사용 가능'
		document.querySelector('#emchk').style.color = 'green'
		document.getElementById("idcheck").style.display = "inline-block";
	}
})

//비밀번호 검사
document.querySelector("#password").addEventListener('keyup', function() {
	const pwd = document.join.password.value;
	var pwdchk = /^(?=.[a-zA-Z])(?=.*[!@#$%^&*-])(?=.*[0-9]).{8,25}$/;
	if (!pwdchk.test(pwd)) {
		document.querySelector('#pwdcheckmsg').innerHTML = '사용 불가능'
		document.querySelector('#pwdcheckmsg').style.color = 'red'
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
	} else {
		document.querySelector('#pwd2checkmsg').innerHTML = '사용 가능'
		document.querySelector('#pwd2checkmsg').style.color = 'green'
	}
});

document.querySelector("#phone").addEventListener('keyup', function() {
	const phone = document.join.phone.value;
	var phchk = /^[0-9]{3}-[0-9]{4}-[0-9]{4}$/;
	if (!phchk.test(phone)) {
		document.querySelector('#phmsg').innerHTML = '사용 불가능'
		document.querySelector('#phmsg').style.color = 'red'
	} else {
		document.querySelector('#phmsg').innerHTML = '사용 가능'
		document.querySelector('#phmsg').style.color = 'green'
	}
});
document.querySelector("#nickchk").addEventListener('click', function() {
	const nickname = document.querySelector("#nickname").value;
	const xhr = new XMLHttpRequest();
	xhr.responseType = 'text';
	xhr.open('GET', '/finds/' + nickname)
	xhr.send()
	xhr.onreadystatechange = function() {
		if (xhr.readyState === XMLHttpRequest.DONE) {
			if (xhr.status === 200) {
				const result = parseInt(xhr.responseText);
				console.log(result)
				if (result === 0) {
					document.querySelector('#nnOk').innerHTML = '사용 가능한 별명 입니다.';
					document.querySelector('#nnOk').style.color = 'green';
				} else if (result === 1) {
					document.querySelector('#nnOk').innerHTML = '사용 중인 별명 입니다.';
					document.querySelector('#nnOk').style.color = 'red';
				}
			}
		}
	};
})

document.querySelector('#checkEmail').addEventListener('click', function() {
	const email = document.querySelector('#email').value;
	const xhr = new XMLHttpRequest();
	xhr.open('POST', 'login/mailConfirm');
	xhr.setRequestHeader('Content-Type', 'application/json;charset=UTF-8');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
        const code = xhr.responseText; // 서버에서 반환된 값을 가져옴
				console.log("인증코드 : " + code); // 로그로 출력
			}
		}
	}
	const data = JSON.stringify({ 'email': email }); // 데이터 전송
	xhr.send(data);
});


document.querySelector('#rkdlq').addEventListener('click', function() {
	if (isValid) {
		document.join.submit();
	}

})
