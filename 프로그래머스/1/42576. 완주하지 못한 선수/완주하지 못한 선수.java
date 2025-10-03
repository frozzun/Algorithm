import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        String answer = "";
        
        // 참가자 map에 넣기.
        for(String name : completion) {
            if(!map.containsKey(name)) {
                map.put(name, 1);
            } else {
                int value = map.get(name);
                map.put(name, ++value);
            }
            
        }
        
        // 완주자 명단 갖고 놀기
        for(String name : participant) {
            if(map.containsKey(name) && map.get(name)==1) {
                map.remove(name);
            } else if(map.containsKey(name) && map.get(name)!=1) {
                int value = map.get(name);
                map.put(name, --value);
            } else if(!map.containsKey(name)) {
                answer = name;
            }
        }
        
        
        
        
        return answer;
    }
}