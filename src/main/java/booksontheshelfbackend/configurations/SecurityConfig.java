package booksontheshelfbackend.configurations;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig /*extends WebSecurityConfigurerAdapter*/ {

/*    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.antMatcher("/**").authorizeRequests()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login();
    }*/
}
