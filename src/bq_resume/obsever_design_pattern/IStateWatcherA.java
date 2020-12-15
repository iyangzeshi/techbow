package bq_resume.obsever_design_pattern;

public class IStateWatcherA implements IStateObserver {

    public IStateWatcherA(){
        System.out.println("constructor: This is StateWatcherA");
    }

    @Override
    public void onStateChange() {
        System.out.println("StateWatcherA watches State Change");
    }
}
