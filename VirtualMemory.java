// Project 2: Simulating memory
//Garrett Brenner and Noah Giltmier


public class VirtualMemory {
    int memSize; //total memory size
    int pageSize; //total page size
    int numJobs; // total number of jobs allowed
    int minRuntime; //for random generation of runtime for jobs
    int maxRuntime;
    int minMemory; //for random generation of memory for jobs
    int maxMemory;

    public VirtualMemory(int memory, int page, int jobs, int min_run, int max_run, int min_mem, int max_mem) throws Exception {
        memSize = memory;
        pageSize = page;
        numJobs = jobs;
        minRuntime = min_run;
        maxRuntime = max_run;
        minMemory = min_mem;
        maxMemory = max_mem;

        if (memSize % pageSize != 0){
            //throw a custom exception
            throw new Exception("aadsf");
        }
    }
}
