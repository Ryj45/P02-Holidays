package c346.rp.edu.sg.p02_holidays;

public class Holidays {
    private String name;
    private String date;
    public Holidays(String name, String date){
        this.name = name;
        this.date = date;
    }

    public String getName(){
        return name;
    }

    public String getDate() {
        return date;
    }

}
