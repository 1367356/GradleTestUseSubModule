package com.li.huawei;

import java.util.*;

public class Question1{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int proNum=scanner.nextInt();
        double price=scanner.nextDouble();

        double fac1=0;
        double fac2=0;
        if(proNum>=3){
            fac1=proNum*price*0.7+10;
        }else {
            fac1=proNum*price+10;
        }
        if(fac1>=50){
            fac1=fac1-10;
        }
        fac2=proNum*price;

        int x=(int)(fac2/10);
        fac2=fac2-x*2+6;
        if(fac2>=99){
            fac2=fac2-6;
        }
        fac1=(int)(fac1*100);
        fac2=(int)(fac2*100);
        if(fac2==fac1){
            System.out.println(0);
        }else if(fac1<fac2){
            System.out.println(1);
        }else{
            System.out.println(2);
        }
    }
}
