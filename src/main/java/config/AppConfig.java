package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by heiko on 14.12.14.
 */
@Configuration
@Import(ScreensConfig.class)
@ComponentScan("git")
public class AppConfig {


}
