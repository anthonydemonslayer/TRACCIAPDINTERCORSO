package evento;

import static java.lang.annotation.ElementType.*;
import java.lang.annotation.*;
import javax.inject.Qualifier;
import static java.lang.annotation.RetentionPolicy.*;

@Qualifier
@Retention(RUNTIME)
@Target({METHOD, TYPE, FIELD, PARAMETER})


public @interface EventiMultipli {
    
}
