package com.shilko.ru.labmilndifferentiation;

import java.util.function.BiFunction;

public class NamingBiFunction {

    private BiFunction function;
    private String alias;

    public NamingBiFunction(BiFunction function, String alias) {
        this.function = function;
        this.alias = alias;
    }

    public BiFunction getFunction() {
        return function;
    }

    public String getAlias() {
        return alias;
    }
}
