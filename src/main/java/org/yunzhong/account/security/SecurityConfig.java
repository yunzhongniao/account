package org.yunzhong.account.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // 启用方法级别的权限认证
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AccountUserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 允许所有用户访问"/"和"/index.html"
        http.authorizeRequests().antMatchers("/", "/index.html").permitAll() // 定义不需要认证就可以访问
                .antMatchers("/level1/**").hasRole("VIP1") // 需要拥有VIP1权限
                .anyRequest().authenticated() // 其他地址的访问均需验证权限
                .and()
                // 开启cookie保存用户数据
                .rememberMe()
                // 设置cookie有效期
                .tokenValiditySeconds(60 * 60 * 24 * 7).and().formLogin() // 定义当需要用户登录时候，转到的登录页面
                .loginPage("/login.html") // 登录页
                .failureUrl("/login-error.html").permitAll().and().logout().logoutSuccessUrl("/index.html");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        /*
         * auth.inMemoryAuthentication()
         * .withUser("admin").password("123456").roles("USER");
         */
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 静态资源忽略认证
        web.ignoring().antMatchers("/css/**");
    }

    /**
     * 配置登录验证
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new AccountPasswordEncoder();
    }

}
