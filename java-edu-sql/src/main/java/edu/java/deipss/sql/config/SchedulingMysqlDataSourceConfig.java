package edu.java.deipss.sql.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

@ConfigurationProperties(prefix = "scheduling.mysql")
@Configuration
@MapperScan(value = "edu.java.deipss.sql.dal.mapper", sqlSessionTemplateRef = "schedulingSqlSessionTemplate")
public class SchedulingMysqlDataSourceConfig {

    public static final String SCHEDULING_TRANSACTION_TEMPLATE = "schedulingTransactionTemplate";
    public static final String SCHEDULING_TRANSACTION_MANAGER = "schedulingTransactionManager";
    public static final String SCHEDULING_SQL_SESSION_TEMPLATE = "schedulingSqlSessionTemplate";
    public static final String SCHEDULING_DATA_SOURCE = "schedulingDataSource";
    @Value("${scheduling.mysql.username}")
    private String username;
    @Value("${scheduling.mysql.password}")
    private String password;
    @Value("${scheduling.mysql.url}")
    private String url;

    @Bean("schedulingSqlSessionFactory")
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("schedulingDataSource") DataSource ds) throws Exception {
        MybatisSqlSessionFactoryBean factoryBean = new MybatisSqlSessionFactoryBean();
        // mybatis配置
        MybatisConfiguration mybatisConfiguration = new MybatisConfiguration();
        // sql打印
        mybatisConfiguration.setLogImpl(StdOutImpl.class);
        factoryBean.setConfiguration(mybatisConfiguration);
        // mybatis handle 指定
        factoryBean.setTypeHandlersPackage("edu.java.deipss.sql.dal.handler");
        // 分页插件
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));

        factoryBean.setPlugins(interceptor);
        factoryBean.setDataSource(ds);
        return factoryBean.getObject();
    }

    /**
     *
     * @param tx 事务管理器
     * @return 事务管理模版
     */
    @Bean(SCHEDULING_TRANSACTION_TEMPLATE)
    public TransactionTemplate transactionTemplate(@Qualifier("schedulingTransactionManager") PlatformTransactionManager tx) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(tx);
        transactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        transactionTemplate.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        transactionTemplate.setTimeout(30000);
        return transactionTemplate;
    }


    @Bean(SCHEDULING_TRANSACTION_MANAGER)
    public PlatformTransactionManager transactionManager(@Qualifier("schedulingDataSource") DataSource ds) {
        return new DataSourceTransactionManager(ds);
    }

    @Bean(SCHEDULING_SQL_SESSION_TEMPLATE)
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("schedulingSqlSessionFactory") SqlSessionFactory factory) {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(factory);
        return sqlSessionTemplate;
    }

    @Bean(SCHEDULING_DATA_SOURCE)
    public DataSource dataSource() {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setPassword(password);
        mysqlDataSource.setUser(username);
        mysqlDataSource.setUrl(url);
        return mysqlDataSource;
    }

}
