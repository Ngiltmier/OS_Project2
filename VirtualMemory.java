// Project 2: Simulating memory
//Garrett Brenner and Noah Giltmier
import java.util.Random;

public class VirtualMemory {
    int memSize; //total memory size
    int pageSize; //total page size
    int numJobs; // total number of jobs allowed
    int minRuntime; //for random generation of runtime for jobs
    int maxRuntime;
    int minMemory; //for random generation of memory for jobs
    int maxMemory;
    Job jobQueue[];

    public VirtualMemory(int memory, int page, int jobs, int min_run, int max_run, int min_mem, int max_mem){
        memSize = memory;
        pageSize = page;
        numJobs = jobs;
        minRuntime = min_run;
        maxRuntime = max_run;
        minMemory = min_mem;
        maxMemory = max_mem;

        if (memSize % pageSize != 0){
            //throw a custom exception

        }
        //!!!NOT TESTED!!!
        jobQueue = createJobQueue();
    }

    //creates queue of job objects !!!NOT TESTED!!!
    Job[] createJobQueue(){

        Random rand = new Random();
        Job job_queue[] = new Job[numJobs];

        for(int i = 0; i < numJobs; i++){
            int mem = rand.nextInt((maxMemory - minMemory) + 1) + minMemory; //((max - min) + 1) + min creates a range
            int run = rand.nextInt((maxRuntime - minRuntime) + 1) + minRuntime;
            job_queue[i] = new Job(mem, run);
        }

        return job_queue;
    }
}
