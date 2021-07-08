package kr.ac.kopo.kopo08.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.kopo08.domain.BoardItem;
import kr.ac.kopo.kopo08.repository.BoardItemRepository;

@Service
public class BoardItemService {
    
    @Autowired
    private BoardItemRepository boardItemRepository;
    
	public Long getNewID() {
        return null;
	    
	}
	
	public List<BoardItem> selectChoice(Long id, String find, String findType){
        return null;
	    
	}
	
	public BoardItem showBoardItem(BoardItem boardItem) {
	    boardItem.setTitle(boardItem.getTitle()
                                    .replaceAll(">", "&gt;")
                                    .replaceAll("<", "&lt;")
                                    .replaceAll("\n", "<br>")
                                    .replaceAll(" ", "&nbsp;"));
	    
	    boardItem.setContent(boardItem.getContent()
                                    .replaceAll(">", "&gt;")
                                    .replaceAll("<", "&lt;")
                                    .replaceAll("\n", "<br>")
                                    .replaceAll(" ", "&nbsp;"));
        return boardItem; 
	}
	
	public List<BoardItem> showBoardItems(List<BoardItem> boardItems) {
	    for(BoardItem boardItem : boardItems) {
	        if (boardItem.getTitle() != null) {
                boardItem.setTitle(boardItem.getTitle()
                                            .replaceAll(">", "&gt;")
                                            .replaceAll("<", "&lt;")
                                            .replaceAll("\n", "<br>")
                                            .replaceAll(" ", "&nbsp;"));
	        }
            
            boardItem.setContent(boardItem.getContent()
                                        .replaceAll(">", "&gt;")
                                        .replaceAll("<", "&lt;")
                                        .replaceAll("\n", "<br>")
                                        .replaceAll(" ", "&nbsp;"));
	    }
        return boardItems; 
    }
}
