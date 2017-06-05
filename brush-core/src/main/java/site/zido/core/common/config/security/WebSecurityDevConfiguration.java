package site.zido.core.common.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import site.zido.core.service.CustomUserService;

/**
 * 开发环境下的security认证（开放所有的api）
 *
 * @author zido
 * @since 2017/6/4 0004
 */
@Configuration
@Profile("dev")
public class WebSecurityDevConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        if (profile != null && Objects.equals(profile, "dev"))
//            http.csrf().disable(); //开发模式下禁用csrf
        http.csrf().disable().authorizeRequests().anyRequest().permitAll();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(getService());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Bean
    public UserDetailsService getService() {
        return new CustomUserService();
    }
}
