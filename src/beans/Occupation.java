package beans;

public class Occupation {

    private static int stId = 0;
    private int id = ++stId;
    private String work;

    public Occupation(String occupation){
        this.work = occupation;
    }

    public String getOccupation() {
        return work;
    }

    public void setOccupation(String work) {
        this.work = work;
    }
}
