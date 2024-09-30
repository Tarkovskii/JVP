## Assembling service

### compiling command
```bach
(there patch for proj)> mvn compile
```
### assembling command
```bach
(there patch for proj)> mvn package
```

### fail start

```agsl
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.example.workJVP.WorkJvpApplicationTests
08:26:24.819 [main] INFO org.springframework.test.context.support.AnnotationConfigContextLoaderUtils -- Could not detect default configuration classes for test class [com.example.workJVP.WorkJvpApplicationTests]: WorkJvpApplicationTests does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
08:26:25.029 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper -- Found @SpringBootConfiguration com.example.workJVP.WorkJvpApplication for test class com.example.workJVP.WorkJvpApplicationTests

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.2.2)

2024-09-30T08:26:25.919+03:00  INFO 11224 --- [           main] c.e.workJVP.WorkJvpApplicationTests      : Starting WorkJvpApplicationTests using Java 19.0.2 with PID 11224 (started by HONOR in C:\Users\HONOR\Project\JVP_reload\workJVP)
2024-09-30T08:26:25.921+03:00  INFO 11224 --- [           main] c.e.workJVP.WorkJvpApplicationTests      : No active profile set, falling back to 1 default profile: "default"
constructor start
2024-09-30T08:26:27.628+03:00  WARN 11224 --- [           main] o.s.w.c.s.GenericWebApplicationContext   : Exception encountered during context initialization - cancelling refresh atte
mpt: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'userController' defined in file [C:\Users\HONOR\Project\JVP_reload\workJVP\target\
classes\com\example\workJVP\controller\UserController.class]: Unsatisfied dependency expressed through constructor parameter 0: Error creating bean with name 'userService': Unsatisfied
 dependency expressed through field 'userRepository': Error creating bean with name 'userRepository' defined in file [C:\Users\HONOR\Project\JVP_reload\workJVP\target\classes\com\example\workJVP\view\UserRepository.class]: Failed to instantiate [com.example.workJVP.view.UserRepository]: Constructor threw exception
2024-09-30T08:26:27.647+03:00  INFO 11224 --- [           main] .s.b.a.l.ConditionEvaluationReportLogger :

Error starting ApplicationContext. To display the condition evaluation report re-run your application with 'debug' enabled.
2024-09-30T08:26:27.689+03:00 ERROR 11224 --- [           main] o.s.boot.SpringApplication               : Application run failed

org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'userController' defined in file [C:\Users\HONOR\Project\JVP_reload\workJVP\target\class
es\com\example\workJVP\controller\UserController.class]: Unsatisfied dependency expressed through constructor parameter 0: Error creating bean with name 'userService': Unsatisfied depe
ndency expressed through field 'userRepository': Error creating bean with name 'userRepository' defined in file [C:\Users\HONOR\Project\JVP_reload\workJVP\target\classes\com\example\workJVP\view\UserRepository.class]: Failed to instantiate [com.example.workJVP.view.UserRepository]: Constructor threw exception
        at org.springframework.beans.factory.support.ConstructorResolver.createArgumentArray(ConstructorResolver.java:798) ~[spring-beans-6.1.3.jar:6.1.3]
        at org.springframework.beans.factory.support.ConstructorResolver.autowireConstructor(ConstructorResolver.java:237) ~[spring-beans-6.1.3.jar:6.1.3]
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.autowireConstructor(AbstractAutowireCapableBeanFactory.java:1354) ~[spring-beans-6.1.3.jar:6.1.3]
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1191) ~[spring-beans-6.1.3.jar:6.1.3]
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:561) ~[spring-beans-6.1.3.jar:6.1.3]       
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:521) ~[spring-beans-6.1.3.jar:6.1.3]
        at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:325) ~[spring-beans-6.1.3.jar:6.1.3]
        at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234) ~[spring-beans-6.1.3.jar:6.1.3]
        at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:323) ~[spring-beans-6.1.3.jar:6.1.3]
        at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:199) ~[spring-beans-6.1.3.jar:6.1.3]
        at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:975) ~[spring-beans-6.1.3.jar:6.1.3]
        at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:959) ~[spring-context-6.1.3.jar:6.1.3]        
        at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:624) ~[spring-context-6.1.3.jar:6.1.3]
        at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:754) ~[spring-boot-3.2.2.jar:3.2.2]
        at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:456) ~[spring-boot-3.2.2.jar:3.2.2]
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:334) ~[spring-boot-3.2.2.jar:3.2.2]
        at org.springframework.boot.test.context.SpringBootContextLoader.lambda$loadContext$3(SpringBootContextLoader.java:137) ~[spring-boot-test-3.2.2.jar:3.2.2]
        at org.springframework.util.function.ThrowingSupplier.get(ThrowingSupplier.java:58) ~[spring-core-6.1.3.jar:6.1.3]
        at org.springframework.util.function.ThrowingSupplier.get(ThrowingSupplier.java:46) ~[spring-core-6.1.3.jar:6.1.3]
```
## Problem
### test from spring destroying assembling
### 

## Decision
### off test
```bash
there patch for proj)> mvn clean

(there patch for proj)> mvn package -DskipTests    
```
## Run command
```bash
\target> java -jar .\workJVP-0.0.1-SNAPSHOT.jar WorckJvpApplication
```
