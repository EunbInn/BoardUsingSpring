package kr.ac.kopo.kopo08.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.kopo.kopo08.domain.Board;
import kr.ac.kopo.kopo08.domain.BoardItem;
import kr.ac.kopo.kopo08.repository.BoardItemRepository;
import kr.ac.kopo.kopo08.repository.BoardRepository;
import kr.ac.kopo.kopo08.service.BoardItemService;
import kr.ac.kopo.kopo08.service.BoardService;

@Controller
public class BoardController {
    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private BoardItemRepository boardItemRepository;

    @Autowired
    private BoardItemService boardItemService;
    
    @Autowired
    private BoardService boardService;

    @RequestMapping(value = "/")
    public String boardList(Model model) {
        List<Board> boardList = boardRepository.findAll();
        boardList = boardService.showBoards(boardList);
        
        model.addAttribute("boardList", boardList);

        return "index";
    }
    
    @RequestMapping(value = "/update01/{boardId}")
    public String makeBoard(@PathVariable(name = "boardId") Long boardId, Model model) {
        Optional<Board> boardOp = boardRepository.findById(boardId);
        Board board = boardOp.get();
        
        model.addAttribute("board", board);
        return "/updateBoard/update01";
    }

    @RequestMapping(value = "/oneBoard/{boardId}", method=RequestMethod.GET)
    public String findOneBoard(@PathVariable(name = "boardId") Long boardId, Model model) {
        // 보드 가져오기
        Optional<Board> board = boardRepository.findById(boardId);
        Board getBoard = board.get();
        getBoard = boardService.showBoard(getBoard);
        
        List<BoardItem> boardItems = boardItemRepository.findAllByBoardId(boardId);
        boardItems = boardItemService.showBoardItems(boardItems);

        model.addAttribute("board", getBoard);
        model.addAttribute("boardItems", boardItems);
        
        return "/newBoard/oneBoard";
    }

    @RequestMapping(value = "/{type}/{boardId}", method = { RequestMethod.GET, RequestMethod.POST })
    public String create(@PathVariable(name = "boardId") Long boardId,
                        @PathVariable(name = "type") String type,
                        @ModelAttribute Board board,
                        Model model) {
        if (type.equals("newBoard01") || type.equals("update02")) {
            boardRepository.save(board);
        } else if (type.equals("delete01")) {
            boardRepository.deleteById(boardId);
        }
        return "redirect:/";
    }
}
