package com.bahu.buffzs.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: buffzs
 * @description:
 * @author: Mr.Baron
 * @create: 2019-09-20
 **/

@Configuration
@EnableSwagger2
public class Swagger2Config {

    /**
     * 创建API应用
     * apiInfo() 增加API相关信息
     * 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
     * 本例采用指定扫描的包路径来定义指定要建立API的目录。
     *
     * @return
     */
    @Bean
    public Docket createRestApi() {
        //添加head参数配置start
        List<Parameter> pars = new ArrayList<>();
        ParameterBuilder tokenPar = new ParameterBuilder();
        ParameterBuilder tokenPar2 = new ParameterBuilder();
        ParameterBuilder userId = new ParameterBuilder();
        /*tokenPar.name("genres").description("5").
                modelRef(new ModelRef("string")).
                parameterType("header").
                required(false).build();
        pars.add(tokenPar.build());*/

        /*tokenPar2.name("headerUserToken").description("用户token").
                modelRef(new ModelRef("string")).
                parameterType("header").required(false).build();
        pars.add(tokenPar2.build());*/

        /*userId.name("userId").description("用户id").
                modelRef(new ModelRef("int")).
                parameterType("header").required(false).build();
        pars.add(userId.build());*/

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //.apis(RequestHandlerSelectors.basePackage("com.buffzs.user.controller"))
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars);
    }

    /**
     * 创建该API的基本信息（这些基本信息会展现在文档页面中）
     * 访问地址：http://项目实际地址/swagger-ui.html
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("buffzs-API接口文档")
                .description("更多请关注http://www.baidu.com")
                .termsOfServiceUrl("http://www.baidu.com")
                .contact("sunf")
                .version("1.0")
                .build();
    }

}
