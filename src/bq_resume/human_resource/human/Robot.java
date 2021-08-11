package bq_resume.human_resource.human;

import bq_resume.human_resource.messageReceiverInterface.IEmailReceiver;

/**
 * Created by FLK on 2019-12-21.
 */
public class Robot implements IEmailReceiver {
	
	public static final String TAG = TechbowCEO.class.getSimpleName();
	
	@Override
	public void onEmailMessageReceived(String emailMessage) {
		System.out.printf("一封来自老刘的信： %s %n", emailMessage);
	}
}