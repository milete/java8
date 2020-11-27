package com.jc.test.iterate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * description：无限流-generate
 *
 * @author milete
 * @date 2020/11/27
 */
public class GenerateDemo {

    public static void main(String[] args) {

        /**
         * iterate()：接收一个初始元素seed，生成从seed到f的迭代流
         *
         * @param s Supplier，函数式接口，生产者，返回T
         * public static<T> Stream<T> generate(Supplier<T> s) {}
         */


        //eg：生成十个随机数
        List<Double> randoms = Stream.generate(Math::random)
                .limit(10)
                .collect(Collectors.toList());
        System.out.println("randoms：" + randoms);
    }
}
