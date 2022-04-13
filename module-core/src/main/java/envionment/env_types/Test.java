package envionment.env_types;

import envionment.Environment;
import envionment.client.Tenant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Test extends Environment {

    private String app_url;
    private String db_url;
    private String db_user;
    private String db_pass;
    private Tenant tenant;

}
