package kr.ac.kopo.kopo08.service;

public interface SampleService {
    //aop
    String test();
    String testAop();
    
    //transactional
    String testNoTransactional();
    String testTransactional();
    
}
