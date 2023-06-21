package tgkt.togaform.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class ErrorPageConf implements ErrorPageRegistrar {
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        var page404 = new ErrorPage(HttpStatus.NOT_FOUND,
                "/error/404.html");
        registry.addErrorPages(page404);

        var page405 = new ErrorPage(HttpStatus.METHOD_NOT_ALLOWED,
                "/error/405.html");
        registry.addErrorPages(page405);
    }
}
