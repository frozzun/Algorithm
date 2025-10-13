import java.util.*;

class Solution {
    // k : 정지 기준
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        // 사람, index
        HashMap<String, Integer> idList = new HashMap<>();
        
        // 신고 당한 사람, 신고 당한 횟수
        HashMap<String, Integer> reportedMap = new HashMap<>();
        
        // 신고 당한 사람, 신고 한 사람 List
        HashMap<String, List<String>> reportingMap = new HashMap<>();
        
        for(int i = 0;i<id_list.length;i++) {
            String id = id_list[i];
            idList.put(id, i);
            
            reportedMap.put(id, 0);
            
            List<String> list = new ArrayList<>();
            reportingMap.put(id, list);
        }
        
        for(String rep : report) {
            String a = rep.split(" ")[0];   // 신고자
            String b = rep.split(" ")[1];   // 신고 당한 사람
            
            // todo : 신고자가 또 신고한 케이스 걸러야됨.
            if(!reportingMap.get(b).contains(a)) {
                reportingMap.get(b).add(a);
                reportedMap.put(b, reportedMap.get(b) + 1);
            }
        }
        
        // reportedMap 순회 하면서 value가 k 이상인 key 들 가져오기
        // key : 신고 당한 사람..
        for(String key : reportedMap.keySet()) {
            if(reportedMap.get(key)>= k) {
                // 신고 한 사람 list
                List<String> list = reportingMap.get(key);
                
                // list 순회 하면서 answer[신고자 index] ++
                for(String people : list.toArray(new String[list.size()]))
                answer[idList.get(people)] ++;
            }
        }
        
        
        return answer;
    }
}