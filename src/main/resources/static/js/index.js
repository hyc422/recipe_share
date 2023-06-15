function fetchVideos(type, container) {
	const API_KEY = "AIzaSyB4qRfJv7oiFQnZfZe2WJ2GN6hJjW0oZsU";
	//const API_KEY = "AAA";
	let API_URL = "https://www.googleapis.com/youtube/v3/search?part=snippet&maxResults=5&order=";

	// 검색 유형에 따라 API URL 설정
	if (type === "top10") {
		API_URL += "viewCount";
	} else if (type === "latest10") {
		API_URL += "date";
	}

	API_URL += "&q=요리 레시피&regionCode=KR&key=" + API_KEY;

	fetch(API_URL)
		.then(response => response.json())
		.then(data => {
			console.log(data);

			// 검색 결과가 있을 경우 비디오 목록 생성
			if (data.items.length > 0) {
				data.items.forEach(item => {
					const video = document.createElement("div");
					video.classList.add("video");
					const title = item.snippet.title.length > 10 ? item.snippet.title.slice(0, 10) + "..." : item.snippet.title;
					const channelTitle = item.snippet.channelTitle.length > 5 ? item.snippet.channelTitle.slice(0, 5) + "..." : item.snippet.channelTitle;
					video.innerHTML = `
            <a href="https://www.youtube.com/watch?v=${item.id.videoId}" target="_blank">
              <img src="${item.snippet.thumbnails.high.url}">
              <h2>${title}</h2>
              <p>${channelTitle}</p>
            </a>
          `;
					container.appendChild(video);
				});
			}
		})
		.catch(error => console.error(error));
}

// 페이지 로드 후 비디오 목록 호출
window.onload = function() {
	fetchVideos("top10", document.querySelector(".top10"));
	fetchVideos("latest10", document.querySelector(".latest10"));
}