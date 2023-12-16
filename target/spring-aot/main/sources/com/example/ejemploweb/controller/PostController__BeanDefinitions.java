package com.example.ejemploweb.controller;

import com.example.ejemploweb.repository.UserRepository;
import com.example.ejemploweb.service.CategoryPostService;
import com.example.ejemploweb.service.PostService;
import java.lang.Class;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link PostController}.
 */
public class PostController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'postController'.
   */
  private static BeanInstanceSupplier<PostController> getPostControllerInstanceSupplier() {
    return BeanInstanceSupplier.<PostController>forConstructor(PostService.class, CategoryPostService.class, UserRepository.class)
            .withGenerator((registeredBean, args) -> new PostController(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'postController'.
   */
  public static BeanDefinition getPostControllerBeanDefinition() {
    Class<?> beanType = PostController.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getPostControllerInstanceSupplier());
    return beanDefinition;
  }
}
