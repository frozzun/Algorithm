import java.util.*;

class Solution {
    static String[] act = {"Enter", "Leave", "Change"};
    
    public String[] solution(String[] record) {
        
        
        // <UserId, NickName>
        HashMap<String, String> info = new HashMap<>();
        
        int answerIndex = 0;
        for(String message : record) {
            String[] mes = new String[3];
            mes = message.split(" ");
            if(!mes[0].equals(act[1])) { // Leave가 아니면 저장.
                info.put(mes[1], mes[2]);
            }
            if(!mes[0].equals(act[2])) {
                answerIndex ++;
            }
        }   // key, value에 UserId, NickName 저장.
        
        // 닉네임 바꾼거 생각 -> 아이디마다 마지막 닉네임 저장. Change or Enter로 판단.
        
        String[] answer = new String[answerIndex];
        
        int index = 0;  // answer index
        
        for(int i=0;i<record.length;i++) {
            String[] mes = new String[3];
            mes = record[i].split(" ");
            String nickName = info.get(mes[1]);
            
            String showMessage = "";
                
            // Enter
            if(mes[0].equals(act[0])) {
                showMessage = nickName + "님이 들어왔습니다.";
                answer[index++] = showMessage;
            }
            // Leave
            else if(mes[0].equals(act[1])) {
                showMessage = nickName + "님이 나갔습니다.";
                answer[index++] = showMessage;
            }
        }
        
        
        return answer;
    }
}