package git;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * Created by heiko on 15.12.14.
 */
@Service
public class GitService {

    private Git git;

    public void setLocalRepositoryPath(String localRepositoryPath) {
        try {
            this.git =
                new Git(
                    new FileRepositoryBuilder().
                            setGitDir(new File(localRepositoryPath)).
                            readEnvironment().
                            findGitDir().
                            build());
        } catch (Exception e) {
            throw new GitException(e);
        }
    }

    public Iterable<RevCommit> getLogForFile(String path) {
            return git.log().  addPath(path).all().call();
    }





}
