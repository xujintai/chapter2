package com.springboot.chapter5mybatis.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

@SpringBootApplication(scanBasePackages = {"com.springboot.chapter5mybatis"})
//方式3：使用@MapperScan定义扫描
@MapperScan(
        //定义扫描包
        basePackages = "com.springboot.chapter5mybatis.*",
        //指定 SqlSessionFactory ，如果 SqlSessionTimplate 被指定，则作废
        sqlSessionFactoryRef = "sqlSessionFactory",
        // 指定 SqlSessionTimplate ，将忽略 SqlSessionFactory 的配置
        sqlSessionTemplateRef = "sqlSessionTemplate",
        //markerInterface = Class.class,//限定接口扫描，不常用
        annotationClass = Repository.class
)
public class Chapter5Application {

//    //方式1： 使用 MapperFactoryBean 装配MyBatis接口
//    @Autowired
//    SqlSessionFactory sqlSessionFactory = null;
//    // 定义一个MyBatis的Mapper接口
//    @Bean
//    public MapperFactoryBean<MyBatisUserDao> initMyBatisUserDao(){
//        MapperFactoryBean<MyBatisUserDao> bean = new MapperFactoryBean<>();
//        bean.setMapperInterface(MyBatisUserDao.class);
//        bean.setSqlSessionFactory(sqlSessionFactory);
//        return bean;
//    }

    //方式2：使用 MapperScannerConfigurer 扫描装配 MyBatis 接口
    /**
     * 配置MyBatis接口扫描
     * @return 返回扫描器
     */
//    @Bean
//    public MapperScannerConfigurer mapperScannerConfigurer(){
//        //定义扫描器实例
//        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//        // 加载 SqlSessionFactory，Spring Boot 会自动生产，SqlSessionFactory实例
//        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
//        //定义扫描的包
//        mapperScannerConfigurer.setBasePackage("com.springboot.chapter5mybatis.*");
//        //限定被标注@Repository的接口才被扫描
//        mapperScannerConfigurer.setAnnotationClass(Repository.class);
//        //通过继承某个接口限制扫描，一般使用不多
//        //mapperScannerConfigurer.setMarkerInterface();
//        return mapperScannerConfigurer;
//    }

    //方式3：使用@MapperScan定义扫描


    public static void main(String[] args) {
        SpringApplication.run(Chapter5Application.class,args);
    }
}
