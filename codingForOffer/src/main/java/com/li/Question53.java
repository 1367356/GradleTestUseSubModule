package com.li;

/**
 * 正则表达式匹配
 */
public class Question53 {
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return matchCore(str, pattern,0);
    }

    private boolean matchCore(char[] str, char[] pattern,int i) {

        if(str[i]=='\0'&&pattern[i]=='\0'){ //结束标志
            return true;
        }
        if (str[i] != '\0' && pattern[i] == '\0') {
            return false;
        }
        if(pattern[i+1]=='*'){
            if(pattern[i]==str[i]||(pattern[i]=='.'&&str[i]!='\0')){
                return matchCore(str,pattern,i+1)||matchCore(str,pattern,i+2);
            }
        }
        if(str[0]==pattern[0]||pattern[0]=='.'&&str[0]!= '\0'){
            return matchCore(str, pattern, i + 1);
        }
        return false;
    }
}
