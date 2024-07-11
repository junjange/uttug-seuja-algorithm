package com.example.codingtest.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Baek1213 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        HashMap<Character,Integer> map = new HashMap<>();
        ArrayList<Character> list =  new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        if (str.length() % 2 == 0) {

            for (int i=0; i < str.length(); i++) {

                char a = str.charAt(i);

                if (!map.containsKey(a)) {
                    map.put(a,1);
                }else {
                    map.put(a,map.get(a)+1);
                }

            }

            for (Character c : map.keySet()) {

                if (map.get(c) % 2 !=0) {
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }

                list.add(c);
            }

            Collections.sort(list);

            for (char k : list) {

                for (int i=0; i<map.get(k)/2; i++) {
                    sb.append(k);
                }
            }

            String result = sb.toString();

            result += sb.reverse();

            System.out.println(result);


        }else {

            for (int i=0; i < str.length(); i++) {

                char a = str.charAt(i);

                if (!map.containsKey(a)) {
                    map.put(a,1);
                }else {
                    map.put(a,map.get(a)+1);
                }


            }

            int check = 0;
            char mid =' ';

            for (Character c : map.keySet()) {

                if (map.get(c) % 2 == 1) {
                    check++;
                    mid = c;
                }

                if (check > 1) {
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }

                list.add(c);
            }

            Collections.sort(list);

            for (char k : list) {

                for (int i=0; i<map.get(k)/2; i++) {
                    sb.append(k);
                }
            }

            String result = sb.toString();

            result+=mid;

            result += sb.reverse();

            System.out.println(result);

        }

    }
}
