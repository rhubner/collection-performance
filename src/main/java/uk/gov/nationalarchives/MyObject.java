package uk.gov.nationalarchives;

/**
 * Created by rhubner on 17/11/16.
 */
public final class MyObject {


        private final int a;
        private final int b;

        public MyObject(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int calculate() {
            return a + b;
        }



}
