/**
 * 	update
 */

// 유효성 검사
let regNickName =/^[가-힣0-9a-zA-Z]{2,10}$/
let regPhone =/^\d{3}-\d{4}-\d{4}$/
let regEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;


// 별명 유효성 검사 function
document.querySelector("#lblNickName").addEventListener('keyup',
function()
{
	const nickName = document.querySelector('#lblNickName').value
	
	if(regNickName.test(nickName) === true)
	{
		document.querySelector('#nickChk').innerHTML = "사용 가능"
		document.querySelector('#nickChk').style.color = 'green'
	}
	else
	{
		document.querySelector('#nickChk').innerHTML = "사용 불가"
		document.querySelector('#nickChk').style.color = 'red'
	}
})

// 전화번호 유효성 검사 function
document.querySelector("#lblPhone").addEventListener('keyup',
function()
{
	const phone = document.querySelector('#lblPhone').value
	
	if(regPhone.test(phone) === true)
	{
		document.querySelector('#phoneChk').innerHTML = "사용 가능"
		document.querySelector('#phoneChk').style.color = 'green'
	}
	else
	{
		document.querySelector('#phoneChk').innerHTML = "사용 불가"
		document.querySelector('#phoneChk').style.color = 'red'
	}
})

// email 유효성 검사 function
document.querySelector("#lblEmail").addEventListener('keyup',
function()
{
	const email = document.querySelector('#lblEmail').value
	
	if(regEmail.test(email) === true)
	{
		document.querySelector('#emailChk').innerHTML = "사용 가능"
		document.querySelector('#emailChk').style.color = 'green'
	}
	else
	{
		document.querySelector('#emailChk').innerHTML = "사용 불가"
		document.querySelector('#emailChk').style.color = 'red'
	}
})

// 정보 수정
document.querySelector('#update').addEventListener('click',
function()
{
	const id = document.querySelector('#lblId').value
	const name = document.querySelector('#lblName').value
	const nickname = document.querySelector('#lblNickName').value
	const phone = document.querySelector('#lblPhone').value
	const email = document.querySelector('#lblEmail').value

	const jsonObj = {"id":id,"name":name,"nickname":nickname,"phone":phone,"email":email,"birth":birth,"createAt":createAt,"grade":grade}
	
	const xhr = new XMLHttpRequest()
	xhr.open('PUT','/update/'+id)
	xhr.setRequestHeader('content-type', 'application/json;charset=utf-8')
	
	const data = JSON.stringify(jsonObj)
	xhr.send(data)
	xhr.onload=function()
	{
		if(xhr.status === 200 || xhr.status === 201)
		{
			location.href='/mypage'
		}
		else
			console.error('오류',xhr.status)
	}
})