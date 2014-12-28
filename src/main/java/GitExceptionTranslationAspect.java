import git.GitException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.NoHeadException;

import java.io.IOException;

/**
 * Created by heiko on 15.12.14.
 */
@Aspect
public class GitExceptionTranslationAspect {

    @Pointcut("execution( * git.*..*(..))")
    public void gitExec() {}

       @Around("gitExec()")
        public Object translateToDataAccessException(ProceedingJoinPoint pjp) throws Throwable {
            try {
                return pjp.proceed();
            } catch (Exception e) {
                throw new GitException(e);
            }
        }



/*
    pointcut gitExec() : execution( * git.*.*(..));


    Object around() throws Throwable : gitExec()   {
        try {
            return proceed();

        }catch (Exception e) {
            throw new GitException(e);
        }
    }
*/

}
