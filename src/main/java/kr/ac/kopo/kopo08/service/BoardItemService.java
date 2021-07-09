package kr.ac.kopo.kopo08.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import kr.ac.kopo.kopo08.domain.BoardItem;
import kr.ac.kopo.kopo08.repository.BoardItemRepository;
import kr.ac.kopo.kopo08.repository.BoardItemSpecs;

@Service
public class BoardItemService {
    
    @Autowired
    private BoardItemRepository boardItemRepository;
	
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
	
	public Page<BoardItem> showBoardItems(Page<BoardItem> boardItems) {
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
	
	public Page<BoardItem> search(String value, String keyType, Pageable pageable) {
	    Map<String, Object> filter = new HashMap<String, Object>();
	    Map<String, Object> filter2 = new HashMap<String, Object>();
	    Page<BoardItem> page;
	    
	    if (keyType.equals("title")) {
	        filter.put("title", value);
	        page = boardItemRepository.findAll(BoardItemSpecs.searchTitle(filter), pageable);
	    } else if(keyType.equals("writer")) {
	        filter.put("writer",value);
	        page = boardItemRepository.findAll(BoardItemSpecs.searchTitle(filter), pageable);
	    } else {
	        filter.put("title", value);
	        filter2.put("writer",value);
	        page = boardItemRepository.findAll(BoardItemSpecs.searchTitle(filter).or(BoardItemSpecs.searchWriter(filter2)), pageable);
	    }
	    
        for (BoardItem boardItem : page) {
            System.out.println(boardItem.getTitle() + " && " + boardItem.getWriter());
        }
        return page;
    }

    public List<BoardItem> showBoardItems(List<BoardItem> comments) {
        for(BoardItem boardItem : comments) {
            boardItem.setContent(boardItem.getContent()
                                        .replaceAll(">", "&gt;")
                                        .replaceAll("<", "&lt;")
                                        .replaceAll("\n", "<br>")
                                        .replaceAll(" ", "&nbsp;"));
        }
        return comments; 
    }
}
