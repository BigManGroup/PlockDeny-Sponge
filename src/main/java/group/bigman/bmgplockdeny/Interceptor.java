package group.bigman.bmgplockdeny;

import java.util.HashMap;

public class Interceptor {
    HashMap <String, String> badWords;
    Interceptor(){
        badWords = new HashMap<>();

        badWords.put("fuck", "sexual intercourse");
        badWords.put("fucking", "performing sexual intercourse");
        badWords.put("cum", "semen");
        badWords.put("nigger", "gentleman of the black skin variety enslaved by gentlemen of the white skin variety");
        badWords.put("shit", "feces");
        badWords.put("faggot", "male that enjoys intercourse with other males");
        badWords.put("cunt", "vagina");
        badWords.put("dick", "penis");
        badWords.put("meme", "haha");
    }

    public String changeBadWord(String message){
        String[] splitMessage = message.split(" ");
        StringBuilder newMessage = new StringBuilder();
        for (int i = 0; i != splitMessage.length ; i++) {
            if(badWords.get(splitMessage[i]) != null){
                splitMessage[i] = badWords.get(splitMessage[i]);
            }
            newMessage.append(splitMessage[i]).append(" ");
        }

        return newMessage.toString();
    }
}
