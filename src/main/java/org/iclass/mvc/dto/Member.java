package org.iclass.mvc.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = {"idx","password"})
public class Member {
	private	int idx;
	private	String email;
	private String password;
	private	String name;
	private	String nickname;
	private String phone;
	private Date birth;
	private String grade;
}
