package com.li;

/**
 * 翻转单词顺序VS左旋转字符串
 */
public class Question42 {

    public void reverse(Character begin, Character end) {
        if (begin == null || end == null) {
            return;
        }
        while (begin < end) {
            Character temp=begin;
            begin=end;
            end=temp;
            begin++;
            end++;
        }
    }

    /**
     * 题目1： 翻转单词顺序
     */
    public Character reverseSentence(Character data) {
        if (data == null) {
            return null;
        }
        Character begin=data;
        Character end=data;
        while (end != '\0') {
            end++;
        }
        end--;

        //翻转整个句子
        reverse(begin, end);

        //翻译句子中的每个单词
        begin=end=data;
        while (begin != '\0') {
            if (begin == ' ') {
                begin++;
                end++;
            } else if (end == ' ' || end == '\0') {
                reverse(begin, --end);
                begin=++end;
            }else {
                end++;
            }
        }
        return data;
    }

    /**
     * 题目2：字符串的左旋，把字符串前面的若干个字符移动到最后
     */
    public String leftRotateString(String str, int n) {
        if (str != null) {
            int length=str.length();
            if (length > 0 && n > 0 && n < length) {
                char firstStart = str.charAt(0);
                char firstEnd = str.charAt(n - 1);

                char secondStart = str.charAt(n);
                char secondEnd = str.charAt(length - 1);

                //翻转字符串前面n个字符
                reverse(firstStart,firstEnd);
                //翻转字符串的后面部分
                reverse(secondStart, secondEnd);
                //翻转整个字符串
                reverse(firstStart,secondEnd);
            }
        }
        return str;
    }
}
