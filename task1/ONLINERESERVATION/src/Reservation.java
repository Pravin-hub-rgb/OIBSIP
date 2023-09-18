public class Reservation {
    private String trainNumber;
    private String classType;
    private String date;
    private String from;
    private String to;
    private int pnrNo;

    // Constructor
    public Reservation(String trainNumber, String classType, String date, String from, String to, int pnrNo) {
        this.trainNumber = trainNumber;
        this.classType = classType;
        this.date = date;
        this.from = from;
        this.to = to;
        this.pnrNo = pnrNo;
    }

    // Getters and setters
    public String getTrainNumber() {
        return trainNumber;
    }

    public String getClassType() {
        return classType;
    }

    public String getDate() {
        return date;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public int getPNR() {
        return pnrNo;
    }
}
