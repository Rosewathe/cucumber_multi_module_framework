package envionment.env_types;

import envionment.client.Tenant;
import envionment.Environment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Staging extends Environment {

        private String app_url;
        private String db_url;
        private String db_user;
        private String db_pass;
        private Tenant tenant;
}
