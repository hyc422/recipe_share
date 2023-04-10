/**
 * 
 */

'use strict';


var nickNamePage = document.querySelector('#nickName-page');
var nickNameForm = document.querySelector('#nickNameForm');

var chatPage = document.querySelector('#chat-page');

var connectingElement = document.querySelector('.connecting');

var messageForm = document.querySelector('#messageForm');
var messageArea = document.querySelector('#messageArea');
var messageInput = document.querySelector('#message');

var stompClient = null;

const url = new URL(location.href).searchParams;
const roomId = url.get('roomId');  

function connect()
{
	//nickName = document.querySelector('#nickName').value.trim();
	
	//nickNamePage.classList.add('hidden');
	//chatPage.classList.remove('hidden');
	
	var socket = new SockJS('/ws-stomp');
	stompClient = Stomp.over(socket);
	
	stompClient.connect({}, onConnected, onError);
	
	//event.preventDefault();
}  

function onConnected()
{
	stompClient.subscribe('/sub/chat/chatroom/' + roomId, onMessageReceived);

	stompClient.send("/pub/chat/enterUser",
        {},
        JSON.stringify({
            "roomId": roomId,
            sender: nickName,
            type: 'ENTER'
        })
    )
	connectingElement.classList.add('hidden');									 
}

function getUserList()
{
	const $list = $("#list");
	
	$.ajax
	({
		type: "GET",
		url : "/chat/userlist",
		data:{"roomId":roomId},
		success:function(data)
		{
			console.log(data)
			var users = "";
			
			for(let i=0;i<data.length;i++)
			{
				users += "<li class='dropdown-item'>" + data[i] + "</li>"
			}
			
			$list.html(users);
		}
	})
}

function onError(error) 
{
    connectingElement.textContent = 'Could not connect to WebSocket server. Please refresh this page to try again!';
    connectingElement.style.color = 'red';
}

function sendMessage(event)
{
	var messageContent = messageInput.value.trim();
	
	if(messageContent && stompClient)
	{
		var chatMessage =
		{
			"roomId" : roomId,
			sender: nickName,
			message: messageInput.value,
			type:'TALK'
		};
		
		stompClient.send("/pub/chat/sendMessage", {}, JSON.stringify(chatMessage));
		messageInput.value = '';
	}
	event.preventDefault();
}

function onMessageReceived(payload)
{
	
	var chat = JSON.parse(payload.body)
	
	var messageElement = document.createElement('li');
	
	if(chat.type === 'ENTER')
	{
		messageElement.classList.add('event-message');
		chat.content = chat.sender + chat.message;
		getUserList();
	}
	else if(chat.type === 'LEAVE')
	{
		messageElement.classList.add('event-message');
		chat.content = chat.sender + chat.message;
		getUserList();
	}
	else
	{
		messageElement.classList.add('chat-message');
		
		//var avatarElement = document.createElement('span');
		//var avatarText = document.createTextNode(chat.sender[0]);
		//avatarElement.appendChild(avatarText);
		//avatarElement.style['background-color'] = getAvatarColor(chat.sender);
		
		// messageElement.appendChild(avatarElement);
		
		var nickNameElement = document.createElement('span');
		var nickNameText = document.createTextNode(chat.sender);
		nickNameElement.appendChild(nickNameText)
		nickNameElement.style['background-color'] = getAvatarColor(grade);
		
		messageElement.appendChild(nickNameElement);
	}
	
	var textElement = document.createElement('p');
	var messageText = document.createTextNode(chat.message);
	textElement.appendChild(messageText);
	
	messageElement.appendChild(textElement);
	
	if(chat.type === 'TALK')
	{
		var timeElement = document.createElement('p');
		var timeText = document.createTextNode(chat.time);
		timeElement.appendChild(timeText);
		
		messageElement.appendChild(timeElement);
	}
	
	messageArea.appendChild(messageElement);
	messageElement.scrollTop = messageArea.scrollHeight;
}

function getAvatarColor(grade)
{
	var color = null;
	
	if(grade == 0)
		color='#2196F3';
	else if(grade == 1)
		color='#32c787';
	else if(grade == 2)
		color='#00BCD4';
	else if(grade == 3)
		color='#ff5652';
	else if(grade == 4)
		color='#ffc107';
		
	return color;
}

connect()

messageForm.addEventListener('submit', sendMessage, true)