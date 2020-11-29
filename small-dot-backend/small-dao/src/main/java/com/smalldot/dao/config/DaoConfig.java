package com.smalldot.dao.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.DialectModel;
import com.baomidou.mybatisplus.extension.plugins.pagination.dialects.IDialect;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@MapperScan("com.smalldot.dao.mapper")
public class DaoConfig {
    @Resource
    private DataSourceConfig config;

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        Interceptor[] plugins = {paginationInterceptor()};
        sqlSessionFactory.setPlugins(plugins);
        return sqlSessionFactory.getObject();
    }

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.type(HikariDataSource.class);
        dataSourceBuilder.url(config.getUrl()).driverClassName(config.getDriverClassName()).password(config.getPassword()).username(config.getUserName());
        return dataSourceBuilder.build();
    }
}
