package bq_resume.human_resrouce.human;

import bq_resume.human_resrouce.messageReceiverInterface.IDownMessageDispatcher;
import bq_resume.human_resrouce.messageReceiverInterface.IEmailReceiver;
import bq_resume.human_resrouce.messageReceiverInterface.IUpMessageDispatcher;
import bq_resume.human_resrouce.Position;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by FLK on 2019-12-21.
 */
public abstract class People {
	
	protected final String id;
	protected final String name;
	
	protected final List<People> directReporter;
	
	protected final List<IEmailReceiver> emailReceivers;
	
	protected final List<IUpMessageDispatcher> upMessageDispatchers;
	
	protected final List<IDownMessageDispatcher> downMessageDispatchers;
	
	protected People directSupervisor;
	
	protected Position position;
	
	public People(final String id, final String name) {
		this.id = id;
		this.name = name;
		
		directReporter = new ArrayList<>();
		emailReceivers = new ArrayList<>();
		upMessageDispatchers = new ArrayList<>();
		downMessageDispatchers = new ArrayList<>();
	}
    
    public int getLevel() {
		
		if (position == null) {
			return 0;
		}
		
		return position.getLevel();
	}
    
    public boolean setDirectReporter(final People people) {
		if (people.getLevel() >= this.getLevel()) {
			directSupervisor = people;
			return true;
		}
		
		return false;
	}
    
    public boolean addDirectReporter(final People people) {
		if (people.getLevel() <= this.getLevel()) {
			directReporter.add(people);
			people.setDirectReporter(this);
			return true;
		}
		return false;
	}
    
    public void sendSupervisorMessage(final String message) {
		if (directSupervisor != null) {
			directSupervisor.onReportersMessageReceived(message);
		}
		
		for (IUpMessageDispatcher supervisor : upMessageDispatchers) {
			supervisor.onMessageReceived(message);
		}
	}
    
    public void sendReportersMessage(final String message) {
		for (People reporter : directReporter) {
			reporter.onSupervisorMessageReceived(message);
		}
		
		for (IDownMessageDispatcher reporters : downMessageDispatchers) {
			reporters.onMessageReceived(message);
		}
	}
	
	/**
	 * 这个实际上就是观察者模式observer pattern， emailReceivers在监听老刘的消息
	 * @param emailMessage: 观察者要收到的消息
	 */
    public void sendEmail(String emailMessage) {
		for (IEmailReceiver emailReceiver : emailReceivers) {
			emailReceiver.onEmailMessageReceived(emailMessage);
		}
	}
    
    public void addEmailReceiver(final IEmailReceiver iEmailReceiver) {
		emailReceivers.add(iEmailReceiver);
	}
    
    public void removeEmailReceiver(final IEmailReceiver iEmailReceiver) {
		emailReceivers.remove(iEmailReceiver);
	}
    
    public abstract void onSupervisorMessageReceived(String message);
    
    public abstract void onReportersMessageReceived(String message);
	
}
