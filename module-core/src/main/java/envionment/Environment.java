package envionment;

import envionment.client.Face;
import envionment.client.Product;
import envionment.client.Tenant;
import envionment.env_types.Staging;
import envionment.env_types.Test;
import lombok.Getter;
import lombok.Setter;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;

@Setter
@Getter
public class Environment {

        private static final String TEST="test";
        private static final String STAGING="staging";
        private static final String PRODUCT= "product";
        private static final String FACE= "face";

        private static final String YAML_FILE_NAME ="env.yml";

        //YAML parameters - active is always test
        private String active_env;
        private String active_tenant;
        private Test test;
        private Staging staging;

        //tenants
        private Product product;
        private Face face;
        private Tenant tenant;

        //tenants parameters
        private String app_url;
        private String login_user;
        private String login_pass;
        static Environment enviornment= new Environment();

        //to read
        public static Environment ReadYamlFile()
        {
            InputStream io =Environment.class.getClassLoader().getResourceAsStream(YAML_FILE_NAME);
            enviornment= new Yaml(new Constructor(Environment.class)).load(io);

            if(System.getProperty("ENV")!=null)
            {
                enviornment.setActive_env(System.getProperty("ENV"));
            }
            return enviornment;
        }

        private static Environment getCurrentEnv() {
            switch (ReadYamlFile().getActive_env()) {
                case TEST:
                    return ReadYamlFile().getTest();
                case STAGING:
                    return ReadYamlFile().getStaging();
                default:
                    throw new IllegalStateException("Unexpected value: " + getCurrentEnv().getActive_env());
            }
        }

        private static  Environment getCurrentTenants(){
            switch (ReadYamlFile().getActive_tenant()) {
                case PRODUCT:
                    return getCurrentEnv().getTenant().getProduct();
                case FACE:
                    return getCurrentEnv().getTenant().getFace();
                default:
                    throw new IllegalStateException("Unexpected value: " + ReadYamlFile().getActive_tenant());

            }
        }

        public static Environment getCurrentEnvironment() {
            Environment environment = getCurrentEnv();
            environment.setLogin_user(getCurrentTenants().getLogin_user());
            environment.setLogin_pass(getCurrentTenants().getLogin_pass());
            return environment;
        }
}
