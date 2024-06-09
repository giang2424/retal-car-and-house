// package au.gangi.app.config.jwt;

// // import org.springframework.beans.factory.annotation.Autowired;
// // import org.springframework.context.annotation.Bean;
// // import org.springframework.context.annotation.Configuration;
// // import org.springframework.security.authentication.AuthenticationManager;
// // import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// // import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// // import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// // import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// // import org.springframework.security.config.http.SessionCreationPolicy;
// // import org.springframework.security.core.userdetails.UserDetailsService;
// // import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// // import org.springframework.security.crypto.password.PasswordEncoder;
// // import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
// // import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
// // import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;


// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



// @Configuration
// @EnableWebSecurity
// public class SecurityConfig extends WebSecurityConfigurerAdapter {

//     @Autowired
//     private UserDetailsService userDetailsService;

//     @Autowired
//     private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

//     @Autowired
//     private JwtRequestFilter jwtRequestFilter;



//     @Bean
//     public BCryptPasswordEncoder passwordEncoder() {
//         BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//         return bCryptPasswordEncoder;
//     }

//     @Override
//     public void configure(AuthenticationManagerBuilder auth) throws Exception {
//         auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//     }
    

//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
//         http.csrf().disable()
//             .authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN")
//             .antMatchers("/user/**").hasRole("USER")
//             .antMatchers("/authenticate").permitAll()
//             .anyRequest().authenticated().and()
//             .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
//             .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//         http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//     }

//     @Bean
//     @Override
//     public AuthenticationManager authenticationManagerBean() throws Exception {
//         return super.authenticationManagerBean();
//     }
// }