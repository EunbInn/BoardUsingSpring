package kr.ac.kopo.kopo08.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo.kopo08.domain.Sample;
import kr.ac.kopo.kopo08.repository.SampleRepository;
import kr.ac.kopo.kopo08.service.SampleService;

@Controller
public class SampleController {
    
    private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	@Autowired
	private SampleRepository sampleRepository;
	
	@Autowired
    private SampleService sampleService;
	
	@RequestMapping(value = "/sample/noAop")
	@ResponseBody
	public String noAop() {
	    return sampleService.test();
	}
	
	@RequestMapping(value = "/sample/aop")
    @ResponseBody
    public String aop() {
        return sampleService.testAop();
    }
	
	@RequestMapping(value = "/sample/noTransactional")
    @ResponseBody
    public String noTransactional() {
        return sampleService.testNoTransactional();
    }
    
    @RequestMapping(value = "/sample/transactional")
    @ResponseBody
    public String transactional() {
        return sampleService.testTransactional();
    }
	
	@RequestMapping(value = "/sample/list")
	@ResponseBody
	public List<Sample> list(Model model) {
		return sampleRepository.findAll();
	}
	
	@RequestMapping(value = "/sample/pageable")
	@ResponseBody
	public List<Sample> pageable(Model model) {
		PageRequest pageable = PageRequest.of(0, 2);
		Page<Sample> page = sampleRepository.findAll(pageable);

		return page.getContent();
	}
}
