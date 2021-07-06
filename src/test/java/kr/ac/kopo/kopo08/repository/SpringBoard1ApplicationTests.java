package kr.ac.kopo.kopo08.repository;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import kr.ac.kopo.kopo08.domain.Sample;

@SpringBootTest
class SpringBoard1ApplicationTests {
	
	@Autowired
	private SampleRepository sampleRepository;

	@Test
	void contextLoads() {
		Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("title", "hello");
		
		PageRequest pageable = PageRequest.of(0, 2);
		Page<Sample> page = sampleRepository.findAll(SampleSpecs.search(filter), pageable);
		System.out.print("here title: ");
		for (Sample sample : page) {
			System.out.println(sample.getTitle());
		}
	}

}
