package kr.ac.kopo.kopo08.repository;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import kr.ac.kopo.kopo08.domain.BoardItem;
import kr.ac.kopo.kopo08.domain.Sample;

@SpringBootTest
public class SpringBoard1ApplicationTests {
	
	@Autowired
	private SampleRepository sampleRepository;
	
	@Autowired
	private BoardItemRepository boardItemRepository;

	@Test
	void contextLoads() {
		Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("title", "test");
		
		Map<String, Object> filter2 = new HashMap<String, Object>();
        filter2.put("writer", "천좌");
		
		PageRequest pageable = PageRequest.of(0, 2);
		Page<BoardItem> page = boardItemRepository.findAll(BoardItemSpecs.searchTitle(filter).or(BoardItemSpecs.searchWriter(filter2)), pageable);
		System.out.print("here title: ");
		for (BoardItem boardItem : page) {
			System.out.println(boardItem.getTitle() + " && " + boardItem.getWriter());
		}
	}

}
