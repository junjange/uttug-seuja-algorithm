import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};

        
        Arrays.sort(files, new Comparator<>(){
            
            @Override
            public int compare(String o1, String o2){
                
                String head1 = o1.split("[0-9]")[0].toLowerCase();
                String head2 = o2.split("[0-9]")[0].toLowerCase();
                
                int compareHead = head1.compareTo(head2);
                
                if(compareHead == 0){
                    
                    String a = o1.substring(head1.length());
                    String b = o2.substring(head2.length());
                    
                    String len1 ="";
                    String len2 ="";
                    
                    for(int i=0; i<a.length(); i++){
                        
                        char word = a.charAt(i);
                        
                        if('0' <= word && word <= '9' && i<5){
                            len1+=word;
                        }else{
                            break;
                        }
                        
                    }
                    
                    int result1 = Integer.parseInt(len1);
        
                    
                    for(int i=0; i<b.length(); i++){
                        
                        char word = b.charAt(i);
                        
                        if('0' <= word && word <= '9' && i<5){
                            len2+=word;
                        }else{
                            break;
                        }
                        
                    }
                    
                    int result2 = Integer.parseInt(len2);
        
                    
                    return result1 - result2;
                    
                }
                
                return compareHead;
            }
            
        });
        
       
        return files;
    }
}
