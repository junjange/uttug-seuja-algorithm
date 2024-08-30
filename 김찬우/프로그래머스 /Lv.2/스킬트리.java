class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int index = 0; 
        boolean check = false;
    
        
        for(int i=0; i<skill_trees.length; i++){
            index =0;
            check = false;
            
            for(int j=0; j<skill_trees[i].length(); j++ ){
                
                String al = String.valueOf(skill_trees[i].charAt(j));
                
                if(skill.indexOf(al) > index){
                    check = true;
                    break;
                    
                }else if(skill.indexOf(al) == -1 ){
                    continue;
                }else if(skill.indexOf(al) <= index){
                    index++;
                }
                
            }
            
            if(!check){
                answer++;
            }
            
        }
        
        return answer;
    }
}
