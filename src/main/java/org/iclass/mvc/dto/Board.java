package org.iclass.mvc.dto;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Board {
	private int idx;	// seq
	private String category; // 카테고리
	private String subCate;	// 대분류
	private String nickname;	//작성자
	private String title;	//글 제목
	private String filename;	//파일명
	private String content;	// 글 내용
	private LocalDateTime regdate;	// 작성일자
	private int viewcnt; //조회수
	private int numcomments;//댓글 갯수
	
	private List<MultipartFile> pics;
	
}
