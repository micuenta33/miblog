package com.example.ejemploweb.DTO.mapper.impl;

import java.lang.Class;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Bean definitions for {@link UserInDtoToUser}.
 */
public class UserInDtoToUser__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'userInDtoToUser'.
   */
  private static BeanInstanceSupplier<UserInDtoToUser> getUserInDtoToUserInstanceSupplier() {
    return BeanInstanceSupplier.<UserInDtoToUser>forConstructor(PasswordEncoder.class)
            .withGenerator((registeredBean, args) -> new UserInDtoToUser(args.get(0)));
  }

  /**
   * Get the bean definition for 'userInDtoToUser'.
   */
  public static BeanDefinition getUserInDtoToUserBeanDefinition() {
    Class<?> beanType = UserInDtoToUser.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getUserInDtoToUserInstanceSupplier());
    return beanDefinition;
  }
}
