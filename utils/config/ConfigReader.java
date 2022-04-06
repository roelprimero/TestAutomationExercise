package config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.apache.commons.io.FilenameUtils;
import java.io.File;

public class ConfigReader {
    public static String get_environment_config_url(String application) throws Exception
    {
        String current_working_directory = System.getProperty("user.dir");
        String unix_format_path = FilenameUtils.separatorsToUnix(current_working_directory);
        String config_path = "/application/"+  application + "/configuration/environment_config.yaml"; //TODO: parse in Env
        String full_config_path = unix_format_path  + config_path;
        File file = new File(full_config_path);
        // Instantiating a new ObjectMapper as a YAMLFactory
        ObjectMapper om = new ObjectMapper(new YAMLFactory());
        // Mapping the config.Config from the YAML file to the config.Config class
        Config config = om.readValue(file, Config.class);
        return config.url;
    }

    public static Config get_config(String application) throws Exception
    {
        String current_working_directory = System.getProperty("user.dir");
        String unix_format_path = FilenameUtils.separatorsToUnix(current_working_directory);
        String config_path = "/application/"+  application + "/configuration/login_config.yaml"; //TODO: parse in Env
        String full_config_path = unix_format_path  + config_path;
        File file = new File(full_config_path);
        // Instantiating a new ObjectMapper as a YAMLFactory
        ObjectMapper om = new ObjectMapper(new YAMLFactory());
        // Mapping the config.Config from the YAML file to the config.Config class
        Config config = om.readValue(file, Config.class);
        return config;
    }
}
