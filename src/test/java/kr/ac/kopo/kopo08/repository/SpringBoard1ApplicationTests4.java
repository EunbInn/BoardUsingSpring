package kr.ac.kopo.kopo08.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import kr.ac.kopo.kopo08.domain.Sample;
import kr.ac.kopo.kopo08.repository.mapper.SampleCondition;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBoard1ApplicationTests4 {
	
	@Autowired
	private SampleRepository sampleRepository;
	
	@Before
	public void before() {
		System.out.println("before");
	}
	
	@After
	public void after() {
		System.out.println("after");
	}

	@Test
	void haveChild() {
		assertEquals(5, sampleRepository.count());
	}
	
	@Test
	void equalTest() {
		assertEquals("a", "a");
	}
	
	@Test
	void notEqualTest() {
		assertEquals("a", "b");
	}
	

}
