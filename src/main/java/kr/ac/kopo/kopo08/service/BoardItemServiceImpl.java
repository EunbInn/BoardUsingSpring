package kr.ac.kopo.kopo08.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.kopo08.domain.BoardItem;
import kr.ac.kopo.kopo08.repository.BoardItemRepository;

@Service
public class BoardItemServiceImpl{
	// implements BoardItemService
	@Autowired
	private BoardItemRepository boardItemRepository;

	//@Override
	public Long getNewID() {
		List<BoardItem> boardItemList = boardItemRepository.findAll();
		Long newID = 0L;
		BoardItem boardItem = boardItemList.get(0);
		newID = boardItem.getId();
		
		return newID;
	}

	//@Override
	public List<BoardItem> selectChoice(Long id, String find, String findType) {
		find = find.trim();
		if (find.equals("")) {
			return boardItemRepository.findAll();
		}
		find = find.replaceAll(">", "&gt;");
		find = find.replaceAll("<", "&lt;");
		List<BoardItem> select = new ArrayList<BoardItem>();
//		List<BoardItem> itemList = boardItemRepository.findAllById(id);
//		for (BoardItem boardItem :  itemList) {
//			if (boardItem.getTitle().contains(find) && findType.equals("title")) {
//				select.add(boardItem);
//			} else if (boardItem.getWriter().contains(find) && findType.equals("writer")) {
//				select.add(boardItem);
//			} else if ((boardItem.getWriter().contains(find) || boardItem.getTitle().contains(find)) && findType.equals("title+writer")) {
//				select.add(boardItem);
//			}
//		}
		return select;
	}
}
