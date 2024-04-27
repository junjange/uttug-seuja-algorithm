import java.io.*;
import java.util.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =  new StringTokenizer(br.readLine()," ");

        int T = Integer.parseInt(st.nextToken());

        for(int test_case = 1; test_case <= T; test_case++) {
           
             String  nowTime = br.readLine();
             String  dateTime = br.readLine();
            
            int nowH = Integer.parseInt(nowTime.substring(0,2));
            int dateH =  Integer.parseInt(dateTime.substring(0,2));   
            int nowM =  Integer.parseInt(nowTime.substring(3,5));
            int dateM =  Integer.parseInt(dateTime.substring(3,5));         
            int nowS =  Integer.parseInt(nowTime.substring(6));
            int dateS =  Integer.parseInt(dateTime.substring(6));
            
            int resultH = 0;
            int resultM = 0;
            int resultS = 0;
            
            if (dateH > nowH) {
                resultH = dateH - nowH;
            }else if (dateH < nowH){
                resultH = dateH+24 - nowH ;
            } else if (dateH == nowH) {
                
                if (dateM > nowM) {
                    resultM = dateM - nowM;
                }else if (dateM < nowM) {
                    resultH = 24;
                } else if (dateM == nowM) {
                    
                    if (dateS > nowS) {
                        resultH = 0;
                    }else if (dateS < nowS) {
                         resultH = 24;
                    }else if (dateS == nowS) {
                        resultH =0;
                    }
                    
                }
       
            }

            if (dateM >=nowM) {
                resultM = dateM - nowM;
            }else {
                resultH--;
                resultM = dateM+60 - nowM;
            }
            
            if (dateS >=nowS) {
                resultS = dateS - nowS;
            }else {
                resultM--;
                resultS = dateS+60 - nowS;
            }
            
      
            
              String a = String.format("%02d",resultH); 
              String b = String.format("%02d",resultM);
              String c = String.format("%02d",resultS);
            
            
             System.out.println("#"+test_case+" "+ a + ":" + b + ":"+ c);


            
            

        }
    }
}

















