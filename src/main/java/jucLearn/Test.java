package jucLearn;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture completableFuture = CompletableFuture.runAsync(()->{
//            try {
//                TimeUnit.SECONDS.sleep(3);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        TimeUnit.SECONDS.sleep(2);
//        System.out.println("等待4s了");
//
//
//        System.out.println("1111");
//        System.out.println(completableFuture.get());

        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(()->{
            System.out.println("completeTableFUture");
            int i = 10/0;  // 创造异常，让那边获取
            return 11;
        });

        //有点像js的语法
        System.out.println(completableFuture.whenComplete((t, u) -> {
            System.out.println("t-->>" + t);  // t代表正常的返回结果
            System.out.println("u-->>" + u);  // u是错误的返回信息
        }).exceptionally((e) -> {
            System.out.println(e.getMessage());
            return 233;
        }).get());
    }
}
