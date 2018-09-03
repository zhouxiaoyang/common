package com.dzqd.comondao.config;




import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.autoconfigure.SpringBootVFS;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.MybatisXMLLanguageDriver;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.dzqd.comondao.datasource.DynamicDataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.type.JdbcType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: Winston Yang
 * @Date: Create in 14:41 2018/8/6
 * @Modified by:
 */

@Configuration
public class DataSourceConfig {
    @Value("${spring.datasource.default.url}")
    private String defaultDBUrl;
    @Value("${spring.datasource.default.username}")
    private String defaultDBUser;
    @Value("${spring.datasource.default.password}")
    private String defaultDBPassword;
    @Value("${spring.datasource.default.driver-class-name}")
    private String defaultDBDreiverName;


    @Bean
    public DynamicDataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = DynamicDataSource.getInstance();

        DruidDataSource defaultDataSource = new DruidDataSource();
        defaultDataSource.setUrl(defaultDBUrl);
        defaultDataSource.setUsername(defaultDBUser);
        defaultDataSource.setPassword(defaultDBPassword);
        defaultDataSource.setDriverClassName(defaultDBDreiverName);

        Map<Object,Object> map = new HashMap<>();
        map.put("master", defaultDataSource);
        //map.put("master", masterDataSource);
        dynamicDataSource.setTargetDataSources(map);
        dynamicDataSource.setDefaultTargetDataSource(defaultDataSource);

        return dynamicDataSource;
    }
    @Bean("mybatisSqlSession")
    public MybatisSqlSessionFactoryBean sqlSessionFactory(@Qualifier("dynamicDataSource") DataSource dynamicDataSource, ResourceLoader resourceLoader
                                                         /* GlobalConfiguration globalConfiguration*/) throws Exception {
        //globalConfiguration.
        GlobalConfig globalConfig=new GlobalConfig();
        //设置主键策略为数据库自增, 字段忽略非空判断 dbtype 为mysql
        globalConfig.setDbConfig(new GlobalConfig.DbConfig()
                .setIdType(IdType.AUTO).setDbType(DbType.MYSQL).setFieldStrategy(FieldStrategy.IGNORED));
        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
        sqlSessionFactory.setVfs(SpringBootVFS.class);
        sqlSessionFactory.setDataSource(dynamicDataSource);
        sqlSessionFactory.setTypeAliasesPackage("com.dzqd.**.entity*");
        sqlSessionFactory
                .setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:/mapper/*Mapper.xml"));
        MybatisConfiguration configuration = new MybatisConfiguration();
        configuration.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        sqlSessionFactory.setConfiguration(configuration);
        //分页插件
        sqlSessionFactory.setPlugins(new Interceptor[] { new PaginationInterceptor(), new PerformanceInterceptor(),
                new OptimisticLockerInterceptor() });
        sqlSessionFactory.setGlobalConfig(globalConfig);
        return sqlSessionFactory;
    }
    /**
     *   mybatis-plus分页插件
     */
//    @Bean
//    public PaginationInterceptor paginationInterceptor() {
//        PaginationInterceptor page = new PaginationInterceptor();
//        page.setDialectType("mysql");
//        return page;
//    }

//    @Bean
//    public SqlSessionFactory sqlSessionFactory(
//            @Qualifier("dynamicDataSource") DataSource dynamicDataSource)
//            throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dynamicDataSource);
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
//                .getResources("classpath*:mapper/*.xml"));
//        return bean.getObject();
//
//    }
//
//    @Bean(name = "sqlSessionTemplate")
//    public SqlSessionTemplate sqlSessionTemplate(
//            @Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory)
//            throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
}
