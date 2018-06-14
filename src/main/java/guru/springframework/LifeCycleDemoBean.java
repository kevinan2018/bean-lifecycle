package guru.springframework;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class LifeCycleDemoBean implements InitializingBean, DisposableBean, BeanNameAware,
        BeanFactoryAware, ApplicationContextAware {

    public LifeCycleDemoBean() {
        System.out.println("## Ctor() I'm in the LifeCycleBean Constructor");
    }

    // interface BeanNameAware extends Aware
    @Override
    public void setBeanName(String name) {
        System.out.println("## setBeanName(name) My bean Name is : " + name);
    }

    // interface BeanFactoryAware extends Aware
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("## setBeanFactory(beanFactory) Bean Factory has been set!");
    }

    // interface ApplicationContextAware extends Aware
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("## setApplicationContext(appcontext) Application context has been set!");
    }

    // BeanPostProcessor callbacks, called in CustomBeanPostProcessor
    public void beforeInit(){
        System.out.println("## beforeInit() - Before Init - Called by Bean Post Processor");
    }

    // annotated interfaces
    @PostConstruct
    public void postConstruct(){
        System.out.println("## postConstruct() The Post Construct annotated method has been called!");
    }

    // interface InitializingBean
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("## afterPropertiesSet() The LifeCycleBean has its properties set!");
    }

    // BeanPostProcessor callbacks, called in CustomBeanPostProcessor
    public void afterInit(){
        System.out.println("## afterInit() - After Init - called by Bean Post Processor");
    }

    // annotated interfaces
    @PreDestroy
    public void preDestroy(){
        System.out.println("## preDestroy() the Predestroy annotated method has been called!");
    }

    //interface DisposableBean
    @Override
    public void destroy() throws Exception {
        System.out.println("## destroy() The LifeCycle bean has been terminated!");
    }

}
