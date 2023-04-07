/**
 * chgPw
 */

// 유효성 검사
let regPassword =/^[a-zA-Z\\d`~!@#$%^&*()-_=+]{8,24}$/

var chkpPwPage = document.querySelector('#chkpw-page');
var chkPwForm = document.querySelector('#chkPwForm');

var chgpPwPage = document.querySelector('#chgpw-page');

document.querySelector('#chkpw').addEventListener('click',
function()
{
	const password = document.querySelector('#password').value.trim();

	if(password == "")
	{
		alert('비밀번호를 입력하세요!')
		return
	}
	
	const xhr = new XMLHttpRequest()
	xhr.open('GET','/info/chkpw/'+email)
	
	xhr.send(data)
	xhr.onload=function()
	{
		const result = JSON.parse(xhr.response)
		
		if(xhr.status === 200 || xhr.status === 201)
		{
			if(result != null)
			{
				chkpPwPage.classList.add('hidden');
				chgpPwPage.classList.remove('hidden');
				alert('비밀번호 확인')
			}
			else
				alert('비밀번호 입력 오류')
		}
		else
		{
			console.error('오류',xhr.status)
			alert('오류')
		}
	}
})