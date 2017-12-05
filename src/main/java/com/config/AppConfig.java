package com.config;

import com.google.common.collect.Lists;
import feign.Request;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import java.nio.charset.Charset;
import java.util.List;

@Configuration
public class AppConfig extends WebMvcConfigurationSupport {
    @Bean
    @Primary
    Retryer retryer() {
        return Retryer.NEVER_RETRY;
    }

    @Bean
    Request.Options options() {
        return new Request.Options(30000, 30 * 1000);
    }

    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.addAll(CONVERTER);
        super.addDefaultHttpMessageConverters(converters);
    }

    public final List<HttpMessageConverter<?>> CONVERTER = Lists.newArrayList(
            FormMessageConverter.INSTANCE,
            StringMessageConverter.INSTANCE
    );


    public static class FormMessageConverter extends FormHttpMessageConverter {
        public static final FormMessageConverter INSTANCE = new FormMessageConverter();

        private FormMessageConverter() {
            setCharset(DEFAULT_CHARSET);
            List<HttpMessageConverter<?>> partConverters = Lists.newArrayList();
            partConverters.add(new ByteArrayHttpMessageConverter());
            partConverters.add(StringMessageConverter.INSTANCE);
            partConverters.add(new SourceHttpMessageConverter());
            super.setPartConverters(partConverters);
        }
    }

    public static class StringMessageConverter extends StringHttpMessageConverter {
        public static final StringMessageConverter INSTANCE = new StringMessageConverter();

        private StringMessageConverter() {
            super.setDefaultCharset(Charset.forName("UTF-8"));
            super.setWriteAcceptCharset(false);
        }
    }
}
