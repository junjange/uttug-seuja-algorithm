class Solution {
    public String solution(String phone_number) {
        
        StringBuilder str =new StringBuilder(phone_number);
        
        str.replace(0,phone_number.length()-4,"*".repeat(phone_number.length()-4));
    
        return str.toString();
    }
}
