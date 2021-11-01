package aspects;

import model.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserServiceAspect {

//    @Before("execution(* service.*.*(..))")
//    public void firstTestingAll()   {
//        System.out.println("dummy test");
//    }

//    @Before("execution(* service.UserService.createUser(..))")
//    public void logMessage() {
//        System.out.println("Intercept - request create user");
//    }

//    @Before("execution(* service.UserService.createUser(..)) && args(name, ..)")
//    public void logUserNameCreated(String name) {
//        System.out.println(String.format("Intercept - request create user with name %s", name));
//    }
//
//    @After("execution(* service.UserService.createUser(..))")
//    public void afterCreateUser()   {
//        System.out.println("Create user flow finished");
//    }
//
//    @AfterReturning("execution(* service.UserService.createUser(..))")
//    public void afterCreateUserReturning()   {
//        System.out.println("Create user flow finished successfully");
//    }
//
//    @AfterThrowing("execution(* service.UserService.createUser(..))")
//    public void afterCreateUserThrowing()   {
//        System.out.println("Create user flow finished but error was thrown");
//    }

//    @Around("execution(* service.UserService.createUser(..))")
//    public void createUserAround(ProceedingJoinPoint joinPoint) throws Throwable {
//        String methodName = joinPoint.getSignature().getName();
//        System.out.println("Intercept - request create user => " + methodName);
//        joinPoint.proceed();
//        System.out.println("Create user flow finished");
//    }

//    @Around("execution(* service.UserService.createUser(..))")
//    public Object createUserAroundModifyUser(ProceedingJoinPoint joinPoint) throws Throwable {
//        return new User.UserBuilder()
//                .age(30)
//                .name("james")
//                .build();
//    }

//    @Around("execution(* service.UserService.createNewUser(..))")
//    public Object createUserAroundModifyUser(ProceedingJoinPoint joinPoint) throws Throwable {
//        Object [] newArgs = {"Elena"};
//       Object result = joinPoint.proceed(newArgs);
//       return result;
//    }

    @Around("@annotation(MarkedForLogging)")
    public void logMessage(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println(":) ");
        joinPoint.proceed();
    }

    }
