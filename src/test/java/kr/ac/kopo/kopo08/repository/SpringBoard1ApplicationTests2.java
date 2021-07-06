package kr.ac.kopo.kopo08.repository;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.ac.kopo.kopo08.domain.Sample;
import kr.ac.kopo.kopo08.repository.mapper.SampleCondition;
import kr.ac.kopo.kopo08.repository.mapper.SampleMapper;

@SpringBootTest
class SpringBoard1ApplicationTests2 {
	
	private static final Logger logger = LoggerFactory.getLogger(SpringBoard1ApplicationTests2.class);
	
	@Autowired
	private SampleMapper sampleMapper;

//	@Test
//	void contextLoads() {
//		List<Sample> samples = sampleMapper.findAll();
//		for (Sample sample: samples) {
//			logger.info(sample.getTitle());
//		}
//	}
	
	@Test
	public void findAllByCondition() {
		SampleCondition sampleCondition = new SampleCondition();
		sampleCondition.setTitle("hi");
		
		RowBounds rowBounds = new RowBounds(0, 10);

		List<Sample> samples = sampleMapper.findAllByCondition(sampleCondition, rowBounds);
		for (Sample sample : samples) {
			logger.info(sample.getTitle());
		}
	}
	

}
