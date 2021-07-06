package kr.ac.kopo.kopo08.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.kopo08.domain.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long>, JpaSpecificationExecutor<Board>{
	Optional<Board> findById(Long id);
	
	Page<Board> findAllByTitle(String title, Pageable pageable);
	
	List<Board> findAllByTitle(String title);
	
	void deleteById(Long id);
	
//	@Query("select b from board b where title=:title and id <: id")
//	List<Board> findByTitleAndLessThanSQL(@Param("title") String title, @Param("id") Long id);
}
