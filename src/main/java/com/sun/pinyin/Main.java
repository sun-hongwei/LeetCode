package com.sun.pinyin;

import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class Main {
    public static void main(String[] args) {
        Pinyin4jUtils jUtils = new Pinyin4jUtils();
        try {
            System.out.println(jUtils.toPinYinLowercase("你好"));
        } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
            badHanyuPinyinOutputFormatCombination.printStackTrace();
        }
    }
}
