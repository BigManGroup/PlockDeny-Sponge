package group.bigman.bmgplockdeny.api;

import com.google.gson.JsonObject;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.format.TextColors;

import java.net.MalformedURLException;

public class RandomQuote extends SendRequest{

    public RandomQuote() throws MalformedURLException {
        super("https://bigman.group/api/randomquote/");
    }

    public Text getRandomQuote(){
        JsonObject response = this.sendRequest();
        if(response == null) return null;
        else {
            Text.Builder coloredText = Text.builder("A wise person that goes by the name of " + response.get("nickname") + " once said: ");
            coloredText.append(Text.builder(response.get("text").getAsString()).color(TextColors.BLUE).build());

            return coloredText.build();
        }
    }
}
