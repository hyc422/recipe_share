/**
 * 	mypage
 */

function grade_func()
{
	let temp = null
	
	if(grade == '0')
		temp = '관리자'
	else if(grade == '1')
		temp = '요린이'
	else if(grade == '2')
		temp = '짜파게티 요리사'
	else if(grade == '3')
		temp = '셰프'
	else if(grade == '4')
		temp = '고든램지'
	
	document.querySelector('#grade').innerHTML = temp	
}

grade_func()


