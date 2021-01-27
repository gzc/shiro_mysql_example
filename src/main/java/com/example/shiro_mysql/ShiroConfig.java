package com.example.shiro_mysql;

import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager);

        HashMap<String, String> filterChain = new HashMap<>();
        filterChain.put("/index", "anon");
        filterChain.put("/**","authcBasic");
        factoryBean.setFilterChainDefinitionMap(filterChain);

        return factoryBean;
    }

}
