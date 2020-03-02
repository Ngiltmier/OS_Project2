// creates a job object that holds a size and runtime (both of which can be changed)
public class Job {
    int memory;
    int runtime;

    Job(int mem, int run){
        memory = mem;
        runtime = run;
    }

    int getMemory(){return memory;}

    int getRuntime(){return runtime;}

    void setMemory(int new_mem){memory = new_mem;}

    void setRuntime(int new_run){runtime = new_run;}
}
