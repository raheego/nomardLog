package bbs.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BbsDTO { //DTO = 뷰, 컨트롤러, 서비스, DAO 등의 각 계층 간 데이터를 주고받는 데 사용되는 객체.

	private int bbsId;
	private int memberCode;
	private String title;
	private String contents;
	private LocalDateTime createdAt;
	private LocalDateTime modifyAt;
	private int viewCnt;
	private int likeCnt;
	private int tagId;
	private boolean isDeleted;
	
	
}
