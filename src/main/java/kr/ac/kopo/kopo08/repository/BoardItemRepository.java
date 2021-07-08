package kr.ac.kopo.kopo08.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.kopo08.domain.BoardItem;

@Repository
public interface BoardItemRepository extends JpaRepository<BoardItem, Long>,JpaSpecificationExecutor<BoardItem>{
    
    Page<BoardItem> findAllByTitle(String title, Pageable pageable);
    
    List<BoardItem> findAllByTitle(String title);
    
    Optional<BoardItem> findById(Long id);
    
    @Query("SELECT t FROM BoardItem t WHERE t.board.id = :boardId AND t.parent is null ORDER BY t.id DESC")
    List<BoardItem> findAllByBoardId(@Param("boardId") Long boardId);
    
    List<BoardItem> findAllByParent(Long id, Sort sort);
    
    @Transactional
    @Modifying
    @Query("DELETE FROM BoardItem t WHERE t.id = :id OR t.parent = :parent")
    void deleteById(@Param("id") Long id, @Param("parent") Long parent);
    
    List<BoardItem> findAll();
    List<BoardItem> findAllByOrderByIdDesc();
}
