package android.myapplicationdev.com.p03_class_journal;

/**
 * Created by 15017569 on 5/4/2017.
 */

import java.io.Serializable;

public class Module implements Serializable{
    private String moduleCode;
    private String moduleName;
    private String link;

    public Module(String moduleCode, String moduleName, String link){
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
        this.link = link;
    }
    public String getModuleCode()  {
        return moduleCode;
    }{
    }
    public String getModuleName()  {
        return moduleName;
    }{
    }
    public String getLink() {
        return link;
    }
}