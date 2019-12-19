package com.bahu.buffzs.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.servlet.MultipartConfigElement;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;

/**
 * @program: buffzs_admin
 * @description:
 * @author: Mr.Baron
 * @create: 2019-09-12
 **/

@Configuration
public class MyPicConfig extends WebMvcConfigurationSupport {
    @Value("${file.filepath}")
    private String mImagesPath;

    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //文件最大KB,MB
        factory.setMaxFileSize("2048MB");
        //设置总上传数据总大小
        factory.setMaxRequestSize("2048MB");
        //factory.setLocation("D:/img/");
        return factory.createMultipartConfig();
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {

        Properties properties = System.getProperties();
        String name = properties.getProperty("os.name");
        System.out.println("当前系统是:" + name);
        String property = properties.getProperty("os.version");
        if (name.indexOf("Windows") == -1){
            String substring1 = mImagesPath.substring(0, 5);
            String substring = mImagesPath.substring(8, 13);
            mImagesPath = substring1 + substring;
        }

        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/img/**").addResourceLocations(mImagesPath);
        System.out.print("2.上传配置类mImagesPath=="+mImagesPath+"\n");
        super.addResourceHandlers(registry);
    }

    @Bean
    public MappingJackson2HttpMessageConverter jackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        converter.setObjectMapper(mapper);
        return converter;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //将我们定义的时间格式转换器添加到转换器列表中,
        //这样jackson格式化时候但凡遇到Date类型就会转换成我们定义的格式
        converters.add(jackson2HttpMessageConverter());
    }


}