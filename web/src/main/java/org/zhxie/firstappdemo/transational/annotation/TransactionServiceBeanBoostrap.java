package org.zhxie.firstappdemo.transational.annotation;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.SimpleTransactionStatus;

import java.util.Map;


@Configuration
@ComponentScan(basePackageClasses = TransactionalServiceBean.class)
@EnableTransactionManagement
public class TransactionServiceBeanBoostrap {


    public static void main(String[] args) {
        System.out.println("Start to the context");
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(TransactionServiceBeanBoostrap.class);
        Map<String, TransactionalServiceBean> beanMap = context.getBeansOfType(TransactionalServiceBean.class);
        beanMap.forEach((beanName, bean) -> {
            System.out.printf("Bean 名称： %s, 对象 ： %s\n", beanName, bean);
            bean.save();
        });
        context.close();
        System.out.println("End to the context");
    }

    @Bean("txManager")
    public PlatformTransactionManager txManager() {
        return new PlatformTransactionManager() {
            @Override
            public TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionException {
                return new SimpleTransactionStatus();
            }

            @Override
            public void commit(TransactionStatus status) throws TransactionException {
                System.out.println("txManager :事务提交");
            }

            @Override
            public void rollback(TransactionStatus status) throws TransactionException {

            }
        };
    }

    @Bean("txManager2")
    public PlatformTransactionManager txManager2() {
        return new PlatformTransactionManager() {
            @Override
            public TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionException {
                return new SimpleTransactionStatus();
            }

            @Override
            public void commit(TransactionStatus status) throws TransactionException {
                System.out.println("txManager2 :事务提交");
            }

            @Override
            public void rollback(TransactionStatus status) throws TransactionException {

            }
        };
    }

}
