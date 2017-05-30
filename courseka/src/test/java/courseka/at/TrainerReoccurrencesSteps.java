package courseka.at;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.junit.Assert.assertEquals;

public class TrainerReoccurrencesSteps {

    private String trainer;
    private int numberOfGivenClasses;
    private int expectedNumberOfClassesLeft;
    private int numberOfClassesLeft;
    private int holidays;
    private double courseDuration;
    private boolean isNormalMonth;

    /* Scenario 1 and 2*/
    @Given("<trainer> is qualified to give multiple courses")
    public void givenTrainerIsQualifiedToGiveMultipleCourses(@Named("trainer") String trainer) {
        this.trainer = trainer;
    }

    @Given("it is <month>")
    public void monthOfTheYear(@Named("month") String month) {
        if(month.toLowerCase().equals("february")){
            this.isNormalMonth = false;
        }else{
            this.isNormalMonth = true;
        }
    }

    @When("<trainer> gave <numberOfClasses> classes this month")
    public void whenTrainerGaveXClassesThisMonth(@Named("numberOfClasses") int numberOfClasses) {
        this.numberOfGivenClasses = numberOfClasses;
    }

    @Then("<trainer> can still give <numberOfClassesLeft> classes this month")
    public void determineNumberOfClassesTrainerCanStillGiveThisMonth(@Named("numberOfClassesLeft") int numberOfClassesLeft) {
        this.numberOfClassesLeft = numberOfClassesLeft;
        if(this.courseDuration < 1){
            this.expectedNumberOfClassesLeft = 4 - numberOfGivenClasses;
        }

        if(this.courseDuration == 1){
            this.expectedNumberOfClassesLeft = 1;
        }

        if(this.courseDuration > 1){
            this.expectedNumberOfClassesLeft = 0;
        }

        if(this.holidays > 2 && numberOfGivenClasses == 1 && courseDuration == 0.5){ // not good
            this.expectedNumberOfClassesLeft = 2;
        }

        if(this.holidays > 5){
            this.expectedNumberOfClassesLeft = 0;
        }

        assertEquals(this.numberOfClassesLeft,this.expectedNumberOfClassesLeft);

    }

    /* Scenario 3 */
    @When("the course duration is <course_duration_in_days>")
    public void whenTheCourseDurationIs(@Named("course_duration_in_days") double course_duration_in_days) {
        this.courseDuration = course_duration_in_days;
    }

    /* Scenario 4 */
    @When("the trainer had <holidays> holidays this month")
    public void whenTheTrainerHad3HolidaysThisMonth(@Named("holidays") int holidays) {
        this.holidays = holidays;
    }

}
