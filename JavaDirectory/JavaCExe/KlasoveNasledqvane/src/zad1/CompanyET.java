package zad1;

public class CompanyET extends Company{
    private String nameOf;
    private double startCapital;
    private double actualCapital;

    public String getNameOf(){
        return this.nameOf;
    }
    public double getStartCapital(){
        return this.startCapital;
    }
    public double getActualCapital(){
        return this.actualCapital;
    }
    public void setNameOf(String name){
        this.nameOf = name;
    }
    public void setStartCapital(double startCapital){
        this.startCapital = startCapital;
    }
    public void setActualCapital(double actualCapital){
        this.actualCapital = actualCapital;
    }

    public double earnings(){
        return(getActualCapital()-getStartCapital());
    }
}
