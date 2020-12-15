package bq_resume.obsever_design_pattern;


public class IStateWatcherB implements IStateObserver {

    public IStateWatcherB(){
        System.out.println("constructor: This is StateWatcherB");
    }

    @Override
    public void onStateChange() {
        System.out.println("StateWatcherB watches State Change");
    }
}
