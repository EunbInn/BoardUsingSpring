package kr.ac.kopo.kopo08.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping(value = "/oneBoard", method= {RequestMethod.GET, RequestMethod.POST})
    public String findOneBoard(@RequestParam(name="boardId") Long boardId,
                                @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                                @RequestParam(required=false, name="keyType") String keyType,
                                @RequestParam(required=false, defaultValue="") String value,
                                Model model) {
        // 보드 가져오기
        Optional<Board> board = boardRepository.findById(boardId);
        Board getBoard = board.get();
        getBoard = boardService.showBoard(getBoard);
        Page<BoardItem> boardItems;
        
        if (value.equals("")) {
            boardItems = boardItemRepository.findAllByBoardId(boardId, pageable);
            boardItems = boardItemService.showBoardItems(boardItems);
        } else {
            boardItems = boardItemService.search(value, keyType, pageable);
            boardItems = boardItemService.showBoardItems(boardItems);
        }
        
        int currentPage = boardItems.getPageable().getPageNumber();
        int startPage = (currentPage / 10) * 10 + 1;
        int endPage = startPage + 9;
        if (endPage > boardItems.getTotalPages()) {
            endPage = boardItems.getTotalPages();
        }
        
        Long totalContent = boardItems.getTotalElements();
        Long nowStartContentNumber = totalContent - (currentPage * 10);
        model.addAttribute("board", getBoard);
        model.addAttribute("boardItems", boardItems);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("startNumber", nowStartContentNumber);
        model.addAttribute("keyType", keyType);
        model.addAttribute("value", value);
        model.addAttribute("page", currentPage);
        model.addAttribute("boardId", boardId);
        
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
