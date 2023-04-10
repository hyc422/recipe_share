
let isValid = false;

document.querySelector("#idcheck").addEventListener('click', function() {
   const email = document.querySelector("#email").value;
   const xhr = new XMLHttpRequest();
   var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
   if (!regExp.test(email)) {
      alert('이메일형식이 아닙니다')
   } else {
      xhr.responseType = 'text';
      xhr.open('GET', '/find/' + email)
      xhr.send()
      xhr.onreadystatechange = function() {
         if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
               const result = parseInt(xhr.responseText);
               console.log(result)
               if (result === 0) {
                  document.querySelector('#email').style.border = '3px solid green';
                  isValid = true;
               } else if (result >= 1) {
                  document.querySelector('#email').style.border = '3px solid red';
               }
            }
         }
      }
   }
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
					document.querySelector('#nickname').style.border = '3px solid green';
					isValid = true;
				} else if (result === 1) {
					document.querySelector('#nickname').style.border = '3px solid red';
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
		document.querySelector('#password').style.border = '3px solid red'
	} else {
		isValid = true;
		document.querySelector('#password').style.border = '3px solid green'
	}
});
//비밀번호 재입력 검사
document.querySelector("#password2").addEventListener('keyup', function() {
	const pwd = document.join.password.value;
	const pwd2 = document.join.password2.value;
	if (pwd != pwd2) {
		document.querySelector('#password2').style.border = '3px solid red'
	} else {
		isValid = true;
		document.querySelector('#password2').style.border = '3px solid green'
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
						document.querySelector('#verification-codechk').style.border = '3px solid green'
						isValid = true;
					} else {
						document.querySelector('#verification-codechk').style.border = '3px solid red'
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

