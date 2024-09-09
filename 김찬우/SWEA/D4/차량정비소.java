	
import java.util.*;
import java.io.*;
 
public class Solution {
     
    static int n,m,k,a,b;
     
    static Person[] receipt;
    static Person[] repair;
    static int[] receiptWork;
    static int[] repairWork;
 
    static Queue<Integer> waitReceipt;
    static Queue<Person> waitRepair;
     
    static int repairInNum = 0;
    static int receiptInNUm = 0;
     
    static int sec = 0;
    static int result;
     
    static List<Integer> emptyRepair;
    static List<Integer> emptyReceip;
    static int clientNumber = 1;
     
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        StringTokenizer st = new StringTokenizer(br.readLine());
         
        int T = Integer.parseInt(st.nextToken());
         
        for (int test_case =1; test_case <=T; test_case++) {
             
            st = new StringTokenizer(br.readLine());
             
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
             
            receipt = new Person[n+1];
            repair = new Person[m+1];
            receiptWork = new int[n+1];
            repairWork = new int[m+1];
            waitReceipt = new ArrayDeque<>();
            waitRepair = new ArrayDeque<>();
             
            emptyReceip = new ArrayList<Integer>();
            emptyRepair = new ArrayList<Integer>();
             
            sec = 0;
            result = 0;
            clientNumber =1;
 
            st = new StringTokenizer(br.readLine());
            for (int i=1; i<=n; i++) {
                receiptWork[i] = Integer.parseInt(st.nextToken());
                 
            }
             
            st = new StringTokenizer(br.readLine());
            for (int i=1; i<=m; i++) {
                repairWork[i] = Integer.parseInt(st.nextToken());
                 
            }
             
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<k; i++) {
                waitReceipt.add(Integer.parseInt(st.nextToken()));
                 
            }
 
            while (true) {
                if (sec >= 10000) {
                    break;
                }
                 
                // 장비 창구 확인
                for (int i = 1; i<=m; i++) {
                     
                    if (repair[i] == null) {
                        continue;
                    }
                 
                    Person person = repair[i];
                     
                    if (sec - person.repairSec == repairWork[i]) {
                         
             
     
                        if (person.receiptNum == a && person.repairNum == b) {
                            result += person.clientNum;
                        }
                         
                        repair[i] = null;
                         
                    }
                     
                }
                 
                emptyRepair.clear();
                for (int i = 1; i<=m; i++) {
                     
                    if (repair[i] == null) {
                        emptyRepair.add(i);
                    }
                }
             
                // 접수 창구 확인
                for (int i = 1; i<=n; i++) {
                     
                    if (receipt[i] == null) {
                        continue;
                    }
                     
                    Person person = receipt[i];
                     
                    if (sec - person.receiptSec == receiptWork[i]) {
                         
                        waitRepair.offer(person);
                        receipt[i] = null;
                    }
                     
                }
                 
                emptyReceip.clear();
                for (int i = 1; i<=n; i++) {
                     
                    if (receipt[i] == null) {
                        emptyReceip.add(i);
                    }
                }       
 
                // 시작       
                for (int i=0; i<emptyRepair.size(); i++) {
                     
                    if (waitRepair.isEmpty()) {
                        break;
                    }
                     
                    int index = emptyRepair.get(i);
                     
                    Person person = waitRepair.poll();
                    person.repairSec = sec;
                    person.repairNum = index;
                     
                    repair[index] = person; 
                     
                }   
                 
                 
                for (int i=0; i<emptyReceip.size(); i++) {
                     
                    if (waitReceipt.isEmpty() || waitReceipt.peek() > sec ) {
             
                        break;
                    }
                     
                     
                    waitReceipt.poll();
                    int index = emptyReceip.get(i);
                    Person person = new Person(clientNumber++, index, sec, -1, -1);
                    receipt[index] = person; 
                     
                }
     
                sec++;
                 
                 
            }
             
            if (result == 0) {
                System.out.println("#"+test_case+" -1");
            }
            else {
                System.out.println("#"+ test_case+" "+result);
            }
             
             
        
     
             
        }
         
    }
}
 
class Person{
     
    public int clientNum;
    public int receiptNum;
    public int receiptSec;
    public int repairNum;
    public int repairSec;
     
     
    public Person(int clientNum, int receiptNum, int receiptSec, int repairNum, int repairSec) {
        this.clientNum = clientNum;
        this.receiptNum = receiptNum;
        this.receiptSec = receiptSec;
        this.repairNum = repairNum;
        this.repairSec = repairSec;
    }
     
     
}
