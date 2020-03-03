// Project 2: Simulating memory
//Garrett Brenner and Noah Giltmier

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
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
    private int bigTimeStep = 1;

    private Queue<Job> jobQueue;
    private Page pageList[];
    private ArrayList<Job> processList = new ArrayList<>();


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

        printStartingInfo();
        createJobQueue();
        printJobQueue();
        createPagesList();

        System.out.println("Scheduling...");
        schedule();
        roundRobin();

        /*
        //TESTING JOB QUEUE
        System.out.println("Memory: [" + minMemory + ", " + maxMemory + "]");
        System.out.println("Runtime: [" + minRuntime + ", " + maxRuntime + "]");
        while (!jobQueue.isEmpty()) {
            Job j = jobQueue.poll();
            System.out.println("M: " + j.getMemory());
            System.out.println("R: " + j.getRuntime() + "\n");
        }
         */


        /*
        //TESTING PAGES
        printPagesList();
        pageList[40].assignJob(1,10);
        pageList[45].assignJob(1, 5);
        int val = pageList[80].assignJob(2, 12);
        System.out.println("here");
        System.out.println(val);
        if (val > 0)
            pageList[81].assignJob(2, val);
        System.out.println();
        printPagesList();
         */
    }

    private void printStartingInfo() {
        String info = "Memory Size: " + memSize + "\n";
        info += "Page Size: " + pageSize + "\n";
        info += "Random Seed: " + RANDOM_SEED + "\n";
        info += "Number of Jobs: " + numJobs + "\n";
        info += "Runtime (min-max) timesteps:" + minRuntime + "-" + maxRuntime + "\n";
        info += "Memory (min-max): " + minMemory + "-" + maxMemory + "\n";
        System.out.println(info);
    }

    private void createJobQueue(){

        Random rand = new Random(RANDOM_SEED);
        jobQueue = new LinkedList<Job>();

        for(int i = 0; i < numJobs; i++){
            int mem = rand.nextInt((maxMemory - minMemory) + 1) + minMemory; //((max - min) + 1) + min creates a range
            int run = rand.nextInt((maxRuntime - minRuntime) + 1) + minRuntime;
            jobQueue.add(new Job(Integer.toString(i + 1), mem, run));
        }


    }

    private void printJobQueue(){
        System.out.println("Job Queue:");
        System.out.println("Job #    Runtime    Memory");
        for (Job j : jobQueue) {
            System.out.println(j.getJobID() + "        " + j.getRuntime() + "         " + j.getMemory());
        }
        System.out.println();
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
                System.out.println("\n");
            }
        }
        System.out.println("\n");
    }

    private void removeProcessFromPages(Job j) {
        for (Page p : pageList) {
            if (p.getJobID() == j.getJobID()) {
                p.free();
            }
        }
    }

    private void schedule() {
        while(!jobQueue.isEmpty()){
            Job inUse = jobQueue.peek();
            int val = -1;
            for(int i =0; i < pageList.length; i++){
                val = pageList[i].assignJob(inUse.getJobID(),inUse.getMemory());
                if(val == 0){//returns 0 if page is big enough for job
                    break;
                }
                else if(val > 0){
                    inUse.setMemory(val); // val is remainder of job memory that still needs a home
                }
            }

            if(val == 0){
                processList.add(jobQueue.poll());
            } else {
                roundRobin();
            }

        }

    }

    private void roundRobin(){
        while(!processList.isEmpty()){
            int timeStep = 1;
            for (int i = 0; i < processList.size(); i++) {
                bigTimeStep += timeStep;
                System.out.println("Time Step " + (bigTimeStep) + ":");
                if (timeStep == 1) {
                    for (int j = 0; j < processList.size(); j++) { //starts all processes
                        processList.get(j).setStatus("Starting");
                        System.out.println("    Job " + processList.get(j).getJobID() + " is " + processList.get(j).getStatus());
                        processList.get(j).setStatus("Running");
                    }
                }
                Job inUse = processList.get(i);
                if (inUse.getStatus().equals("Running")) {

                    System.out.println("    Job " + inUse.getJobID() + " is " + inUse.getStatus());
                    inUse.setRuntime(inUse.getRuntime() - TIME_SLICE); // run it for one time step
                    if (inUse.getRuntime() == 0) {
                        inUse.setStatus("Completed");
                        System.out.println("    Job " + inUse.getJobID() + " is " + inUse.getStatus());
                        //Remove Process from pages
                        removeProcessFromPages(inUse);
                        processList.remove(i);
                    }

                }
                // Print Page table
                printPagesList();
                timeStep++;
            }
        }
    }


}
