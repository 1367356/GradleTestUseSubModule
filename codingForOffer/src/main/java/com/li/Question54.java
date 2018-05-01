package com.li;

/**
 * 表示数值的字符串
 */
public class Question54 {
    public boolean isNumberic(String string) {
        if (string == null) {
            return false;
        }
        int i=0;
        if(string.charAt(i)=='+'||string.charAt(i)=='-'){
            string.charAt(i++);
        }
        if(string.charAt(i)=='\0'){
            return false;
        }
        boolean numeric=true;

        scanDigits(string);
        return false;
    }

    private void scanDigits(String string) {

    }
}
