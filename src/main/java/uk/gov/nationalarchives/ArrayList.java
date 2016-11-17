package uk.gov.nationalarchives;

import org.openjdk.jmh.annotations.*;

import java.util.List;

/**
 * Created by rhubner on 17/11/16.
 */

public class ArrayList {

    @Benchmark
    public long testIteratorAccess(StateDate data) {
        long l = 0;
        for(MyObject o : data.myObject) {
            l += o.calculate();
        }
        return l;
    }

    @Benchmark
    public long testIndexAccess(StateDate data) {
        int maxItems = data.myObject.size();

        long l = 0;

        for(int i = 0; i < maxItems ; i++) {
            MyObject o = data.myObject.get(i);
            l += o.calculate();
        }

        return l;

    }


    @State(Scope.Benchmark)
    public static class StateDate {

        private List<MyObject> myObject = new java.util.ArrayList<>(LIST_SIZE + 10);

        private static final int LIST_SIZE = 10_000;

        @Setup(Level.Invocation)
        public void prepareData() {
            myObject.clear();
            for(int i = 0; i < LIST_SIZE; i++) {
                myObject.add(new MyObject(i, i*3));
            }
        }
    }

}
