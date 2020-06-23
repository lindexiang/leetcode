package com.study.ldx.tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 *
 * @author guanye
 * @date 2020/6/23 下午10:01
 */
public class PathInZigZagTree {

    public static List<Integer> pathInZigZagTree(int label) {
        //位运算 即可
        List<Integer> ret = new LinkedList<>();
        while (label > 0) {
            ret.add(label);
            int x1 = label >> 1;
            int flag = x1;
            int count = 1;
            while (flag > 1) {
                x1 ^= (1 << (count - 1));
                flag = flag >> 1;
                count++;
            }
            label = x1;
        }
        Collections.reverse(ret);
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(pathInZigZagTree(14));
    }


}
