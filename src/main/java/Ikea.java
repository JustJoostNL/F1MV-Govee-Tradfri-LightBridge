import nl.stijngroenen.tradfri.device.Device;
import nl.stijngroenen.tradfri.device.Gateway;
import nl.stijngroenen.tradfri.device.Light;
import nl.stijngroenen.tradfri.util.Credentials;

import java.awt.*;
import java.util.Arrays;

public class Ikea {

    String gatewayIP;
    String gatewaySecurityCode;
    String gatewayKey;
    String gatewayIdentity;
    String colorLights;
    String nonColorLights;

    int[] nonColorAllIDs;
    int[] colorAllIDs;

    Gateway gateway;
    boolean gatewayInitialized = false;

    String disableIkea;

    // Class constructor, used to initialize variables
    public Ikea() {
        this.getProperties();
        this.gateway = new Gateway(gatewayIP);
        if (!gatewayInitialized) {
            if(disableIkea.equals("false")) {
                this.createCredentials();
            }

        }
    }

    public void createCredentials() {
        Credentials credentials = this.gateway.connect(gatewaySecurityCode);
        this.gatewayIdentity = credentials.getIdentity();
        this.gatewayKey = credentials.getKey();
        this.setProperties();
    }

    public void connect() {
        Credentials credentials = new Credentials(gatewayIdentity, gatewayKey);
        gateway.connect(credentials);
    }

    public void listDevices() {
        Device[] devices = gateway.getDevices();
        System.out.println(Arrays.toString(devices));
        for(Device device : devices) {
            System.out.println(device.getName() + " " + device.getInstanceId());
            //System.out.println(device.getDeviceInfo());
        }
    }

    private int[] splitLightIDs(String lightIDs) {
        String[] parts = lightIDs.split(",");
        int[] intParts = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            intParts[i] = Integer.parseInt(parts[i]);
        }
        return intParts;
    }

    public void updateColorLights(Color color, boolean lightOnOff) {
        if (!this.colorLights.equals("000")) {

            for (int lightID : this.colorAllIDs) {
                Device colorLight = gateway.getDevice(lightID);
                Light light = colorLight.toLight();
                light.updateOn(lightOnOff);
                light.updateBrightness(250);
                light.updateColourRGB(color.getRed(), color.getGreen(), color.getBlue());
                light.applyUpdates();
            }
        }
    }

    public void updateNonColorLights(int temperature, int brightness, boolean lightOnOff) {
        if (!this.nonColorLights.equals("000")) {

            for (int lightID : this.nonColorAllIDs) {
                Device nonColorLight = gateway.getDevice(lightID);
                Light light = nonColorLight.toLight();
                light.updateOn(lightOnOff);
                light.updateBrightness(brightness);
                light.updateColourTemperature(temperature);
                light.applyUpdates();
            }
        }
    }

    private void getProperties() {
        this.gatewayIP = PropertyWrapper.getProperty("ikea.gatewayIP");
        this.gatewaySecurityCode = PropertyWrapper.getProperty("ikea.gatewaySecurityCode");
        this.gatewayKey = PropertyWrapper.getProperty("ikea.gatewayKey");
        this.gatewayIdentity = PropertyWrapper.getProperty("ikea.gatewayIdentity");
        this.colorLights = PropertyWrapper.getProperty("ikea.colorLights");
        this.nonColorLights = PropertyWrapper.getProperty("ikea.nonColorLights");
        this.disableIkea = PropertyWrapper.getProperty("ikea.disableIkea");
        gatewayInitialized = true;

        this.colorAllIDs = splitLightIDs(this.colorLights);
        this.nonColorAllIDs = splitLightIDs(this.nonColorLights);

        // If gatewayKey and/or gatewayIdentity are empty, call set gatewayInitialized to false, which will
        // cause this.createCredentials to be called later. This will save the credentials in the property file
        // and set the class variables that were empty
        if (this.gatewayKey==null | this.gatewayIdentity==null) {
            gatewayInitialized = false;
        } else if (this.gatewayKey.isBlank() | this.gatewayIdentity.isBlank()) {
            gatewayInitialized = false;
        }
    }

    private void setProperties() {
        PropertyWrapper.setProperty("ikea.gatewayKey", this.gatewayKey);
        PropertyWrapper.setProperty("ikea.gatewayIdentity", this.gatewayIdentity);
    }
}
