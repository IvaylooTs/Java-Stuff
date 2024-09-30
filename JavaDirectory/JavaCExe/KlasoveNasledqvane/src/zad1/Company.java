package zad1;

public class Company {
    private String name;
    private String date;
    private String bulstat;

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getDate(){
        return this.date;
    }
    public void setDate(String date){
        this.date=date;
    }
    public String getBulstat(){
        return this.bulstat;
    }
    public void setBulstat(String bulstat){
        if (bulstat.length()==10){
        this.bulstat = bulstat;
        }
    }

}
