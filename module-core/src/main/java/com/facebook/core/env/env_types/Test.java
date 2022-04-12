package env.env_types;

import Tenants.Product;
import lombok.Getter;
import lombok.Setter;
import env.*;
@Getter
@Setter
public class Test extends Environment{
    
    private String app_url;  
    private String db_url;
    private String db_user;
    private String db_pass;
    private Product product;

}
