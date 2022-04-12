import Tenants.Product;

import com.facebook.core.env.Env_types.*;

import lombok.Getter;
import lombok.Setter;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

@Getter
@Setter
public class Environment {

    private static final String TEST="test";
    private static final String STG="stg";

    private static final String ENVIORMENT_YAML_FILE_NAME ="env.yaml";
    //YAML parameters - active is always test
    private String active_env;
    private String active_tenant;
    private Test test;
    private Stg stg;

   //tenants
    private Product product;

    //tenants parameters
    private String app_url;
    private String login_user;
    private String login_pass;
    static Environment enviornment= new Environment();

    public static Environment getEnviornment()
    {
        enviornment= new Yaml(new Constructor(Environment.class)).load(Environment.class
               .getClassLoader()
               .getResourceAsStream(ENVIORMENT_YAML_FILE_NAME));
       return enviornment;
    }

    private static Environment getCurrentEnv() {
        switch (getEnviornment().getActive_env()) {
            case TEST:
                return getEnviornment().getTest();
            case STG:
                return getEnviornment().getStg();
            default:
                throw new IllegalStateException("Unexpected value: " + getCurrentEnv().getActive_env());

    }
    }



}
