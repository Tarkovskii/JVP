package org.example.observer;

public class JobSearch {
    public static void main(String[] args) {
        JavaDeveloperJobSite jobSite = new JavaDeveloperJobSite();

        jobSite.addVacancy("First java position");
        jobSite.addVacancy("Second java position");

        Observer firstSubscriber = new Subscriber("Daniil");
        Observer secondSubscriber = new Subscriber("Luda");

        jobSite.addObserver(firstSubscriber);
        jobSite.addObserver(secondSubscriber);

        jobSite.addVacancy("Fortin vacancy");




    }
}
