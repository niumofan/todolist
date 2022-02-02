package com.todolist_test2.demo.config;

//import com.todolist_test2.demo.component.security.*;

/**
 * @author nmf
 * @date 2021年11月02日 10:43
 */
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
public class WebSecurityConfig {
//    @Autowired
//    private CustomizeAuthenticationEntryPoint authenticationEntryPoint;
//
//    @Autowired
//    private CustomizeAuthenticationSuccessHandler authenticationSuccessHandler;
//
//    @Autowired
//    private CustomizeAuthenticationFailureHandler authenticationFailureHandler;
//
//    @Autowired
//    private CustomizeLogoutSuccessHandler logoutSuccessHandler;
//
//    @Autowired
//    private CustomizeSessionInformationExpiredStrategy sessionInformationExpiredStrategy;
//
//    @Autowired
//    private AccessDecisionManager accessDecisionManager;
//
//    @Autowired
//    private FilterInvocationSecurityMetadataSource securityMetadataSource;
//
//    @Autowired
//    private CustomizeAbstractSecurityInterceptor securityInterceptor;
//
//    @Autowired
//    private CustomizeAccessDeniedHandler accessDeniedHandler;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        //配置认证方式等
//        auth.userDetailsService(userDetailsService());
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        //http相关的配置，包括登入登出、异常处理、会话管理等
//
//        http.rememberMe().alwaysRemember(true).userDetailsService(username -> {
//            SecurityUser suser = new SecurityUser();
//            User user = new User();
//            user.setUsername("user1");
//            user.setPassword("user1");
//            suser.setUser(user);
//            return suser;
//        });
//
//        http.cors().and().csrf().disable();
////        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        http.headers().cacheControl();
//        http.
//                authorizeRequests().
//                    withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
//                        @Override
//                        public <O extends FilterSecurityInterceptor> O postProcess(O o) {
//                            o.setAccessDecisionManager(accessDecisionManager);//访问决策管理器
//                            o.setSecurityMetadataSource(securityMetadataSource);//安全元数据源
//                            return o;
//                        }
//                    }).
//            and().
//                exceptionHandling().
//                    accessDeniedHandler(accessDeniedHandler).
//                    authenticationEntryPoint(authenticationEntryPoint).
//            and().
//                formLogin().permitAll().
//                    successHandler(authenticationSuccessHandler).
//                    failureHandler(authenticationFailureHandler).
//            and().
//                logout().permitAll().
//                    logoutSuccessHandler(logoutSuccessHandler).//登出成功处理逻辑
//                    deleteCookies("JSESSIONID").//登出之后删除cookie
//            and().
//                sessionManagement().
//                    maximumSessions(1).
//                    expiredSessionStrategy(sessionInformationExpiredStrategy)
//        ;
//
//        http.authorizeRequests().
//                withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
//                    @Override
//                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
//                        o.setAccessDecisionManager(accessDecisionManager);//访问决策管理器
//                        o.setSecurityMetadataSource(securityMetadataSource);//安全元数据源
//                        return o;
//                    }
//                });
//        http.addFilterBefore(securityInterceptor, FilterSecurityInterceptor.class);//增加到默认拦截链中
//        http.addFilterAfter(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
////        http.authorizeRequests().anyRequest().permitAll();
//        http.authorizeRequests().anyRequest().authenticated();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        //获取用户账号密码及权限信息
//        return new UserServiceImpl();
//    }
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        // 设置默认的加密方式（强hash方式加密）
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() {
//        return new JwtAuthenticationTokenFilter();
//    }
}
