package com.example.ejemploweb.service.impl;

import com.example.ejemploweb.repository.UserRepository;
import java.lang.Class;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link UserDetailsServiceImpl}.
 */
public class UserDetailsServiceImpl__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'userDetailsServiceImpl'.
   */
  private static BeanInstanceSupplier<UserDetailsServiceImpl> getUserDetailsServiceImplInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<UserDetailsServiceImpl>forConstructor(UserRepository.class)
            .withGenerator((registeredBean, args) -> new UserDetailsServiceImpl(args.get(0)));
  }

  /**
   * Get the bean definition for 'userDetailsServiceImpl'.
   */
  public static BeanDefinition getUserDetailsServiceImplBeanDefinition() {
    Class<?> beanType = UserDetailsServiceImpl.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getUserDetailsServiceImplInstanceSupplier());
    return beanDefinition;
  }
}
