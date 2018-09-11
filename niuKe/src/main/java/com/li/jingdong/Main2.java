package com.li.jingdong;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int count = 0;
        List<Product> arrayList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int i1 = input.nextInt();
            int i2 = input.nextInt();
            int i3 = input.nextInt();
            Product p = new Product(i1,i2,i3);
            arrayList.add(p);
        }
        for (int i = 0; i < arrayList.size(); i++) {
            Product p1 = arrayList.get(i);
            for (int j = 0; j < arrayList.size(); j++) {
                Product p2 = arrayList.get(j);
                if (p1.m <p2.m &&p1.n <p2.n &&p1.k <p2.k) {
                    count++;
                    break;
                }
            }

        }
        System.out.println(count);
    }

}
class Product {
    public  int m;
    public  int n;
    public  int k;
    public Product(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
    }
}
