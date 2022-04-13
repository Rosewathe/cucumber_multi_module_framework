package envionment.client;

import envionment.Environment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tenant extends Environment {
    private Product product;
    private Face face;

}
