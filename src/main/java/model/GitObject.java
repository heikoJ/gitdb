package model;

/**
 * Created by heiko on 15.12.14.
 */
public class GitObject {

    private String databaseObject;
    private String localPath;
    private String type;

    public GitObject(String databaseObject, String localPath, String type) {
        this.databaseObject = databaseObject;
        this.localPath = localPath;
        this.type = type;
    }

    public String getDatabaseObject() {
        return databaseObject;
    }

    public void setDatabaseObject(String databaseObject) {
        this.databaseObject = databaseObject;
    }

    public String getLocalPath() {
        return localPath;
    }

    public void setLocalPath(String localPath) {
        this.localPath = localPath;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
