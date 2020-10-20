package group.bigman.bmgplockdeny.api;

import com.google.gson.JsonObject;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import java.net.MalformedURLException;

public class RandomInsult extends SendRequest {

    final String[] pWords;

    public RandomInsult() throws MalformedURLException {
        super("https://bigman.group/api/randominsult/");
        this.pWords = new String[]{"please", "plz", "pleaze", "plox", "plx", "plis", "pliz", "pls"};
    }

    public Text getRandomInsult(){
        JsonObject response = this.sendRequest();
        System.out.println(response);
        if(response == null) return Text.builder("I used the p-word because I am faggot.  This is not allowed in the BigMan Realms").color(TextColors.RED).build();
        else return Text.builder("I used the p-word because I am " + response.get("insult") + ".  This is not allowed in the BigMan Realms").color(TextColors.RED).build();
    }

    public boolean hasPWord(Text message){
        for (int i = 0; i != pWords.length ; i++) if(message.toString().contains(pWords[i])) return true;
        return false;
    }
}
