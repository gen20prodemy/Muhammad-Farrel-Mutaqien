package POJO;

public class DataTiket {
    private int ticketID;
    private String name;

    public DataTiket(int ticketID, String name){
        this.ticketID = ticketID;
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getTicketID(){
        return ticketID;
    }

    public String getName(){
        return name;
    }
}
