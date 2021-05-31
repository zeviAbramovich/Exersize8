package Sorting;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Random;

public class AlgorithmRunner {
    @Inject
    @Named("HighClass") SortingAlgorithm<Integer> quadraticAlgorithm;
    @Inject
    @Named("LowClass")SortingAlgorithm<Integer> nlognAlgorithm;
    @Inject
    @Num int numberOfElements;
    public void runAlgorithms(){
        Random rand = new Random();
        Integer[] ints = rand.ints(1,Integer.MAX_VALUE)
                .distinct()
                .limit(numberOfElements)
                .boxed()
                .toArray(Integer[]::new);
        Integer[] intsClone = ints.clone();
        quadraticAlgorithm.sort(intsClone);
        intsClone = ints.clone();
        nlognAlgorithm.sort(intsClone);
    }
}
