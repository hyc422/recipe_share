package org.iclass.mvc.dto;

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
public class UploadFile {
	int upidx;
	int boardNum;
	String fileName;
	String filePath;
	String saveFileName;
}
