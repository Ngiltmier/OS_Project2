// creates a job object that holds a size and runtime (both of which can be changed)
// Also holds an ID (number toString that numbers the process)
// And a status
class Job {
    String jobID;
    int memory;
    int runtime;
    String status = "Ready"; //Ready, Started, Running, Finished

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

    public String getStatus(){return status;}

    public void setStatus(String s){status = s;}


}
