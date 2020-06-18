package org.zerock.persistence;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.SearchCriteria;

//@Repository
public interface BoardDAO {

	public void create(BoardVO vo)throws Exception;
	
	public BoardVO read(Integer bno)throws Exception;
	
	public void update(BoardVO vo)throws Exception;
	
	public void delete(Integer bno)throws Exception;
	
	public List<BoardVO> listAll()throws Exception;
	
	public List<BoardVO> listPage(int page) throws Exception;
	
//	criteria객체를 파라미터로 전달받고, 필요한 getPageStart()와 getPerPageNum() 메소드를 호출한 결과를 사용
	public List<BoardVO> listCriteria(Criteria cri) throws Exception;
	
	public int countPaging(Criteria cri) throws Exception;
	
	
	//use for dynamic sql 동적 SQL문을 적용하기 위한 메소드 설정
	//검색과 페이징을 둘 다 처리하기 위해 SearchCriteria 를 파라미터로 받음
	  public List<BoardVO> listSearch(SearchCriteria cri)throws Exception;
	  
	  public int listSearchCount(SearchCriteria cri)throws Exception;
	
}
