import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = " ";
        
        //HashMap에서 key는 선수 이름, value 는 동명 이인 때문에 사람 수
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        
        //HashMap에 저장.
        for(String people : participant) {
            hash.put(people, hash.getOrDefault(people, 0) +1);
        }
        
        for(String people : completion) {
            hash.replace(people, hash.get(people)-1);
        }
        
        for(String people : participant) {
            if(hash.get(people)!=0) {
                answer = people;
                break;
            }
        }
        return answer;
    }
}