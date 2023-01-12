public class registerWorker
{
    Worker theWorker;
    Flight theFlight;

    public registerWorker(Worker theWorker_,Flight theFlight_)
    {
        theWorker=theWorker_;
        theFlight=theFlight_;
    }

    boolean RegisterToTheFlight()
    {
       return theFlight.registerWorker(theWorker);
    }//register the worker

}
