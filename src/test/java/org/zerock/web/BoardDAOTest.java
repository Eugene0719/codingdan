package org.zerock.web;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.SearchCriteria;
import org.zerock.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class BoardDAOTest {
	
	@Inject
	  private BoardDAO dao;

	  private static Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);

	  //동적 SQL 구문 테스트
	  @Test
	  public void testDynamic1() throws Exception {

	    SearchCriteria cri = new SearchCriteria();
	    cri.setPage(1);
	    cri.setKeyword("글");
	    cri.setSearchType("t");

	    logger.info("=====================================");

	    List<BoardVO> list = dao.listSearch(cri);

	    for (BoardVO boardVO : list) {
	      logger.info(boardVO.getBno() + ": " + boardVO.getTitle());
	    }

	    logger.info("=====================================");

	    logger.info("COUNT: " + dao.listSearchCount(cri));
	  }
	  
//	  @Test
//	  public void testListCriteria() throws Exception {
//
//	    Criteria cri = new Criteria();
//	    cri.setPage(2);
//	    cri.setPerPageNum(5);
//
//	    List<BoardVO> list = dao.listCriteria(cri);
//
//	    for (BoardVO boardVO : list) {
//	      logger.info(boardVO.getBno() + ":" + boardVO.getTitle());
//	    }
//	  }
	  
//	  @Test
//	  public void testListPage() throws Exception {
//
//	    int page = 1;
//
//	    List<BoardVO> list = dao.listPage(page);
//
//	    for (BoardVO boardVO : list) {
//	      logger.info(boardVO.getBno() + ":" + boardVO.getTitle());
//	    }
//	  }
	  
//	  @Test
//	  public void testCreate() throws Exception {
//
//	    BoardVO board = new BoardVO();
//	    board.setTitle("새로운 글을 넣습니다. ");
//	    board.setContent("새로운 글을 넣습니다. ");
//	    board.setWriter("user00");
//	    dao.create(board);
//	  }

//	  @Test
//	  public void testRead() throws Exception {
//
//	    logger.info(dao.read(1).toString());
//	  }

//	  @Test
//	  public void testUpdate() throws Exception {
//
//	    BoardVO board = new BoardVO();
//	    board.setBno(1);
//	    board.setTitle("수정된 글입니다.");
//	    board.setContent("수정 테스트 ");
//	    dao.update(board);
//	  }
//
//	  @Test
//	  public void testDelete() throws Exception {
//
//	    dao.delete(1);
//	  }

}
