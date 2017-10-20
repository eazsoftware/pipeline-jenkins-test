package com.eaz.pipeline.jenkins.test;

import java.util.function.BiFunction;

/**
 *
 * @author javier
 */
public class Main {

    public static void main(String args[]) {
        System.out.println("pipeline-jenkins-test " + sum.apply(2, 3));
    }

    public static BiFunction<Integer, Integer, Integer> sum = (x, y) -> {
        return x + y;
    };
}
