import com.google.gson.Gson;
import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Govee {
     String goveeURL;
     String goveeAPIKeyHeader;
     String goveeAPIKey;
     String goveeDeviceMAC;
     String goveeDeviceModel;
     Gson gson = new Gson();

     private final GoveeJsonWrapper goveeJsonWrapper = new GoveeJsonWrapper();

     // Class constructor, used to initialize variables
     public Govee() {
          this.getProperties();
          goveeJsonWrapper.device = goveeDeviceMAC;
          goveeJsonWrapper.model = goveeDeviceModel;
     }

     private static class GoveeJsonWrapper {
          public String device;
          public String model;
          public GoveeJsonCmd cmd = new GoveeJsonCmd();
     }

     private static class GoveeJsonCmd {
          public String name;
          public Object value;
     }

     private static class GoveeJsonRGB {
          public Integer r;
          public Integer g;
          public Integer b;

          public GoveeJsonRGB(Color color) {
               r = color.getRed();
               g = color.getGreen();
               b = color.getBlue();
          }
     }

     public void lightSwitch(boolean lightOnOff) throws IOException {
          String switchValue;
          if (lightOnOff) {switchValue="on";} else {switchValue="off";}
          goveeJsonWrapper.cmd.name = "turn";
          goveeJsonWrapper.cmd.value = switchValue;
          goveeSendJson(gson.toJson(goveeJsonWrapper));
     }

     public void setColor(Color color) throws IOException {
          goveeJsonWrapper.cmd.name = "color";
          goveeJsonWrapper.cmd.value = new GoveeJsonRGB(color);
          goveeSendJson(gson.toJson(goveeJsonWrapper));
     }

     public void setBrightness(Integer brightness) throws IOException {
          goveeJsonWrapper.cmd.name = "brightness";
          goveeJsonWrapper.cmd.value = brightness;
          goveeSendJson(gson.toJson(goveeJsonWrapper));
     }

     private void goveeSendJson(String json) throws IOException {
          URL oUrl = new URL(goveeURL);
          HttpURLConnection http = (HttpURLConnection) oUrl.openConnection();
          http.setRequestMethod("PUT");
          http.setDoOutput(true);
          http.setRequestProperty("Content-Type", "application/json");

          Map<String, String> headers = new HashMap<>();
          headers.put(goveeAPIKeyHeader, goveeAPIKey);

          for (String headerKey : headers.keySet()) {
               http.setRequestProperty(headerKey, headers.get(headerKey));
          }

          byte[] out = json.getBytes(StandardCharsets.UTF_8);
          OutputStream stream = http.getOutputStream();
          stream.write(out);
          http.getResponseCode();
          http.getResponseMessage();
          //System.out.println(http.getResponseCode() + " " + http.getResponseMessage() + "\n" + json);
          http.disconnect();
     }

     private void getProperties() {
          this.goveeURL = PropertyWrapper.getProperty("govee.goveeURL");
          this.goveeAPIKeyHeader = PropertyWrapper.getProperty("govee.goveeAPIKeyHeader");
          this.goveeAPIKey = PropertyWrapper.getProperty("govee.goveeAPIKey");
          this.goveeDeviceMAC = PropertyWrapper.getProperty("govee.goveeDeviceMAC");
          this.goveeDeviceModel = PropertyWrapper.getProperty("govee.goveeDeviceModel");
     }
}
