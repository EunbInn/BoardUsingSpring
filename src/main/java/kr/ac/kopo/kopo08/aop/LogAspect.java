package kr.ac.kopo.kopo08.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);
    
    @Before("execution(* kr.ac.kopo.kopo08.service.*.*Aop(..))")
    public void onBeforeHandler(JoinPoint joinPoint) {
       logger.info("=====================oneBeforeThing");
    }
    
    @After(("execution(* kr.ac.kopo.kopo08.service.*.*Aop(..))"))
    public void onAfterHandler(JoinPoint joinPointer) {
       logger.info("==================== onAfterHandler"); 
    }
    
    @AfterReturning(pointcut = "execution(* kr.ac.kopo.kopo08.service.*.*Aop(..))", returning = "str")
    public void onAfterRetuningHandler(JoinPoint joinPoint, Object str) {
        logger.info("@AterReturning : " + str);
        logger.info("===================== onAfterHandler");;
    }
    
    @Pointcut("execution(* kr.ac.kopo.kopo08.service.*.*Aop(..))")
    public void onPointcut(JoinPoint joinPoint, Object str) {
        logger.info("=========================onPointCut");;
    }
}
