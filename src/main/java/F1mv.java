import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class F1mv {
    String trackStatus;
    String sessionStatus;
    String sessionURL;
    String trackURL;

    // Class constructor, used to initialize variables
    public F1mv() throws IOException {
        this.getProperties();
        this.getSessionStatus();
        this.getTrackStatus();
    }

    public void getTrackStatus() throws IOException {
        this.trackStatus = getJsonStringFromURL(trackURL,"Status");
    }

    public void getSessionStatus() throws IOException {
        this.sessionStatus = getJsonStringFromURL(sessionURL,"Status");
    }

    private void getProperties() {
           this.sessionURL = PropertyWrapper.getProperty("f1mv.sessionURL");
           this.trackURL = PropertyWrapper.getProperty("f1mv.trackURL");
    }

    private String getJsonStringFromURL(String url, String jsonObjectName) throws IOException {
        URL oURL = new URL(url); // Convert URL string to URL object
        URLConnection request = oURL.openConnection();
        request.connect();

        // Convert to a JSON object to print data.
        JsonElement jsonElement = JsonParser.parseReader(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonObject = jsonElement.getAsJsonObject(); //Maybe an array, may be an object.
        return jsonObject.get(jsonObjectName).getAsString();
    }
}
