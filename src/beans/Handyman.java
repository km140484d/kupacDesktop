package beans;

import java.util.ArrayList;
import java.util.List;

public class Handyman extends User{
    private static int jobStId = 0;

    public class Job{
        private int id = ++jobStId;
        private Occupation occupation;
        private Integer price;
        private Integer experience;
        private double rating;

        public Job(Occupation occupation, Integer price, Integer experience, double rating) {
            this.occupation = occupation;
            this.price = price;
            this.experience = experience;
            this.rating = rating;
        }

        public Occupation getOccupation() {
            return occupation;
        }

        public void setOccupation(Occupation occupation) {
            this.occupation = occupation;
        }

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        public Integer getExperience() {
            return experience;
        }

        public void setExperience(Integer experience) {
            this.experience = experience;
        }

        public double getRating() {
            return rating;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }
    }

    private List<Skill> skills;
    private List<Job> jobs = new ArrayList<>();

    public Handyman(String name, String surname, String phone, String email, List<Skill> skills) {
        super(name, surname, phone, email);
        this.skills = skills;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}
