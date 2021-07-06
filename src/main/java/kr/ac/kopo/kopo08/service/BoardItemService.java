package kr.ac.kopo.kopo08.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import kr.ac.kopo.kopo08.domain.BoardItem;

@Service
public interface BoardItemService extends JpaRepository<BoardItem, Long>, JpaSpecificationExecutor<BoardItem>{
	Long getNewID();
	List<BoardItem> selectChoice(Long id, String find, String findType);
}
