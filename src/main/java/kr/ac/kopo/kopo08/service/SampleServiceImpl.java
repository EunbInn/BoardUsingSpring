package kr.ac.kopo.kopo08.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.kopo08.domain.Sample;
import kr.ac.kopo.kopo08.repository.SampleRepository;

@Service
public class SampleServiceImpl implements SampleService{

    private static final Logger logger = LoggerFactory.getLogger(SampleServiceImpl.class);
    @Autowired
    private SampleRepository sampleRepository;
    
    @Override
    public String test() {
        String msg = "Hello, Spring Boot No Aop";
        logger.info(msg);
        return msg;
    }

    @Override
    public String testAop() {
        String msg = "Hello, Spring Boot Aop";
        logger.info(msg);
        return msg;
    }

    @Override
    public String testNoTransactional() {
        Sample sample = sampleRepository.findById(1L).get();
        sample.setTitle("Update1");
        sampleRepository.save(sample);
        throw new RuntimeException("Spring Boot No Transactional Test");
    }

    @Override
    public String testTransactional() {
        Sample sample = sampleRepository.findById(1L).get();
        sample.setTitle("Update1");
        sampleRepository.save(sample);
        throw new RuntimeException("Spring Boot Transactional Test");
    }
    
}
