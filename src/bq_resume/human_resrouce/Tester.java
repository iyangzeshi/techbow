package bq_resume.human_resrouce;
//Project: techbow
//Package: bq_resume.HumanResrouce
//ClassName: Tester
//Author: Zeshi(Jesse) Yang
//Date: 2020-11-21 星期六 15:54

import bq_resume.human_resrouce.human.Robot;
import bq_resume.human_resrouce.human.Student;
import bq_resume.human_resrouce.human.Teacher;
import bq_resume.human_resrouce.human.TechbowCEO;

/**
 *
 */
final class Tester {
	
	public static void main(String[] args) {
		final TechbowCEO laoliu = new TechbowCEO("techbow-001", "laoliu");
		final Teacher frankFang = new Teacher("techbow-016", "Frank Fang");
		final Student rose = new Student("techbow-101-003", "Rose");
		final Student jack = new Student("techbow-101-002", "Jack");
		final Robot robot = new Robot();
		laoliu.addDirectReporter(frankFang);
		laoliu.addDirectReporter(rose);
		laoliu.addEmailReceiver(robot);
		
		frankFang.addDirectReporter(jack);
		
		laoliu.sendEmail("最穷不过讨饭，不死总会翻身");
		laoliu.sendReportersMessage("开始上课了哈");
		rose.sendSupervisorMessage(TechbowCEO.BAD_NEWS);
		rose.sendSupervisorMessage(TechbowCEO.GOOD_NEWS);
	}

}
