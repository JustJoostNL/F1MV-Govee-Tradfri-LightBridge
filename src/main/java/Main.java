import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class Main {
    static boolean raceInProgress;
    static F1mv f1mv;

    // Define colors that are not part of the Java standard
    static Color purple = new Color(128,0,128);
    static Color light_green = new Color(128,255,128);

    @SuppressWarnings("BusyWait")
    public static void main(String[] args) throws IOException, InterruptedException {
        f1mv = new F1mv();
        f1mv.getSessionStatus();
        raceInProgress = !((Objects.equals(f1mv.sessionStatus, "Finalised")) | (Objects.equals(f1mv.sessionStatus, "Ends")));

        Ikea ikea = new Ikea();
        String lastTrackStatus = "";
        Govee govee = new Govee();
        if(govee.disableGovee.equals("true"))
        {
            System.out.println("Govee integration disabled!");
        }
        else if(govee.disableGovee.equals("false"))
        {
            System.out.println("Govee integration enabled!");
            govee.lightSwitch(true);
            govee.setBrightness(100); // initialize Govee at maximum brightness.
        }

        if(ikea.disableIkea.equals("true")) {
            System.out.println("Ikea integration disabled!");

        }
        else if (ikea.disableIkea.equals("false")) {
            System.out.println("Ikea integration enabled!");
            ikea.connect();
        }


        if (args.length > 0) {
            switch (args[0]) {
                case "--list-devices" -> {
                    System.out.println("Listing devices...");
                    ikea.listDevices();
                    System.out.println("Done listing devices.");
                }
                case "--help" -> {
                    System.out.println("Usage: java -jar [jarname].jar/.exe [OPTION]");
                    System.out.println("Options:");
                    System.out.println("--list-devices\t\tList all available Ikea devices");
                    System.out.println("--help\t\t\tShow this help message");
                }

                case "--export-ids" -> {
                    System.out.println("Exporting...");
                    System.out.println(Arrays.toString(ikea.colorAllIDs));
                    System.out.println(Arrays.toString(ikea.nonColorAllIDs));
                    System.out.println("Done exporting.");
                }

                default -> System.out.println("Invalid argument. Use --help to get a list of possible arguments.");

                 }
                System.exit(0);
            }


        while (raceInProgress && ikea.colorLights != null && ikea.nonColorLights != null) {
            f1mv.getTrackStatus();
            if (!Objects.equals(f1mv.trackStatus, lastTrackStatus)) {
                switch (f1mv.trackStatus) {
                    case "1" -> {
                        System.out.println("Green flag!");
                        if(govee.disableGovee.equals("false")) {
                            govee.setColor(Color.green);
                        }
                        if (!ikea.nonColorLights.equals("000")) {
                            ikea.updateNonColorLights(0, 0, false);
                        }
                        if (!ikea.colorLights.equals("000")) {
                            ikea.updateColorLights(Color.green, true);
                        }
                        lastTrackStatus = f1mv.trackStatus;
                    }
                    case "2" -> {
                        System.out.println("Yellow Flag!");
                        if(govee.disableGovee.equals("false")) {
                            govee.setColor(Color.yellow);
                        }
                        if (!ikea.nonColorLights.equals("000")) {
                            ikea.updateNonColorLights(454,200, true);
                        }
                        if (!ikea.colorLights.equals("000")) {
                            ikea.updateColorLights(Color.yellow, true);
                        }
                        lastTrackStatus = f1mv.trackStatus;
                    }
                    case "4" -> {
                        System.out.println("Safety Car!");
                        if(govee.disableGovee.equals("false")) {
                            govee.setColor(Color.yellow);
                        }
                        if (!ikea.nonColorLights.equals("000")) {
                            ikea.updateNonColorLights(454,200, true);
                        }
                        if (!ikea.colorLights.equals("000")) {
                            ikea.updateColorLights(Color.yellow, true);
                        }
                        lastTrackStatus = f1mv.trackStatus;
                    }
                    case "5" -> {
                        System.out.println("Red flag!");
                        if(govee.disableGovee.equals("false")) {
                            govee.setColor(Color.red);
                        }
                        if(!ikea.nonColorLights.equals("000")) {
                            ikea.updateNonColorLights(454,200,true);
                            Thread.sleep(800);
                            ikea.updateNonColorLights(454,200,false);
                            Thread.sleep(800);
                            ikea.updateNonColorLights(454,200,true);
                            Thread.sleep(800);
                            ikea.updateNonColorLights(454,200,false);
                            Thread.sleep(800);
                            ikea.updateNonColorLights(454,200,true);
                            Thread.sleep(800);
                            ikea.updateNonColorLights(454,200,false);
                            Thread.sleep(800);
                            ikea.updateNonColorLights(454,200,true);
                        }
                        if (!ikea.colorLights.equals("000")) {
                            ikea.updateColorLights(Color.red, true);
                            Thread.sleep(800);
                            ikea.updateColorLights(Color.red, false);
                            Thread.sleep(800);
                            ikea.updateColorLights(Color.red, true);
                            Thread.sleep(800);
                            ikea.updateColorLights(Color.red, false);
                            Thread.sleep(800);
                            ikea.updateColorLights(Color.red, true);
                            Thread.sleep(800);
                            ikea.updateColorLights(Color.red, false);
                            Thread.sleep(800);
                            ikea.updateColorLights(Color.red, true);
                        }
                        lastTrackStatus = f1mv.trackStatus;
                    }
                    case "6" -> {
                        System.out.println("Virtual Safety Car!");
                        if(govee.disableGovee.equals("false")) {
                            govee.setColor(Color.yellow);
                        }
                        if (!ikea.nonColorLights.equals("000")) {
                            ikea.updateNonColorLights(454,200, true);
                        }
                        if (!ikea.colorLights.equals("000")) {
                            ikea.updateColorLights(Color.yellow, true);
                        }
                        lastTrackStatus = f1mv.trackStatus;
                    }
                    case "7" -> {
                        System.out.println("Virtual Safety Car ending!");
                        if(govee.disableGovee.equals("false")) {
                            govee.setColor(Color.yellow);
                        }
                        if (!ikea.nonColorLights.equals("000")) {
                            ikea.updateNonColorLights(200,200, true);
                        }
                        if (!ikea.colorLights.equals("000")) {
                            ikea.updateColorLights(light_green, true);
                        }
                        lastTrackStatus = f1mv.trackStatus;
                    }
                }
            }

            f1mv.getSessionStatus();
            if ((Objects.equals(f1mv.sessionStatus, "Finalised")) | (Objects.equals(f1mv.sessionStatus, "Ends"))) {
                raceInProgress = false;
                ikea.updateNonColorLights(0,200,false);
                ikea.updateColorLights(Color.white,false);
                govee.lightSwitch(false);
            }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
}