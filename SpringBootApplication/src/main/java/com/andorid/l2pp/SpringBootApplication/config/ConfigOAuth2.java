package com.andorid.l2pp.SpringBootApplication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class ConfigOAuth2 extends AuthorizationServerConfigurerAdapter{

    private String clientId = "andor";
    private String clientSecret = "andor-secret-key";
    private String privateKey = "-----BEGIN RSA PRIVATE KEY-----\n" +
        "MIIEowIBAAKCAQEA6iRZU7K8TmOFV7rgmRgwEV/YzXlohoixtYa69hZIrOAjDbRh\n" +
        "VBi3iPfkO2ZF1pytTaTHAHZQkliucItJEqSNLYBkTNnaU0Rv3XiqgNt2UTaieGbB\n" +
        "DHuclylMT6iq35Bxotl81JZcj3UeunDsILUeC1vX5Dv44UgnReqrz1KFiHkHmYxJ\n" +
        "uxMMXcM5gPipTU0H1BR9YeGB55Ec1MsvDpLraOmhNqbaWnup7BMs8FotlX/EysIO\n" +
        "ro+8crXgzT5iMbFly5ngOsC7nyUF0T0zu8yIHdj+SAmf8RzGM+1g5OU7a6Wr/Bwq\n" +
        "nG5vlkB6lPX66t4YfBsN8TLqJil+7PRw3NwdYwIDAQABAoIBAEkr/OKETAbvYR+O\n" +
        "nlwZzAPSAU4NcBYDKA5Dwa/gPOwRy8KfqX7/jnP2jFPn3VF5e0t1gF9rmjhyEGnJ\n" +
        "jZeO5zPeGPpPZsR48cCz0g0dCLfOrC2WZyRAiSpQVLHcUzI00N6Eu1cwelK21liL\n" +
        "q695Cp+gHzMLbvbwdp2J/hF3h5WjLBqAGZVaUzbquLUZszqP9Th3QtJLa/3vqYlw\n" +
        "6XLvi5sY10pX81TCI8GEiN4tINYVEi8o0R61VhkZPDj1IqUoxLtm2inGwJuoyOEe\n" +
        "xgGF3x7tGm9Ov+i7fWNPMkhLdG0pN34kkRbT73ikyrtBuECYcBbwiQ49hq/ZeCfT\n" +
        "siX4X3kCgYEA/P3Vo5zn/IM8Q46f/ImSPRFL04uCVVcPQS5sBR346gAzlyBYDsgy\n" +
        "6GyPQYQHC7ZCYUvms5BysvpXQNAwUDOsywIDPHs7rQsMYdQAHu8SjfT1gllEv7VK\n" +
        "07bjNTpKIA+c5gq95+Xe14m3iLCsXRn3yiW6A6xo4sdbo77+UL9pA3UCgYEA7O0h\n" +
        "x7XmQhkf+6LYXVCu1TR/TQj0Kcj/DviZf/Zp83oHl9PyDcWWm63iaQIUeQPgbWeY\n" +
        "cXXA4aRGnA+v5HDYPuPK17APHtKTZyGA8FkInYRLOXsVu1RWw6SrAVzDUiYtycnE\n" +
        "9xY+UbUpMeNU/AuDXWHIf2QK+f3E+BMNVk3XOncCgYAdsX09stDXpl+QXlEQxuTP\n" +
        "HhSUQ6+MbKdxsw0inJ32eQeVGUq8kWrINNWrjt901HN+D/aH5NBRiWhsRwMkpqwF\n" +
        "N7tBggVDDiTp5oQNHWpEFxgpsGiNR638o16PhMPmd26m4WPgr+4zxgowlOvmEYIv\n" +
        "y7XFcJru4w8ybNxUheLBcQKBgGam+4rW8hPTZPsW/F259nYjz8Alz/xGvNPUvFUo\n" +
        "A5HdXmrXBroW0QFUnpNWtl4UYumkB/WoylA5Z+p4FYKJrffZpGo9Ot/k5r65Um9Q\n" +
        "dB4jUqBuBuVqTkloEDt/4JS4PACA7lkMByZJsraNw6WMq3cLRd6EDwlvfSbqwk2R\n" +
        "Xl5TAoGBAIiv1HLVoBOBnyw1+M0x9cPY/rFCMd2DaAn7rCJYqqvMTDrbMjMmasCi\n" +
        "EBJzoq4QpRxcDpO4tLuj7Cv4oMBzjS0Xs4iXUAu5wQLAUqH5cW6WwNzYKuEyrFfL\n" +
        "6Qtzj0iOOY4cjKTj+DpgEVOo7VRfDuTNOqqgo0Q0+WTna05A5k7a\n" +
        "-----END RSA PRIVATE KEY-----";
    private String publicKey = "-----BEGIN PUBLIC KEY-----\n" +
        "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA6iRZU7K8TmOFV7rgmRgw\n" +
        "EV/YzXlohoixtYa69hZIrOAjDbRhVBi3iPfkO2ZF1pytTaTHAHZQkliucItJEqSN\n" +
        "LYBkTNnaU0Rv3XiqgNt2UTaieGbBDHuclylMT6iq35Bxotl81JZcj3UeunDsILUe\n" +
        "C1vX5Dv44UgnReqrz1KFiHkHmYxJuxMMXcM5gPipTU0H1BR9YeGB55Ec1MsvDpLr\n" +
        "aOmhNqbaWnup7BMs8FotlX/EysIOro+8crXgzT5iMbFly5ngOsC7nyUF0T0zu8yI\n" +
        "Hdj+SAmf8RzGM+1g5OU7a6Wr/BwqnG5vlkB6lPX66t4YfBsN8TLqJil+7PRw3Nwd\n" +
        "YwIDAQAB\n" +
        "-----END PUBLIC KEY-----";

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Bean
    public JwtAccessTokenConverter tokenEnhancer() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(privateKey);
        converter.setVerifierKey(publicKey);
        return converter;
    }

    @Bean
    public JwtTokenStore tokenStore() {
        return new JwtTokenStore(tokenEnhancer());
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager).tokenStore(tokenStore())
            .accessTokenConverter(tokenEnhancer());
    }
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory().withClient(clientId).secret(passwordEncoder.encode(clientSecret)).scopes("read", "write")
            .authorizedGrantTypes("password", "refresh_token").accessTokenValiditySeconds(20000)
            .refreshTokenValiditySeconds(20000);

    }

}
