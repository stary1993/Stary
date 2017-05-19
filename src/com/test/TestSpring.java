package com.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.entity.StudentInfos;

public class TestSpring {
/** 1)对象创建：单例和多例
	scope="singleton" 默认为单例 用于 dao service 工具类
	scope="prototype" 多例 用于 action对象
	2)什么时候创建？
	scope="singleton" 在启动（容器初始化之前），就已经创建bean，且整个应用只有一个
	scope="prototype" 在用到的时候，才创建对象
**/
//1.通过工厂类获取IOC容器创建的对象
	@Test
	public void test1() {
//		加载配置文件 SpringIOC容器
		Resource resource=new  ClassPathResource("applicationContext.xml");
//		建立bean工厂（创建IOC容器对象）
		BeanFactory beanFactory=new XmlBeanFactory(resource);
//		获取容器创建的对象
		StudentInfos infos1=(StudentInfos) beanFactory.getBean("infos");//ID名 唯一标识
		StudentInfos infos2=(StudentInfos) beanFactory.getBean("infos");//ID名 唯一标识
	
		System.out.println("1.1:"+infos1);
		System.out.println("1.2:"+infos2);
		
	}
//	2.直接获取IOC创建的对象
	@Test
	public void test2() {
//		获取IOC容器对象
		ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
//		从容器中获取bean
		StudentInfos infos1=(StudentInfos) ac.getBean("infos");
		StudentInfos infos2=(StudentInfos) ac.getBean("infos");
		
	System.out.println("2.1:"+infos1);
	System.out.println("2.2:"+infos2);
	}

}
