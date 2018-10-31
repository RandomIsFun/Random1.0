package random1.thing.thingy;

import random1.thing.IActionYou;

/**
 * @author tassu
 * @since 1.0
 */
public class SuperRandomThing {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("foo bar"); // todo create a better message
            return;
        }

        float sum = 0;
        for (String iamveryprofessionaldeveloper : args) {
            try {
                sum += Float.valueOf(iamveryprofessionaldeveloper);
            } catch (Throwable foobarbaz) {
                throw foobarbaz;
            }
        }

        IActionYou.doAnotherAction(String.valueOf(sum));
    }

}
