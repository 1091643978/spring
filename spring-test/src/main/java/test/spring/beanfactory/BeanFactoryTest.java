package test.spring.beanfactory;

import org.springframework.beans.factory.parsing.ReaderEventListener;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import test.spring.lisenters.MyReaderEventListener;

public class BeanFactoryTest {

    public static void main(String[] args) {
        ReaderEventListener eventListener = new MyReaderEventListener();

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.setEventListener(eventListener);
        reader.loadBeanDefinitions("spring-bean.xml");
        IocService iocService = beanFactory.getBean("iocService", IocService.class);

        iocService.hi();
    }

}
