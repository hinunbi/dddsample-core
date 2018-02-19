package se.citerus.dddsample;

import com.pathfinder.config.PathfinderApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import se.citerus.dddsample.application.util.SampleDataGenerator;
import se.citerus.dddsample.config.DDDSampleApplicationContext;

import javax.annotation.PostConstruct;

@Configuration
@Import({DDDSampleApplicationContext.class,
    PathfinderApplicationContext.class})
@EnableAutoConfiguration
//@PropertySource(value = { "classpath:jdbc.properties" })
public class Application {

//  @Autowired
//  public DataSource dataSource;

  @Autowired
  SampleDataGenerator sampleDataGenerator;

  public static void main(String[] args) throws Exception {
    SpringApplication.run(Application.class, args);
  }

  @PostConstruct
  public void init() {
    sampleDataGenerator.generate();
  }


//  @Bean
//  public PersistenceUnitManager  defaultPersistenceUnitManager() {
//    DefaultPersistenceUnitManager persistenceUnitManager = new DefaultPersistenceUnitManager();
//    persistenceUnitManager.setDefaultDataSource(dataSource);
//    return persistenceUnitManager;
//  }
//
//  @Bean
//  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//
//    LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
//    entityManagerFactory.setDataSource(dataSource);
//    entityManagerFactory.setPersistenceProviderClass(HibernatePersistenceProvider.class);
//    Properties jpaProperties = new Properties();
//    jpaProperties.setProperty("hibernate.dialect", );
//
//    entityManagerFactory.setJpaProperties(jpaProperties);
//    entityManagerFactory.setPersistenceUnitManager(defaultPersistenceUnitManager());
//
//
//    entityManagerFactory.setPackagesToScan(ENTITYMANAGER_PACKAGES_TO_SCAN);
//    entityManagerFactory.setJpaProperties(jpaHibernateProperties());
//
//    return entityManagerFactory;
//  }
//
//  private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
//  private static final String PROPERTY_NAME_HIBERNATE_MAX_FETCH_DEPTH = "hibernate.max_fetch_depth";
//  private static final String PROPERTY_NAME_HIBERNATE_JDBC_FETCH_SIZE = "hibernate.jdbc.fetch_size";
//  private static final String PROPERTY_NAME_HIBERNATE_JDBC_BATCH_SIZE = "hibernate.jdbc.batch_size";
//  private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
//  private static final String[] ENTITYMANAGER_PACKAGES_TO_SCAN = {"a.b.c.entities", "a.b.c.converters"};


//  private Properties jpaHibernateProperties() {
//
//    Properties properties = new Properties();
//
//    properties.put(PROPERTY_NAME_HIBERNATE_MAX_FETCH_DEPTH, env.getProperty(PROPERTY_NAME_HIBERNATE_MAX_FETCH_DEPTH));
//    properties.put(PROPERTY_NAME_HIBERNATE_JDBC_FETCH_SIZE, env.getProperty(PROPERTY_NAME_HIBERNATE_JDBC_FETCH_SIZE));
//    properties.put(PROPERTY_NAME_HIBERNATE_JDBC_BATCH_SIZE, env.getProperty(PROPERTY_NAME_HIBERNATE_JDBC_BATCH_SIZE));
//    properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, env.getProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
//
//    properties.put(AvailableSettings.SCHEMA_GEN_DATABASE_ACTION, "none");
//    properties.put(AvailableSettings.USE_CLASS_ENHANCER, "false");
//    return properties;
//  }

}