package leavehomesafely.model;

public class LeaveHomeSafely {
    private String[] gefahr;
    private String[] item;
//    private WetterStatus wetter;


    public LeaveHomeSafely() {
    }

    public String[] getGefahr() {
        return gefahr;
    }

    public String[] getItem() {
        return item;
    }

    public void setGefahr(String[] gefahr) {
        this.gefahr = gefahr;
    }

    public void setItem(String[] item) {
        this.item = item;
    }

}
