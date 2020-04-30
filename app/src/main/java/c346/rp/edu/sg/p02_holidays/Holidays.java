package c346.rp.edu.sg.p02_holidays;

public class Holidays {
    private String name;
    private String date;
    private int image;
    public Holidays(String name, String date, int image){
        this.name = name;
        this.date = date;
        this.image = image;
    }

    public String getName(){
        return name;
    }

    public String getDate() {
        return date;
    }

    public int getImage(){
        return image;
    }

}
