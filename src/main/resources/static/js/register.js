
let isValid = false;
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
					document.querySelector('#idOk').innerHTML = '사용 가능한 아이디 입니다.';
					document.querySelector('#idOk').style.color = 'green';
					isValid = true;
				} else if (result === 1) {
					document.querySelector('#idOk').innerHTML = '사용 중인 아이디 입니다.';
					document.querySelector('#idOk').style.color = 'red';
				}
			}
		}
	};
})
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
					document.querySelector('#nnOk').innerHTML = '사용 가능한 아이디 입니다.';
					document.querySelector('#nnOk').style.color = 'green';
					isValid = true;
				} else if (result === 1) {
					document.querySelector('#nnOk').innerHTML = '사용 중인 아이디 입니다.';
					document.querySelector('#nnOk').style.color = 'red';
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
	} else {
		isValid = true;
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
		isValid = true;
		document.querySelector('#pwd2checkmsg').innerHTML = '사용 가능'
		document.querySelector('#pwd2checkmsg').style.color = 'green'
	}
});
//이메일 전송
$(document).ready(function() {
	$("#send-email-button").click(function() {
		var email = $("#email").val();

		$.ajax({
			type: "POST",
			url: "/api/mail/confirm.json",
			data: {
				"email": email
			},
			success: function(data) {
				alert("이메일이 발송되었습니다. 인증코드를 확인해주세요.");
				document.querySelector('#emailcheck').addEventListener('click', function() {
				const code = data;
				const codec = document.querySelector('#verification-codechk').value;
					if (codec === code) {
						document.querySelector('#true').innerHTML = '인증완료'
					document.querySelector('#pwd2checkmsg').style.color = 'green'
						isValid = true;
					} else {
						document.querySelector('#true').innerHTML = '인증실패'
						document.querySelector('#pwd2checkmsg').style.color = 'red'
					}
				})
			},
			error: function(data) {
				alert("이메일 발송에 실패하였습니다.");
			}
		});
	});
});

document.querySelector('#join').addEventListener('click', function() {
	if (isValid) {
		document.join.submit();
	} else {
		alert("정보확인요망")
	}
})

