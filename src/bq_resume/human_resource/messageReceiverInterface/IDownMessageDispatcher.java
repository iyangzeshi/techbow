package bq_resume.human_resource.messageReceiverInterface;

/**
 * Created by FLK on 2019-12-21.
 */
public interface IDownMessageDispatcher {
    void onMessageReceived(final String message);
}