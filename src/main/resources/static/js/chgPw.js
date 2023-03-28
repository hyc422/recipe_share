/**
 * chgPw
 */

// 유효성 검사
let regPassword =/^[a-zA-Z\\d`~!@#$%^&*()-_=+]{8,24}$/

document.querySelector('#chkPw').addEventListener('click',
function()
{	
	const xhr = new XMLHttpRequest()
	xhr.open('GET','/info/chkPw/'+id)
	xhr.send()		
	xhr.onload=function()	
	{
		if(xhr.status === 200 || xhr.status === 201)
		{
			const jsonObj = JSON.parse(xhr.response);

            else if(isOk=='success')
            {
		        const member = jsonObj.member;
		        document.getElementById('name').value = member.name;
		        document.getElementById('email').value = member.email;
		        document.getElementById('age').value = member.age;
		        document.getElementById('hobbies').value = member.hobbies;
		        document.querySelectorAll('.hobby').forEach(item => 
		        {	//customer.hobby 에 있는 텍스트가 체크박스 요소의 value 를 포함하고 있는지 각각 비교함.
		            if (member.hobbies.includes(item.value)) item.checked = true;
		            else item.checked = false;    
	      	    });
            }
		}
		else
			console.error('오류',xhr.status)
	}
})