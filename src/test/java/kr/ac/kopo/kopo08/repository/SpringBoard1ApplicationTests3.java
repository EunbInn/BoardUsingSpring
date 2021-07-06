package kr.ac.kopo.kopo08.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBoard1ApplicationTests3 {
	
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
	void findAll() {
		//샘플의 데이터 행 사이즈와 같은지 비교하는 내용
		assertEquals(5, sampleRepository.findAll().size()); //테스트 자동화를 위한 친구^_^
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
