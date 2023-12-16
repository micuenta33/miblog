package com.example.ejemploweb;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link EjemplowebApplication}.
 */
public class EjemplowebApplication__BeanDefinitions {
  /**
   * Get the bean definition for 'ejemplowebApplication'.
   */
  public static BeanDefinition getEjemplowebApplicationBeanDefinition() {
    Class<?> beanType = EjemplowebApplication.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    ConfigurationClassUtils.initializeConfigurationClass(EjemplowebApplication.class);
    beanDefinition.setInstanceSupplier(EjemplowebApplication$$SpringCGLIB$$0::new);
    return beanDefinition;
  }
}
