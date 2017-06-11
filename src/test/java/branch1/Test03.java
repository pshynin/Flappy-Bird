package branch1;

import org.junit.Test;

/**
 * Created by pshynin on 6/10/2017.
 */
public class Test03 {

    public final int value = 4;

    public void doIt() {
        int value = 6;
        Runnable r = new Runnable() {
            public final int value = 5;

            public void run() {
                int value = 10;
                System.out.println(this.value);
            }
        };
        r.run();
    }

    public static void main(String... args) {
        Test03 m = new Test03();
        m.doIt(); // - What's the output of this line
    }
}
