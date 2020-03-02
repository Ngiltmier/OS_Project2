// Project 2: Simulating memory
//Garrett Brenner and Noah Giltmier
import java.util.Random;

class VirtualMemory {
    final static int RANDOM_SEED = 6;
    final static int TIME_SLICE = 1;

    private int memSize; //total memory size
    private int pageSize; //total page size
    private int numJobs; // total number of jobs allowed
    private int minRuntime; //for random generation of runtime for jobs
    private int maxRuntime;
    private int minMemory; //for random generation of memory for jobs
    private int maxMemory;

    private Job jobQueue[];
    private Page pageList[];


    VirtualMemory(int memory, int page, int jobs, int min_run, int max_run, int min_mem, int max_mem) throws Exception {
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
        createPagesList();

        /*
        //TESTING JOB QUEUE
        System.out.println("Memory: [" + minMemory + ", " + maxMemory + "]");
        System.out.println("Runtime: [" + minRuntime + ", " + maxRuntime + "]");
        for (int i = 0; i < jobQueue.length; i++) {
            System.out.println("M: " + jobQueue[i].getMemory());
            System.out.println("R: " + jobQueue[i].getRuntime() + "\n");
        }
         */

        printPagesList();
        pageList[40].assignJob(1,10);
        pageList[45].assignJob(1, 5);
        pageList[80].assignJob(2, 12);
        pageList[89].setAvailability(false);
        System.out.println();
        printPagesList();
    }

    private void createJobQueue(){

        Random rand = new Random(RANDOM_SEED);
        jobQueue = new Job[numJobs];

        for(int i = 0; i < numJobs; i++){
            int mem = rand.nextInt((maxMemory - minMemory) + 1) + minMemory; //((max - min) + 1) + min creates a range
            int run = rand.nextInt((maxRuntime - minRuntime) + 1) + minRuntime;
            jobQueue[i] = new Job(mem, run);
        }


    }

    private void createPagesList() {
        pageList = new Page[memSize/pageSize];
        for (int i = 0; i < memSize/pageSize; i++) {
            Page page = new Page(pageSize, i + 1);
            pageList[i] = page;
        }
    }

    private void printPagesList() {
        for (int i = 0; i < pageList.length; i++) {
            System.out.print(pageList[i] + " ");
            if ((i+1)%10 == 0) {
                System.out.println();
            }
        }
    }

    private void roundRobin() {

    }

}
