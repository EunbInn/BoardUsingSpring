package kr.ac.kopo.kopo08.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.kopo08.domain.BoardItem;

@Repository
public interface BoardItemRepository extends JpaRepository<BoardItem, Long>,JpaSpecificationExecutor<BoardItem>{
    
    Page<BoardItem> findAllByTitle(String title, Pageable pageable);
    
    List<BoardItem> findAllByTitle(String title);
    
    Optional<BoardItem> findById(Long id);
    
    List<BoardItem> findAllByBoardId(Long boardId, Sort sort);
    
    List<BoardItem> findAllByParent(Long id, Sort sort);
    
    List<BoardItem> findAll();
    List<BoardItem> findAllByOrderByIdDesc();
}
