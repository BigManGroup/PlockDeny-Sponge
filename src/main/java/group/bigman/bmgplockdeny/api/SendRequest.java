package group.bigman.bmgplockdeny.api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

abstract class SendRequest {
    URL url;
    public SendRequest(String url) throws MalformedURLException {
        this.url = new URL(url);
    }

    JsonObject sendRequest(){
        try {
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String inputLine;
            StringBuilder output = new StringBuilder();

            while ((inputLine = br.readLine()) != null){
                output.append(inputLine);
            }

            return (JsonObject) new JsonParser().parse(output.toString());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
