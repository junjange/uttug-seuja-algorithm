import java.util.*;

class Solution {
    public static int solution(int[] picks, String[] minerals) {
        int total = 0;
        for(int i = 0; i < 3; i++) {
            total += picks[i];
        }
        
        int len = minerals.length / 5;
        if(minerals.length % 5 != 0) {
            len++;
        }
        
        if(total * 5 < minerals.length) {
            len = total;
        }
        
        MineralSet[] mineralSets = new MineralSet[len];
        for(int i = 0; i < len * 5; i += 5) {
            int diamondCnt = 0;
            int ironCnt = 0;  
            int stoneCnt = 0;
            for(int j = 0; j < 5; j++) {
                if(i+j >= minerals.length) {
                    continue;
                }
                
                String mineral = minerals[i+j];
                if(mineral.equals("diamond")) {
                    diamondCnt++;
                } else if(mineral.equals("iron")) {
                    ironCnt++;
                } else {
                    stoneCnt++;
                }
            }
            MineralSet mineralSet = new MineralSet(diamondCnt, ironCnt, stoneCnt);
            mineralSets[i/5] = mineralSet;
        }
        
        Arrays.sort(mineralSets, new Comparator<MineralSet>() {
            @Override
            public int compare(MineralSet ms1, MineralSet ms2) {
                if(ms2.diamondCnt == ms1.diamondCnt) {
                    return ms2.ironCnt - ms1.ironCnt;
                }
                return ms2.diamondCnt - ms1.diamondCnt;
            }
        });
        
        int result = 0;
        for(MineralSet mineralSet : mineralSets) {
            int pick = 4;
            for(int i = 0; i < 3; i++) {
                if(picks[i] > 0) {
                    pick = i;
                    picks[i]--;
                    break;
                }
            }
            
            if(pick == 0) {
                result += mineralSet.diamondCnt + mineralSet.ironCnt + mineralSet.stoneCnt;
            } else if(pick == 1) {
                result += 5 * mineralSet.diamondCnt + mineralSet.ironCnt + mineralSet.stoneCnt;
            } else if(pick == 2){
                result += 25 * mineralSet.diamondCnt + 5 * mineralSet.ironCnt + mineralSet.stoneCnt;
            }
        }
        
        return result;
    }
    
    static class MineralSet {
        private int diamondCnt;
        private int ironCnt;
        private int stoneCnt;
        
        public MineralSet(int diamondCnt, int ironCnt, int stoneCnt) {
            this.diamondCnt = diamondCnt;
            this.ironCnt = ironCnt;
            this.stoneCnt = stoneCnt;
        }
    }
}
