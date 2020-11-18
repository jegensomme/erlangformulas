package ru.jegensomme.erlangformulas;

/**
 * Class for calculating the probability of losing bids using the erlang formula
 * @author Vitovt Kublitsky
 */
public class ErlangFormulas {

    private ErlangFormulas() {
    }

    /**
     * Erlang first formula
     * @param a - the intensity of the incoming load
     * @param v - number of lines
     * @return - the probability of losing bids
     */
    public static final double pByErlang1(double a, int v) {
        return v == 0 ? 1 : a * pByErlang1(a, v-1)/(v+a*pByErlang1(a, v-1));
    }

    /**
     * Erlang second formula
     * @see ErlangFormulas#pByErlang1(double, int) 
     */
    public static final double pByErlang2(double a, int v) {
        double p = pByErlang1(a, v);
        return p/(1-((a/v)*(1-p)));
    }

    /**
     * Erlang formula for average queue length
     * @see ErlangFormulas#pByErlang1(double, int)
     */
    public static final double avgQueueLength(double a, int v) {
        double p = pByErlang1(a, v);
        return a*p*v/((v-a + a*p)*(v-a));
    }
}
