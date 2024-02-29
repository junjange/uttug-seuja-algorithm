package com.example.codingtest.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baek10816 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();

        HashMap<Integer, Integer> map = new HashMap<>();

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine()," ");

        for(int i=0; i<n; i++){

            int num = Integer.parseInt(st.nextToken());

            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else{
                map.put(num,1);
            }

        }

        st = new StringTokenizer(br.readLine()," ");
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine()," ");


        for(int i=0; i<m; i++){

            int num = Integer.parseInt(st.nextToken());

            if(map.containsKey(num)){
                sb.append(map.get(num));
                sb.append(" ");
            }else{
                sb.append("0 ");
            }

        }

        System.out.println(sb);


    }

}
