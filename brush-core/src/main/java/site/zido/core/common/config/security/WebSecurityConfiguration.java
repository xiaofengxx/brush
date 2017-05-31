package site.zido.core.common.config.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.Http401AuthenticationEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import site.zido.core.service.CustomUserService;

import javax.annotation.Resource;

/**
 * security 认证配置
 *
 * @author <a href="http://zido.site">zido</a>.
 * @version 1.0.0
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Value("${spring.profiles.active}")
    private String profile;
    @Resource
    private AuthFailureHandler failureHandler;
    @Resource
    private AuthSuccessHandler successHandler;
    @Resource
    private HttpLogoutSuccessHandler logoutSuccessHandler;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        if (profile != null && Objects.equals(profile, "dev"))
//            http.csrf().disable(); //开发模式下禁用csrf
        http.csrf().disable().exceptionHandling().authenticationEntryPoint(new Http401AuthenticationEntryPoint("账户名或密码错误"))
                .and()
                .authorizeRequests()
//                .anyRequest().authenticated()
                //admin/superAdmin可访问
                .antMatchers("api/business/**").hasRole("商户")
                //superAdmin可访问
                .antMatchers("api/subscriber/**").hasRole("刷手")
                //user/superAdmin/admin可访问
                .antMatchers("api/center/**").hasRole("管理员")
                .antMatchers("api/user/**").authenticated()
                //其他均可匿名访问
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginProcessingUrl("/auth/login")
                .successHandler(successHandler)
                .failureHandler(failureHandler)
                .permitAll()
                .and().rememberMe() //if the HTTP parameter named "remember-me" exists ,then the user will be remembered even after their always
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/auth/loginOut"))
                .and()
                .sessionManagement()
                .maximumSessions(1) //only one can login in
                .expiredUrl("/auth/shotOff");

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
