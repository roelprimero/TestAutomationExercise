package config;

public class Config {
    public Config(String url) {
        this.url = url;
    }

    public Config() {} //default constructor

    // Add more variables in necessary

    //env
    public String url;

    //login
    public String username;
    public String password;
    public String invalid_username;
    public String invalid_password;

    @Override
    public String toString() {
        return "\nURL: " + url + "\n";
    }

}
