package kr.ac.kopo.kopo08.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.ac.kopo.kopo08.domain.Board;
import kr.ac.kopo.kopo08.domain.BoardItem;

@SpringBootTest
public class BoardItemRepositoryTest {
    @Autowired
    private BoardItemRepository boardItemRepository;
    
    @Autowired
    private BoardRepository boardRepository;
    
    //@Test
    void createOnlyBoard() {
        Board board1 = new Board();
        board1.setTitle("test");
        
        boardRepository.save(board1);
    }
    
//    @Test
    void createBoardAndChild() {
        Board board1 = new Board();
        board1.setTitle("test");
        
        BoardItem boardItem1 = new BoardItem();
        boardItem1.setTitle("boardItem1");
        boardItem1.setBoard(board1);
        
        BoardItem boardItem2 = new BoardItem();
        boardItem2.setTitle("boardItem2");
        boardItem2.setBoard(board1);
        
        List<BoardItem> list = new ArrayList<>();
        list.add(boardItem1);
        list.add(boardItem2);
        
        board1.setBoardItems(list);
        
        
        boardRepository.save(board1);
    }

//    @Test
    void selectOne2() {
        //child가 있는 경우
        //없는 경우 Board fetch Lazy로 변경 -> 질문: eager와 lazy 중 어떤 것이 현재 만들고 있는 게시판 로직에 더 적합할까
        Optional<Board> board = boardRepository.findById(5L);
        List<BoardItem> boardItems = board.get()
                                    .getBoardItems();
        for (BoardItem boardItem : boardItems) {
            System.out.println(board.get().getId() + " : " + boardItem.getTitle());
        }
    }
    
    
//    @Test
    void selectOneBoardItem() {
        Optional<BoardItem> boardItemOp = boardItemRepository.findById(1L);
        BoardItem boardItem = boardItemOp.get();
        System.out.println(boardItem.getBoard());
    }
    
    @Test
    void delete() {
        boardRepository.deleteById(5L);
    }
}
