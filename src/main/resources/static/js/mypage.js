/**
 * 	mypage
 */

function grade_func()
{
	const grade = null
	
	if('[[${session.member.grade}]] == 0')
		grade = '관리자'
	else if('[[${session.member.grade}]] == 1')
		grade = '요린이'
	else if('[[${session.member.grade}]] == 2')
		grade = '짜파게티 요리사'
	else if('[[${session.member.grade}]] == 3')
		grade = '셰프'
	else if('[[${session.member.grade}]] == 4')
		grade = '고든램지'
		
	document.querySelector('#grade').innerHTML = grade	
}

grade_func()