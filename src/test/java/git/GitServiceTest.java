package git;

import config.AppConfig;
import org.eclipse.jgit.revwalk.RevCommit;
import org.junit.Test;
import org.junit.internal.JUnitSystem;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class GitServiceTest {
    
    @Autowired
    GitService gitService;

    @Test
    public void testGetLogForFile() throws Exception {
        gitService.setLocalRepositoryPath("/Users/heiko/work/db/.git");
        Iterable<RevCommit> commits = gitService.getLogForFile("cv_test_abc.sql");
        System.out.println("Commits: ");
        for(RevCommit commit : commits) {
            System.out.println(commit.getId());
            System.out.println(commit.getFullMessage());

        }


    }
}