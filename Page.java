class Page {
    private String jobID;
    private int size;
    private boolean available;

    Page(int size, int pageID) {
        this.size = size;
        this.available = true;
    }

    public boolean getAvailability() {
        return available;
    }

    //When a job is assigned to this page,
    //If the jobSize required is greater than the space in this page, the remainder is returned
    //If there is enough space to hold the entire job, 0 is returned
    //If there was some assignment error, a -1 will be returned
    public int assignJob(String jobID, int jobSize) {
        int returnVal = 0;
        if (!available) {
            return -1;
        } else if (jobSize > size) {
            this.jobID = jobID;
            available = false;
            returnVal = jobSize - size;
        } else {
            this.jobID = jobID;
            available = false;
        }
        return returnVal;
    }

    public void free() {
        jobID = null;
        available = true;
    }

    public String getJobID() {
        return jobID;
    }

    @Override
    public String toString() {
        if (available) {
            return ".";
        } else {
            return jobID;
        }
    }
}
