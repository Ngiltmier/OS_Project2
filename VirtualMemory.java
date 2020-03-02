// Project 2: Simulating memory
//Garrett Brenner and Noah Giltmier
import java.util.Random;

public class VirtualMemory {
    final static int RANDOM_SEED = 6;

    int memSize; //total memory size
    int pageSize; //total page size
    int numJobs; // total number of jobs allowed
    int minRuntime; //for random generation of runtime for jobs
    int maxRuntime;
    int minMemory; //for random generation of memory for jobs
    int maxMemory;

    Job jobQueue[];

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
            throw new Exception("The memory size (args[0]) must be an even multiple of the page size (args[1])");
        }

        createJobQueue();
    }

    //creates queue of job objects !!!NOT TESTED!!!
    private void createJobQueue(){

        Random rand = new Random(RANDOM_SEED);
        jobQueue = new Job[numJobs];

        for(int i = 0; i < numJobs; i++){
            int mem = rand.nextInt((maxMemory - minMemory) + 1) + minMemory; //((max - min) + 1) + min creates a range
            int run = rand.nextInt((maxRuntime - minRuntime) + 1) + minRuntime;
            jobQueue[i] = new Job(mem, run);
        }

        
    }
}
