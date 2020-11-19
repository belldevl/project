package org.zerock.mapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {org.zerock.config.RootConfig.class})
@Log4j
public class BoardMapperTests {

    @Setter(onMethod_ = @Autowired)
    private BoardMapper mapper;

   /* @Test
    public void testGetList() {
        mapper.getList().forEach(board -> log.info(board));
    }

    @Test
    public void testInsert() {

        BoardVO board = new BoardVO();

        board.setTitle("새로 작성하는 글");
        board.setContent("새로 작성하는 내용");
        board.setWriter("newbie");

        mapper.insert(board);

        log.info(board);
    }

    @Test
    public void get(){
        BoardVO board = new BoardVO();

       mapper.getList();

       log.info(board);
    }


    @Test
    public void testInsertSelectKey() {

        BoardVO board = new BoardVO();

        board.setTitle("새로 작성하는 글 select Key");
        board.setContent("새로 작성하는 내용 select Key");
        board.setWriter("newbie");

        mapper.insertSelectKey(board);

        log.info(board);
    }

    @Test
    public void testRead(){

        BoardVO board = mapper.read(12L);

        log.info(board);
    }

    @Test
    public void testPaging(){

        Criteria cri = new Criteria();

        cri.setPageNum(3);
        cri.setAmount(10);

        List<BoardVO> list = mapper.getListWithPaging(cri);
        list.forEach(board -> log.info(board.getBno()));
    }*/

    @Test
    public void insertTest(){
        for (int i = 1; i <= 3000; i++){
            BoardVO vo = new BoardVO();
            vo.setTitle(i+"번째 테스트 게시물");
            vo.setContent(i+"번째 게시물 내용입니다");
            vo.setWriter("user" +i);
            mapper.insert(vo);
            log.info(mapper);
        }
    }
}
