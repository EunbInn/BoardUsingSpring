package kr.ac.kopo.kopo08.web;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.kopo.kopo08.domain.Board;
import kr.ac.kopo.kopo08.domain.BoardItem;
import kr.ac.kopo.kopo08.repository.BoardItemRepository;
import kr.ac.kopo.kopo08.service.BoardItemService;

@Controller
public class BoardItemController {

    @Autowired
    private BoardItemRepository boardItemRepository;

    @Autowired
    private BoardItemService boardItemService;

    @RequestMapping(value = "/oneView/{boardId}/{id}/{page}", method = { RequestMethod.GET, RequestMethod.POST })
    public String findOneBoardItem(@PathVariable(name = "boardId") Long boardId, 
                                    @PathVariable(name = "id") Long id,
                                    @PathVariable(name = "page") int page,
                                    Model model) {
        Optional<BoardItem> boardItemOp = boardItemRepository.findById(id);
        BoardItem boardItem = boardItemOp.get();
        boardItem = boardItemService.showBoardItem(boardItem);

        // comments 가져오기
        List<BoardItem> comments = boardItemRepository.findAllByParent(id, Sort.by(Sort.Direction.DESC, "id"));
        comments = boardItemService.showBoardItems(comments);
        
        // 뒤로가기에서 목록으로 돌아가기 위해 boardid를 파라미터로 넘김
        model.addAttribute("boardId", boardId);
        model.addAttribute("boardItem", boardItem);
        model.addAttribute("comments", comments);
        model.addAttribute("page", page);

        return "/newBoard/oneView";
    }

    @RequestMapping(value = "/write/write01/{boardId}", method = { RequestMethod.GET, RequestMethod.POST })
    public String write(@PathVariable(name = "boardId") Long boardId, Model model) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 뒤로가기에서 목록으로 돌아가기 위해 boardid를 파라미터로 넘김
        model.addAttribute("date", sdf.format(cal.getTime()));
        model.addAttribute("boardId", boardId);

        return "/newBoard/write/write01";
    }
    
    @RequestMapping(value = "/write/update01/{boardId}/{id}", method = { RequestMethod.GET, RequestMethod.POST })
    public String update(@PathVariable(name = "boardId") Long boardId, 
                        @PathVariable(name = "id") Long id, 
                        Model model) {
        Optional<BoardItem> boardItemOp = boardItemRepository.findById(id);
        BoardItem boardItem = boardItemOp.get();
        
        // 뒤로가기에서 목록으로 돌아가기 위해 boardid를 파라미터로 넘김
        model.addAttribute("boardItem", boardItem);
        model.addAttribute("boardId", boardId);

        return "/newBoard/write/update01";
    }
    
    @RequestMapping(value = "/write/delete02/{boardId}/{page}", method = { RequestMethod.GET, RequestMethod.POST })
    public String delete(@PathVariable(name = "boardId") Long boardId, 
                        @PathVariable(name = "page") Long page, 
                        Model model) {
       
        model.addAttribute("boardId", boardId);
        model.addAttribute("page", page);

        return "/newBoard/write/delete02";
    }

    @RequestMapping(value = "/write/{type}/{boardId}/{id}/{page}", method = { RequestMethod.GET, RequestMethod.POST })
    public String Insert(@PathVariable(name = "boardId") Long boardId, 
                        @PathVariable(name = "type") String type,
                        @PathVariable(name = "id") Long id,
                        @ModelAttribute BoardItem boardItem, 
                        Model model) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Board board = new Board(boardId);
        boardItem.setBoard(board);
        //data set
        if (type.equals("write02")) {
            boardItem.setDate(sdf.format(cal.getTime()));
            
            if (id != 0) {
                boardItem.setParent(id);
                boardItem.setId(null);
                boardItem.setTitle(boardItem.getTitle());
                
                boardItemRepository.save(boardItem);
            } else {
                boardItemRepository.save(boardItem);
                
                List<BoardItem> boardItems = boardItemRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
                boardItem = boardItems.get(0);
                id = boardItem.getId();
            }

        } else if (type.equals("update02")) {
            boardItemRepository.save(boardItem);
        } else if (type.equals("delete01")) {
            boardItemRepository.deleteById(id, id);
            return "redirect:/write/delete02/" + boardId;
        }

        return "redirect:/oneView/" + boardId + "/" + id + "/";
    }

}
