package android.myapplicationdev.com.p03_class_journal;

/**
 * Created by 15017569 on 5/4/2017.
 */

import java.io.Serializable;

public class Module implements Serializable{
    private String moduleCode;
    private String moduleName;

    public Module(String moduleCode,String moduleName){
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
    }
    public String getModuleCode()  {
        return moduleCode;
    }{
    }
    public String getModuleName()  {
        return moduleName;
    }{
    }
}