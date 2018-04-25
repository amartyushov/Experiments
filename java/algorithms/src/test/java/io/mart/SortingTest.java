package io.mart;

import io.github.sskorol.core.DataSupplier;
import io.mart.sort.BubbleSort;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SortingTest {

    private Class classWithAlg = BubbleSort.class;
    private String methodName = "bubbleSortMyOptimised";
    private Method method = null;

    @BeforeClass
    public void setup() throws NoSuchMethodException {
        method = classWithAlg.getMethod(methodName,Integer[].class);
    }

    @DataSupplier
    public Stream<Pair> getData() {
        return Stream.of(
                new Pair(new Integer[]{},new Integer[]{}),
                new Pair(new Integer[]{4,3,2,1},new Integer[]{1,2,3,4}),
                new Pair(new Integer[]{4,2,3,1},new Integer[]{1,2,3,4}),
                new Pair(new Integer[]{1},new Integer[]{1}),
                new Pair(new Integer[]{1,1,1,1},new Integer[]{1,1,1,1}),
                new Pair(new Integer[]{4,-1,0,3,10},new Integer[]{-1,0,3,4,10}),
                new Pair(new Integer[]{1,2},new Integer[]{1,2}),
                new Pair(new Integer[]{4,1,5,6,7,3,2,3,1},new Integer[]{1,1,2,3,3,4,5,6,7}),
                new Pair(new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20},new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20}));
    }

    @Test(dataProvider = "getData")
    public void smallUnsorted(final Pair pair) {
        Integer[] sorted = sort(pair.getUnsorted());
        assertEquals(pair.getSorted(),sorted,"Algorithm returned " + Arrays.toString(sorted));
    }

    private Integer[] sort(Integer[] array) {
        try {
            return (Integer[]) method.invoke(
                    classWithAlg.newInstance(),
                    new Object[]{array});
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
