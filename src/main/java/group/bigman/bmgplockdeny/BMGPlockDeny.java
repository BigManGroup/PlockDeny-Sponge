package group.bigman.bmgplockdeny;

import com.google.inject.Inject;
import group.bigman.bmgplockdeny.api.RandomInsult;
import group.bigman.bmgplockdeny.api.RandomQuote;
import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.message.MessageEvent;
import org.spongepowered.api.event.network.ClientConnectionEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Text;

import java.net.MalformedURLException;

@Plugin(
        id = "plockdeny",
        name = "BMG PlockDeny",
        description = "Don't say the p-word, dumbass",
        url = "https://bigman.group/",
        authors = {
                "JamieStivala"
        }
)
public class BMGPlockDeny {
    RandomInsult randomInsult;
    RandomQuote randomQuote;
    Interceptor interceptor;

    BMGPlockDeny() throws MalformedURLException{
        this.randomInsult = new RandomInsult();
        this.randomQuote = new RandomQuote();
        this.interceptor = new Interceptor();
    }

    @Inject
    private Logger logger;

    @Listener
    public void onServerStart(GameStartedServerEvent event) {
    }

    @Listener
    public void onJoin(ClientConnectionEvent.Join event){
        Text quote = this.randomQuote.getRandomQuote();
        if(quote != null && event.getChannel().isPresent()) event.getChannel().get().send(this.randomQuote.getRandomQuote());
    }

    @Listener
    public void onMessageEvent(MessageEvent event){
        if(this.randomInsult.hasPWord(event.getMessage())){
            Text insult = this.randomInsult.getRandomInsult();
            event.setMessage(insult);
        }

        event.setMessage(Text.builder(this.interceptor.changeBadWord(event.getMessage().toPlain())));
    }
}
