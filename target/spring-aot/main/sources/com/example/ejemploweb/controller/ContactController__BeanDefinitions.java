package com.example.ejemploweb.controller;

import com.example.ejemploweb.repository.UserRepository;
import com.example.ejemploweb.service.ContactService;
import java.lang.Class;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ContactController}.
 */
public class ContactController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'contactController'.
   */
  private static BeanInstanceSupplier<ContactController> getContactControllerInstanceSupplier() {
    return BeanInstanceSupplier.<ContactController>forConstructor(ContactService.class, UserRepository.class)
            .withGenerator((registeredBean, args) -> new ContactController(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'contactController'.
   */
  public static BeanDefinition getContactControllerBeanDefinition() {
    Class<?> beanType = ContactController.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getContactControllerInstanceSupplier());
    return beanDefinition;
  }
}
