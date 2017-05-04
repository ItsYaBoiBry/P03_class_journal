package android.myapplicationdev.com.p03_class_journal;


import java.io.Serializable;

/**
 * Created by 15017569 on 5/4/2017.
 */

public class DailyGrade implements Serializable{
    private String dgGrade;
    private String moduleCode;
    private int week;

    public String getDgGrade(){
        return dgGrade;
    }
    public String getModuleCode(){
        return moduleCode;
    }
    public int getWeek(){
        return week;
    }
    public DailyGrade(String dgGrade,String moduleCode,int week){
        this.dgGrade = dgGrade;
        this.moduleCode = moduleCode;
        this.week = week;


    }
}
