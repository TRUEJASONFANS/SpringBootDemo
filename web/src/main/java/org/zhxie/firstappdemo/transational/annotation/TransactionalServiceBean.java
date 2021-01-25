package org.zhxie.firstappdemo.transational.annotation;

@TransactionalService
public class TransactionalServiceBean {

    public void save() {
        System.out.println("保存操作。。");
    }
}
