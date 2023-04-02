package org.iclass.mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserList 
{
	private String userId;
	private String roomId;
	private String nickName;
}	// Class end
