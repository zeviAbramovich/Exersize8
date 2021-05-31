package Sorting;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Logging {

    long timeStart;
    long timeFinish;

    @Pointcut("execution(void SortingAlgorithm.sort(..))")
    private void selectSort(){}

    @Before("selectSort()")
    public void beforeSort(JoinPoint jp) throws Throwable{
        System.out.println("Running sort in " + jp.getThis().getClass().getName()
                + " with array size ");
        timeStart = System.currentTimeMillis();
    }

    @After("selectSort()")
    public void afterSort(JoinPoint jp) throws Throwable{
        timeFinish = System.currentTimeMillis() - timeStart;
        System.out.println("Function sort in " + jp.getThis().getClass().getName()
                + " took " + timeFinish +" ms");
    }

}
