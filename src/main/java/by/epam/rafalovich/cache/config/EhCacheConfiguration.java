package by.epam.rafalovich.cache.config;

import net.sf.ehcache.management.ManagementService;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jmx.support.MBeanServerFactoryBean;

@EnableJpaRepositories(basePackages = "com.techprimers.cache.repository")
@EnableCaching
@Configuration
public class EhCacheConfiguration
{
    //    @Bean
    //    public EhCacheManagerFactoryBean cacheMangerFactory()
    //    {
    //        EhCacheManagerFactoryBean bean = new EhCacheManagerFactoryBean();
    //        bean.setConfigLocation(new ClassPathResource("ehcache.xml"));
    //        bean.setShared(true);
    //
    //        return bean;
    //    }

    @Bean
    public EhCacheCacheManager ehCacheCacheManager()
    {
        return new EhCacheCacheManager()
        {
            @Override
            protected Cache getMissingCache(String name)
            {
                Cache missingCache = super.getMissingCache(name);
                if (missingCache == null)
                {
                    getCacheManager().addCache(name);
                    missingCache = new EhCacheCache(getCacheManager().getEhcache(name));
                }
                return missingCache;
            }
        };
    }

    @Bean
    public MBeanServerFactoryBean mbeanServer()
    {
        MBeanServerFactoryBean bean = new MBeanServerFactoryBean();
        bean.setLocateExistingServerIfPossible(true);

        return bean;
    }

    @Bean(initMethod = "init", destroyMethod = "dispose")
    public ManagementService managementService()
    {
        return new ManagementService(ehCacheCacheManager().getCacheManager(), mbeanServer().getObject(), true, true,
                true,
                true);
    }
}
