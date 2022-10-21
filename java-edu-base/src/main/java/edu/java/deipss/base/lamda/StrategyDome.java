package edu.java.deipss.base.lamda;

import javax.annotation.Nonnull;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

@FunctionalInterface
interface StringProcess {
     String process(String s);
}

@FunctionalInterface
interface StrategyProcess {
    default Optional handle(String s){
        throw  new UnsupportedOperationException();
    }
    boolean process(String S);
}



public class StrategyDome {




    static String readLine(StringProcess sp,@Nonnull String s) {
        return sp.process(s);
    }

    static boolean strategy(StrategyProcess f, String s) {
        return f.process(s);
    }

    public static void main(String[] args) {




    }


    public static void iteratorDemo(){
        IntStream.iterate(0, n -> n + 2).limit(10).forEach(System.out::print);
        System.out.println();
        DoubleStream.generate(Math::random).limit(6).forEach(System.out::print);
    }

    public static void functionDemo(){
        String rst = readLine(s -> s + "Done", "123");
        System.out.println(rst);

        System.out.println(strategy(s-> s.equals("abc"),"anc"));
        System.out.println(strategy(s-> s.equals("anc"),"anc"));

        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.andThen(g);
        int result = h.apply(1);
        System.out.println(result);
    }

}
