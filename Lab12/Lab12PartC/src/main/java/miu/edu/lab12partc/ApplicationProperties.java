package miu.edu.lab12partc;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@ConfigurationProperties(prefix = "application")
@Validated
public class ApplicationProperties {
    @NotBlank
    private String name;
    @NotBlank
    private String version;

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public Server getServer() {
        return server;
    }

    public User getUser() {
        return user;
    }

    public List<String> getCountries() {
        return countries;
    }

    private Server server = new Server();

    private class Server {
        @NotBlank
        private String url;
        private String name;

        public String getUrl() {
            return url;
        }

        public String getName() {
            return name;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Server{" +
                    "url='" + url + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    private User user = new User();

    private class User {
        private String firstName;
        private String lastName;
        @NotBlank
        @Size(max = 15, min = 8)
        private String userName;
        @NotBlank
        @Size(max = 15, min = 8)
        private String password;

        @Override
        public String toString() {
            return "User{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", userName='" + userName + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getUserName() {
            return userName;
        }

        public String getPassword() {
            return password;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    private List<String> countries = new ArrayList<>();

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    @Override
    public String toString() {
        return "ApplicationProperties{" +
                "name='" + name + '\'' +
                ", version='" + version + '\'' +
                ", server=" + server +
                ", user=" + user +
                ", countries=" + countries +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
