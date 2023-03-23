package org.iclass.mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Member {
	private	int idx;
	private String id;
	private String password;
	private	String name;
	private	String nickname;
	private	String email;
	private String phone;
	private String birth;
	private String grade;
}
