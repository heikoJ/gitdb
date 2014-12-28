package git;

import model.Folder;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FalseFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by heiko on 16.12.14.
 */
@Service
public class FileService {


    public List<Folder> getSubFolderForFolder(Folder folder) {
        return new ArrayList<>(FileUtils.listFiles(new File(folder.getFullPath()), FalseFileFilter.INSTANCE, TrueFileFilter.INSTANCE));
    }


}
