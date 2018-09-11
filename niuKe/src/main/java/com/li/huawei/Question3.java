package com.li.huawei;

import java.util.Arrays;
import java.util.Stack;

public class Question3 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String input="()(()()(";
        System.out.println(longestValidTokens(input));
    }
    public static int  longestValidTokens(String input) {

        int[] arr = new int[input.length()];
        char[] inputArray=input.toCharArray();
        int length=inputArray.length;
        if(length==0)
            return 0;
        int validLength=0;
        int maxValidLength=0;
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<length;i++)
        {
            if(inputArray[i]==')')
            {
                if(stack.isEmpty())
                {
                    validLength=0;
                }
                else {
                    char tempPeek=stack.peek();
                    if(tempPeek=='(')
                    {
                        stack.pop();
                        validLength=validLength+2;
                        if (i - validLength >= 0) {
                            arr[i]=arr[i-1]+2+arr[i-validLength];
                        }else {
                            arr[i]=arr[i-1]+2;
                        }
                        maxValidLength=Math.max(maxValidLength, validLength);
                    }
                    else {
                        validLength=0;
                    }
                }
            } else {
                stack.push(inputArray[i]);
                validLength=0;
            }

        }

        Arrays.sort(arr);
//        System.out.println(arr[arr.length-1]);
        return arr[arr.length-1];


    }


}
