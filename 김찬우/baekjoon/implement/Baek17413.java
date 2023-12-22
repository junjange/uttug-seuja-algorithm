package com.example.codingtest.implement;

import java.util.Scanner;
import java.util.Stack;

public class Baek17413 {

    public static void main(String[] args) {

        //아이디어
        // 스택에 저장 하고 하나씩 확인
        // StinrgBuilder로 문자열 뒤집기
        // 뒤집을 문자들만 스택에서 관리하고 괄호가 열린곳은 그녕 출력한다.

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean open = false;

        for(int i=0; i<str.length(); i++){

            char word = str.charAt(i);

            if(word == '<'){
                open = true;

                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                sb.append('<');

            }else if(word == '>'){
                open = false;
                sb.append('>');

            }else if(word == ' '){

                while (!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                sb.append(' ');


            }else {
                if(open){
                    sb.append(word);
                }else{
                    stack.push(word);
                }

            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb);


    }
}
