package courseka.at;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.junit.Assert.assertEquals;

public class TrainerExperienceSteps {

    private String trainer;
    private String course;
    private String expectedTrainerExperienceLevel;
    private String trainerExperienceLevel;
    private int timesGiven;
    private boolean reeducationNeeded;
    private String newTrainerExperienceLevel;
    private String expectedNewTrainerExperienceLevel;

    /* Scenario 1 and 2 */
    @Given("<trainer> gave <course> <times_given> times")
    public void givenTrainerGaveCourseXTimes(@Named("trainer") String trainer, @Named("course") String course, @Named("times_given") int times_given) {
        this.trainer = trainer;
        this.course = course;
        this.timesGiven = times_given;
    }

    @Then("the experience level for this course is <experience_level>")
    public void thenTheExperienceLevelForThisCourseIsSenior(@Named("experience_level") String experience_level) {
        if(this.timesGiven > 1){
            expectedTrainerExperienceLevel = "senior";
        }else{
            expectedTrainerExperienceLevel = "junior";
        }
        this.trainerExperienceLevel = experience_level.toLowerCase();
        assertEquals(this.trainerExperienceLevel,this.expectedTrainerExperienceLevel);
    }

    /* Scenario 3 */
    @Given("the experience level for this course is <experience_level>")
    public void givenTheExperienceLevelForThisCourseIsSenior(@Named("experience_level") String experience_level) {
        this.trainerExperienceLevel = experience_level.toLowerCase();
    }

    @When("<reeducation>")
    public void whenReeducationIsNeeded(@Named("reeducation") String reeducation) {
        if(reeducation.toLowerCase().equals("reeducation needed")){
            this.reeducationNeeded = true;
        }else{
            this.reeducationNeeded = false;
        }
    }

    @Then("the new experience level before the re-education is <experience_level_before_reeducation>")
    public void thenTheNewExperienceLevelBeforeTheReeducationIsSenior(@Named("experience_level_before_reeducation") String experience_level_before_reeducation) {
        this.newTrainerExperienceLevel = experience_level_before_reeducation.toLowerCase();
        if(this.timesGiven > 2){
            this.expectedNewTrainerExperienceLevel = "senior";
        }else{
            this.expectedNewTrainerExperienceLevel = "junior";
        }
        assertEquals(this.newTrainerExperienceLevel,this.expectedNewTrainerExperienceLevel);
    }

}
