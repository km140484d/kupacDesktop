package beans;

import java.util.ArrayList;
import java.util.List;

public class Handyman extends User{
    private static int jobStId = 0;

    public class Job{
        private int id = ++jobStId;
        private Occupation occupation;
        private int price;
        private int rating;

        public Job(Occupation occupation, int price, int rating) {
            this.occupation = occupation;
            this.price = price;
            this.rating = rating;
        }

        public Occupation getOccupation() {
            return occupation;
        }

        public void setOccupation(Occupation occupation) {
            this.occupation = occupation;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }
    }

    private String skills;
    private List<Job> jobs = new ArrayList<>();

    public Handyman(String name, String surname, String phone, String email, String skills) {
        super(name, surname, phone, email);
        this.skills = skills;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}
