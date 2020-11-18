package ru.jegensomme.erlangformulas;

import java.util.function.BiFunction;
import java.util.stream.Stream;

/**
 * Class with utils to research Erlang formulas
 */
public class Researcher {

    private final Stream<Double> prepared;

    private Researcher(Stream<Double> prepared) {
        this.prepared = prepared;
    }

    /**
     * prepare stream of x
     * @param minX - left border of x
     * @param maxX - right border of x
     * @param interval - interval between values
     * @return Researcher with prepared stream of x
     */
    public static final Researcher prepare(int minX, int maxX, int interval) {
        return new Researcher(Stream.iterate(minX, n -> n + interval).
                limit((maxX-minX)/interval + 1).map(x -> (double) x));
    }

    /**
     * prepare stream of x
     * @see Researcher#prepare(int, int, int) 
     */
    public static final Researcher prepare(int minX, int maxX, double interval) {
        return new Researcher(Stream.iterate(0, n -> n + 1).
                limit((int)((maxX-minX)/interval + 1)).map(n -> minX + n*interval));
    }

    /**
     *
     * @param fixParameter fixed parameter in dependency
     * @param function on of erlang formulas
     * @see ErlangFormulas
     * @return stream of y
     */
    public final Stream<Double> result(int fixParameter, BiFunction<Double, Integer, Double> function) {
        return prepared.map(x -> function.apply(x, fixParameter));
    }

}
