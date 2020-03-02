// creates a job object that holds a size and runtime (both of which can be changed)
class Job {
    int memory;
    int runtime;

    Job(int mem, int run){
        memory = mem;
        runtime = run;
    }

    public int getMemory(){return memory;}

    public int getRuntime(){return runtime;}

    public void setMemory(int new_mem){memory = new_mem;}

    public void setRuntime(int new_run){runtime = new_run;}
}
