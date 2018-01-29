package com.kanapa.beatbob.helloworld;

/**
 * Created by lm-go on 29.12.2016.
 */

public class OperationManager {

    private static OperationManager om = new OperationManager();

    public static OperationManager getManager() {
        return om;

    }

    public Operation getOperation(int id) {
        for (Operation o: Operation.operations) {
            if (o.getId() == id) {
                return o;
            }
        }
        return null;
    }

}
