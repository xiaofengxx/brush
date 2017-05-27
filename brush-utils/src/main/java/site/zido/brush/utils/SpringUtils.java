package site.zido.brush.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;

/**
 * description:
 * <p>fill description</p>
 *
 * @author zido
 * @since 2017/5/25 0025
 */
public class SpringUtils {
    /** Spring框架应用上下文对象 */
    private static ApplicationContext context;

    static{
        context = getApplicationContext();
    }

    public static void setFactoryBean(ApplicationContext context){
        SpringUtils.context = context;
    }

    public static ApplicationContext getApplicationContext() {
        return context;
    }

    public static <T> T getBean(String name, Class<T> requiredType)
            throws BeansException {
        return context.getBean(name, requiredType);
    }

    public static boolean isSingleton(String name)
            throws NoSuchBeanDefinitionException {
        return context.isSingleton(name);
    }

    public static <T> T getBean(Class<T> requiredType)
            throws BeansException {
        return context.getBean(requiredType);
    }

    public static Class<? extends Object> getType(String name)
            throws NoSuchBeanDefinitionException {
        return context.getType(name);
    }
}
