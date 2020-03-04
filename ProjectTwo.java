public class ProjectTwo {
    
    public static void main(String[] args) {
        int memSize; //total memory size
        int pageSize; //total page size
        int numJobs; // total number of jobs allowed
        int minRuntime; //for random generation of runtime for jobs
        int maxRuntime;
        int minMemory; //for random generation of memory for jobs
        int maxMemory;

        try {
            memSize = Integer.parseInt(args[0]); //total memory size
            pageSize = Integer.parseInt(args[1]); //total page size
            numJobs = Integer.parseInt(args[2]); // total number of jobs allowed
            minRuntime = Integer.parseInt(args[3]); //for random generation of runtime for jobs
            maxRuntime = Integer.parseInt(args[4]);
            minMemory = Integer.parseInt(args[5]); //for random generation of memory for jobs
            maxMemory = Integer.parseInt(args[6]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please enter the correct number of arguments");
            System.out.println("<memSize> <pageSize> <numJobs> <minRunTime> <maxRuntime> <minMemory> <maxMemory>");
            return;
        }

        try {
            VirtualMemory virtualMemory = new VirtualMemory(memSize, pageSize, numJobs, minRuntime, maxRuntime, minMemory, maxMemory);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
