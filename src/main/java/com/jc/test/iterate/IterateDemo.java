package com.jc.test.iterate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * description：无限流-iterate
 *
 * 流是惰性的，分为中间操作和终止操作，在执行终止操作之前，流的遍历不会开始，基于这一特性，才可以使用无限流；
 * 使用无限流，需要正确的做限制（limit），截断流。
 *
 * @author milete
 * @date 2020/11/27
 */
public class IterateDemo {

    public static void main(String[] args) {

        /**
         * iterate()：接收一个初始元素seed，生成从seed到f的迭代流
         *
         * @param seed 初始元素
         * @param f UnaryOperator，函数式接口，接收T类型参数，调用apply后返回T本身，应用于上一个元素以产生新元素
         * public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f) {}
         */


        //创建一个从0开始，每次加2的无限流，并限制收集前十个元素
        List<Integer> list = Stream.iterate(0, c -> c + 2)
                .limit(10)
                .collect(Collectors.toList());
        System.out.println("list：" + list);

        //斐波那契数列，从[0, 1]开始，下一个数是前两个数之和，并限制收集前十个数组中的首元素
        List<Integer> fibo = Stream.iterate(new Integer[]{0, 1}, c -> new Integer[]{c[1], c[0] + c[1]})
                .map(c -> c[0])
                .limit(10)
                .collect(Collectors.toList());
        System.out.println("fibo：" + fibo);
    }
}
