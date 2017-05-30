package courseka.at;

import net.serenitybdd.jbehave.SerenityStories;

import javax.security.auth.login.AppConfigurationEntry;
import javax.security.auth.login.Configuration;

public class CoursekaIT extends SerenityStories{

    private Configuration configuration;

    public CoursekaIT(){
        super();
        configuration = new Configuration() {
            @Override
            public AppConfigurationEntry[] getAppConfigurationEntry(String name) {
                return new AppConfigurationEntry[0];
            }
        };
    }
}
