package bbs.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import bbs.dto.BbsDTO;

@Mapper
public interface BbsMapper {
	 List<BbsDTO> selectBbsList() throws Exception; 
	 
	 void insertBbs(BbsDTO bbs) throws Exception;
	

}
