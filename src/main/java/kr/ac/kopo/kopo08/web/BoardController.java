package kr.ac.kopo.kopo08.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.kopo.kopo08.domain.Board;
import kr.ac.kopo.kopo08.domain.BoardItem;
import kr.ac.kopo.kopo08.repository.BoardItemRepository;
import kr.ac.kopo.kopo08.repository.BoardRepository;
import kr.ac.kopo.kopo08.service.BoardItemService;

@Controller
public class BoardController {
    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private BoardItemRepository boardItemRepository;

    @Autowired
    private BoardItemService boardItemService;

    @RequestMapping(value = "/")
    public String boardList(Model model) {
        List<Board> boardList = boardRepository.findAll();
        model.addAttribute("boardList", boardList);

        return "index";
    }

    @RequestMapping(value = "/oneBoard/{boardId}", method=RequestMethod.GET)
    public String findOneBoard(@PathVariable(name = "boardId") Long boardId, Model model) {
        // 보드 가져오기
        Optional<Board> board = boardRepository.findById(boardId);
        Board getBoard = board.get();
        List<BoardItem> boardItemsRaw = boardItemRepository.findAllByBoardId(boardId , Sort.by(Sort.Direction.DESC, "id"));
        List<BoardItem> boardItems = new ArrayList<>();
        for (BoardItem boardItem : boardItemsRaw) {
            if (boardItem.getParent() == null) {
                boardItems.add(boardItem);
            }
        }

        model.addAttribute("board", getBoard);
        model.addAttribute("boardItems", boardItems);
        
        return "/newBoard/oneBoard";
    }

    @RequestMapping(value = "/newBoard01/{boardId}/", method = { RequestMethod.GET, RequestMethod.POST })
    public String create() {

        return "redirect:/newBoard/oneBoard";

    }
}
