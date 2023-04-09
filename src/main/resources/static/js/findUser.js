document.addEventListener('DOMContentLoaded', function() {
	document.querySelector("#emailfind").addEventListener('click', function() {
		const name = document.querySelector('#name').value;
		const phone = document.querySelector('#phone').value;
		const xhr = new XMLHttpRequest();
		xhr.responseType = 'text';
		xhr.open('GET', '/findem?name=' + name + '&phone=' + phone);
		xhr.send();
		xhr.onreadystatechange = function() {
			if (xhr.readyState === XMLHttpRequest.DONE) {
				if (xhr.status === 200) {
					const result = xhr.responseText;
					alert("가입하신 계정의 이메일은 ['"+result+"']입니다.")
				}
			}
		}
	})
	document.querySelector('#pwdfind').addEventListener('click',function(){
		const email = document.querySelector('#email').value;
		const name2 = document.querySelector('#name2').value;
		const xhr = new XMLHttpRequest();
		xhr.responseType = 'text';
		xhr.open('GET','/findpwd?email=' + email + '&name2=' + name2);
		xhr.send()
		xhr.onreadystatechange = function(){
			if(xhr.readyState === XMLHttpRequest.DONE){
				if(xhr.status === 200){
					const result2 = xhr.responseText;
					alert("가입하신 계정의 비밀번호는 ['"+result2+"']입니다.")
				}
			}
		}
	})
	
})
