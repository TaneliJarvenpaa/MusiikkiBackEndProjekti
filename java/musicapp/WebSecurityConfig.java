package musicapp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import musicapp.web.UserDetailServiceImpl;





@Configuration
@EnableMethodSecurity(securedEnabled=true)
public class WebSecurityConfig {
	
@Autowired
private UserDetailServiceImpl userDetailsService;

private static final AntPathRequestMatcher[] ADMIN_LIST_URLS= {
		new AntPathRequestMatcher("/admin/**")
};

@Bean
public SecurityFilterChain configure(HttpSecurity http) throws Exception {
http
.authorizeHttpRequests( authorize -> authorize
.requestMatchers("/", "/login").permitAll()
.requestMatchers("/h2-console/**").permitAll()
.requestMatchers(ADMIN_LIST_URLS).hasRole("ADMIN")
.anyRequest().authenticated()
)
.formLogin( formlogin -> formlogin
.loginPage("/login")
.defaultSuccessUrl("/albumlist", true)
.permitAll()
)

.logout( logout -> logout
.permitAll())
.csrf(csrf -> csrf.disable()
);
return http.build();
}


@Autowired
public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
auth.userDetailsService(userDetailsService).passwordEncoder(new
BCryptPasswordEncoder());
}
}

