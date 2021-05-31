package Sorting;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

public class MainApp {
    static WeldContainer container;
    public static void main(String[] args) {
        container = new Weld().initialize();
        AlgorithmRunner algorithmRunner = container.select(AlgorithmRunner.class).get();
        algorithmRunner.runAlgorithms();
    }

    @Produces
    public @Named("HighClass")
    SortingAlgorithm<Integer> quadratic() {
        return container.select(BubbleSort.class).get();
    }
    @Produces
    public @Named("LowClass")
    SortingAlgorithm <Integer> nlogn() {
        return container.select(QuickSort.class).get();
    }
    @Produces
    public @Num int getNumOfSizeArray() {
        return 10000;
    }
}
