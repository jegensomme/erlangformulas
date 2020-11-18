package ru.jegensomme.erlangformulas;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Double> result;

        System.out.println("Исследование зависимости вероятности блокировки заявок" +
                " от интенсивности поступающей нагрузки при числе обслуживающих устройств 30");
        result = Researcher.prepare(0, 200, 10).
                result(30, ErlangFormulas::pByErlang1).
                collect(Collectors.toList());
        for (int i = 0; i < result.size(); i++) {
            System.out.printf("(%s;%s) ", i*10, result.get(i));
        }

        System.out.println("\nИсследование зависимости вероятности блокировки заявок" +
                " от числа обслуживающих устройств при интенсивности поступающей нагрузки 15");
        result = Researcher.prepare(0, 25, 1).
                result(15, ErlangFormulas::pByErlang1).
                collect(Collectors.toList());
        for (int i = 0; i < result.size(); i++) {
            System.out.printf("(%s;%s) ", i, result.get(i));
        }

        System.out.println("\nИсследование зависимости вероятности ожидания начала обслуживания" +
                " от интенсивности поступающей нагрузки при числе обслуживающих устройств 30");
        result = Researcher.prepare(0, 29, 0.5).
                result(30, ErlangFormulas::pByErlang2).
                collect(Collectors.toList());
        for (int i = 0; i < result.size(); i++) {
            System.out.printf("(%s;%s) ", i*0.5, result.get(i));
        }

        System.out.println("\nИсследование зависимости средней длины очереди" +
                " от интенсивности поступающей нагрузки при числе обслуживающих устройств 30");
        result = Researcher.prepare(0, 25, 0.5).
                result(30, ErlangFormulas::avgQueueLength).
                collect(Collectors.toList());
        for (int i = 0; i < result.size(); i++) {
            System.out.printf("(%s;%s) ", i*0.5, result.get(i));
        }

        System.out.println("\nИсследование зависимости вероятности ожидания начала обслуживания" +
                " от числа обслуживающих устройств при интенсивности поступающей нагрузки 15");
        result = Researcher.prepare(0, 15, 0.5).
                result(15, ErlangFormulas::pByErlang2).
                collect(Collectors.toList());
        for (int i = 0; i < result.size(); i++) {
            System.out.printf("(%s;%s) ", i*0.5, result.get(i));
        }

        System.out.println("\nзависимости средней длины очереди" +
                " от числа обслуживающих устройств при интенсивности поступающей нагрузки 15");
        result = Researcher.prepare(0, 12, 0.5).
                result(15, ErlangFormulas::avgQueueLength).
                collect(Collectors.toList());
        for (int i = 0; i < result.size(); i++) {
            System.out.printf("(%s;%s) ", i*0.5, result.get(i));
        }
    }
}
