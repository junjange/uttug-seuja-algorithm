import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<>();

        while(true){

            String str = br.readLine();

            if(str.equals(".")){
                break;
            }else{
                list.add(str);
            }

        }


        for(int i=0; i<list.size(); i++){

            Stack<Character> stack = new Stack<>();

            String str = list.get(i);

            for(int j=0; j<str.length(); j++){

                char c = str.charAt(j);

                if(stack.isEmpty()){

                    if(c=='(' || c=='[' || c==')' || c==']'){
                        stack.push(c);
                    }

                }else{
                    Character peek = stack.peek();

                    if((peek =='(' && c == ')') || (peek =='[' && c == ']')){
                        stack.pop();
                    }else if(c=='(' || c=='[' || c==')' || c==']'){
                        stack.push(c);
                    }
                }

            }

            if(stack.isEmpty()){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }


        }
    }
}
