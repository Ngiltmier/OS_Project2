// Project 2: Simulating memory
//Garrett Brenner and Noah Giltmier


public class virtual_memory {
    int mem_size; //total memory size
    int page_size; //total page size
    int num_of_jobs; // total number of jobs allowed
    int min_runtime, max_runtime; //for random generation of runtime for jobs
    int min_memory, max_memory; //for random generation of memory for jobs

    virtual_memory(int memory, int page, int jobs, int min_run, int max_run, int min_mem, int max_mem){
        mem_size = memory;
        page_size = page;
        num_of_jobs = jobs;
        min_runtime = min_run;
        max_runtime = max_run;
        min_memory = min_mem;
        max_memory = max_mem;
    }

    int create(int mem_size, int page_size){ //returns 0 if created correctly returns -1 and displays and error message otherwise
        if (mem_size % page_size != 0){
            System.out.println("Error: Memory size must be an even multiple of page size");
            return(-1);
        }
        

    }

}
