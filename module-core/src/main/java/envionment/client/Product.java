package envionment.client;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends Tenant {
    private String login_user;
    private String login_pass;
}
