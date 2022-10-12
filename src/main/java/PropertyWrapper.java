import org.apache.commons.lang3.StringUtils;
import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Properties;

public class PropertyWrapper {

    private static final String configFileName = "config.properties";
    private static final String configFileNamePrivate = "private.properties";

    private static String cleanPath (String path) {
        if (path.startsWith("/")) {
            path = StringUtils.right(path,path.length()-1);
            //System.out.println(path);
        }
        return path;
    }

    private static String getPathToClass() {
        String path = "";
        //System.out.println(PropertyWrapper.class.getResource("PropertyWrapper.class"));
        try {
            path = cleanPath(PropertyWrapper.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
        } catch (URISyntaxException ex) {
            ex.printStackTrace();
        }
        // Set the path depending on whether or not we are running from a jar file
        // When in a jar file, the path starts with "jar:"
        if (Objects.requireNonNull(PropertyWrapper.class.getResource("PropertyWrapper.class")).toString().startsWith("jar:")) {
            Path objectPath = Paths.get(path);
            path = objectPath.getParent().toString() + File.separator; // get the parent from the jar file (which is its containing directory)
        }

        //System.out.println(path);
        return path;
    }

    private static InputStream getPropertyInputStream() {
        String configFilePath = getPathToClass();
        InputStream input = null;
        File file = new File (configFilePath + configFileNamePrivate);

        if (!file.exists()) {
            file = new File(configFilePath + configFileName);
        }
        try {
            input = new FileInputStream(file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if (input == null) {
            System.out.println("Sorry, unable to find " + configFileName + " or " + configFileNamePrivate);
        }
        return input;
    }

    public static String getProperty(String propertyName) {
        // if exists, read private.properties, else read config.properties
        // private.properties should NOT be committed to git (add to .gitignore)
        // config.properties should only contain template values

        //load a properties file from class path, inside static method
        InputStream input = getPropertyInputStream();
        Properties prop = new Properties();
        try {prop.load(input);} catch (IOException io) {io.printStackTrace();}
        //System.out.println(prop.getProperty(propertyName));
        return prop.getProperty(propertyName);
    }

    public static void setProperty(String key, String value) {
        // Load existing property file first, to prevent overwriting with empty values later on
        // Be aware: all comments from the file will not be preserved and special characters will be escaped
        InputStream input = getPropertyInputStream();
        Properties prop = new Properties();
        try {prop.load(input);} catch (IOException io) {io.printStackTrace();}

        String path = getPathToClass();

        try {
            OutputStream output;
            if (Files.exists(Path.of(path + configFileNamePrivate))) {
                output = new FileOutputStream(path + configFileNamePrivate);
            } else {
                output = new FileOutputStream(path + configFileName);
            }

            prop.setProperty(key, value);
            prop.store(output, null); // save property file
//            System.out.println(prop);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

}
