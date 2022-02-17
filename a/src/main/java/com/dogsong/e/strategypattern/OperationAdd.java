package com.dogsong.e.strategypattern;

/**
 * add
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/2/17
 */
public class OperationAdd implements Strategy{

    @Override
    public int doOperation(int a, int b) {
        return a + b;
    }
}
