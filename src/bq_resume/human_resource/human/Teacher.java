package bq_resume.human_resource.human;

import bq_resume.human_resource.Position;

/**
 * Created by FLK on 2019-12-21.
 */
public class Teacher extends People {
    public static final String TAG = Teacher.class.getSimpleName();

    public Teacher(String id, String name) {
        super(id, name);
        super.position = Position.TEACHER;
    }

    @Override
    public void onSupervisorMessageReceived(String message) {
        System.out.printf("%s : 老刘发话了%n",TAG);
        sendReportersMessage(String.format("老刘最高指示如下： %s ",message));
    }

    @Override
    public void onReportersMessageReceived(String message) {
        System.out.printf("%s : Received a message： %s %n",TAG,message);
    }
}