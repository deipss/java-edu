package edu.java.deipss.common.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class AtomicBattle {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(100);
        List<CompletableFuture<Integer>> completableFutureList = new ArrayList<>(100);
        List<Integer> collect = null;
        for (int i = 0; i < 109; i++) {
            completableFutureList.add(CompletableFuture.supplyAsync(atomicInteger::incrementAndGet));
        }
        collect = completableFutureList.stream().map(CompletableFuture::join).collect(Collectors.toList());
        for (Integer integer : collect) {
            System.out.println(integer);
        }
    }
}