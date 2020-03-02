// creates a job object that holds a size and runtime (both of which can be changed)
class Job {
    String jobID;
    int memory;
    int runtime;

    Job(String jobID, int mem, int run){
        this.jobID = jobID;
        memory = mem;
        runtime = run;
    }

    public String getJobID(){return jobID;}

    public int getMemory(){return memory;}

    public int getRuntime(){return runtime;}

    public void setMemory(int new_mem){memory = new_mem;}

    public void setRuntime(int new_run){runtime = new_run;}
}
