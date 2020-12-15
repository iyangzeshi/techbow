package bq_resume.human_resrouce.human;

import bq_resume.human_resrouce.Position;

/**
 * Created by FLK on 2019-12-21.
 */
public class Student extends People {
    public static final String TAG = Student.class.getSimpleName();

    public Student(String id, String name) {
        super(id, name);
        position = Position.STUDENT;
    }
    
    @Override
    public void onSupervisorMessageReceived(String message) {
        System.out.printf("%s : 收到如下信息： %s %n", name, message);
    }

    @Override
    public void onReportersMessageReceived(String message) {
        System.out.printf("%s : 收到如下信息： %s %n", name, message);
    }
    
}
