package org.zhxie.firstappdemo.transational.annotation;


import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Transactional
@Service(value = "transactionalService")
public @interface TransactionalService {

//    @AliasFor("value")
    String name() default "txManager";

//    @AliasFor(attribute =  "transactionManager", annotation =  Transactional.class)
//    String manager() default "txManager";
//    String transactionManager() default  "txManager";

//    @AliasFor("name")
    String value () default  "txManager3";
}