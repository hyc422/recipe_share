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
	const password = document.querySelector('#pwck').value;
	
	if(password == "")
	{
		alert('비밀번호를 입력하세요!')
		return
	}
	
	const xhr = new XMLHttpRequest()
	xhr.open('GET','/info/chkpw/' + email)
	xhr.setRequestHeader('content-type', 'application/json;charset=utf-8')
	
	xhr.send()
	xhr.onload=function()
	{
		const result = JSON.parse(xhr.response)
		
		if(xhr.status === 200 || xhr.status === 201)
		{
			if(result.password == password)
			{
				chkpPwPage.classList.add('hidden');
				chgpPwPage.classList.remove('hidden');
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

// password 유효성 검사 function
document.querySelector("#password").addEventListener('keyup',
function()
{
	const password = document.querySelector('#password').value
	
	if(regPassword.test(password) === true)
	{
		document.querySelector('#password2').style.border = '3px solid green';
		document.querySelector('#regpwChk').innerHTML = "사용 가능"
		document.querySelector('#regpwChk').style.color = 'green'
	}
	else
	{
		document.querySelector('#password2').style.border = '3px solid red';
		document.querySelector('#regpwChk').innerHTML = "비밀번호는 8자 이상 24자 이하"
		document.querySelector('#regpwChk').style.color = 'red'
	}
})

let isValid = false;

// password 재확인 function
document.querySelector("#password2").addEventListener('keyup',
function()
{
	const password2 = document.querySelector('#password').value
	const password3 = document.querySelector('#password2').value
	
	if(password2 == password3)
	{
		document.querySelector('#password').style.border = '3px solid green';
		document.querySelector('#pwChk').innerHTML = "일치"
		document.querySelector('#pwChk').style.color = 'green'
		isValid = true;
	}
	else
	{
		document.querySelector('#password').style.border = '3px solid red';
		document.querySelector('#pwChk').innerHTML = "불일치"
		document.querySelector('#pwChk').style.color = 'red'
	}
})

document.querySelector('#chgPw').addEventListener('click',
function()
{
	const password = document.querySelector('#password').value

	const jsonObj = {"email":email,"password":password}
	console.log(jsonObj)
	const xhr = new XMLHttpRequest()
	xhr.open('PUT','/info/chgPw')
	xhr.setRequestHeader('content-type', 'application/json;charset=utf-8')
	
	const data = JSON.stringify(jsonObj)
	console.log(data)
	xhr.send(data)
	xhr.onload=function()
	{
		const result = JSON.parse(xhr.response)
		
		if(xhr.status === 200 || xhr.status === 201)
		{
			if(result == 1 && isValid)
			{
				location.href='mypage'
				alert('수정 완료')
			}
		}
		else
		{
			console.error('오류',xhr.status)
			alert('수정 오류')
		}
	}
})
