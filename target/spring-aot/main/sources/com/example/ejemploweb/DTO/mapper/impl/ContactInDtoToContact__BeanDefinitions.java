package com.example.ejemploweb.DTO.mapper.impl;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ContactInDtoToContact}.
 */
public class ContactInDtoToContact__BeanDefinitions {
  /**
   * Get the bean definition for 'contactInDtoToContact'.
   */
  public static BeanDefinition getContactInDtoToContactBeanDefinition() {
    Class<?> beanType = ContactInDtoToContact.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(ContactInDtoToContact::new);
    return beanDefinition;
  }
}
