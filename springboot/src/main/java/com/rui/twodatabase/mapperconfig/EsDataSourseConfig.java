package com.rui.twodatabase.mapperconfig;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import javax.sql.DataSource;

@Configuration
// 扫描 Mapper 接口并容器管理
@MapperScan(basePackages = EsDataSourseConfig.PACKAGE, sqlSessionFactoryRef = "esSqlSessionFactory")
public class EsDataSourseConfig {
    // 精确到 es 目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.rui.twodatabase.dao.es";
    static final String MAPPER_LOCATION = "classpath:mapper/cluster/*.xml";
    @Value("${es.esDataSource.mapperLocations}")
    private String esMapperLocations;

    @Value("${es.esDataSource.url}")
    private String esUrl;

    @Value("${es.esDataSource.driver-class-name}")
    private String driverClass;
    @Value("${es.esDataSource.configLocation}")
    private String configLocation;

    @Value("${es.esDataSource.username}")
    private String username;

    @Value("${es.esDataSource.password}")
    private String password;


    @Bean(name = "esDataSource")
    @ConfigurationProperties(prefix="spring.esDataSource")
    public DataSource esDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setUrl(esUrl);
        return dataSource;
    }
    @Bean("esSqlSessionFactory")
    public SqlSessionFactory esSessionFactory() throws Exception {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(esMapperLocations));
        sqlSessionFactory.setConfigLocation(resolver.getResource(configLocation));
        sqlSessionFactory.setDataSource(esDataSource());
        return sqlSessionFactory.getObject();
    }
}
