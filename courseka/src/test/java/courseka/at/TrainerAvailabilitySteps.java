package courseka.at;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.junit.Assert.assertEquals;


@SuppressWarnings("UnusedStepDeclaration")
public class TrainerAvailabilitySteps {

    private String trainerStatus;
    private String trainerAvailability;
    private String expectedTrainerAction;
    private String trainerAction;
    private String trainerResponse;
    private String newTrainerAction;
    private String expectedNewTrainerAction;
    private String availableOnAnotherMomentThisDay;
    private boolean manyQualifiedTrainers;

    /* Scenario 1 and 2 */
    @Given("the trainer has a status <status>")
    public void trainerStatus(@Named("status") String status) {
        this.trainerStatus = status;
    }

    @When("many trainers are qualified to give this course")
    public void areManyTrainersAreQualifiedToGiveThisCourse() {
        this.manyQualifiedTrainers = true;
    }

    @Then("the trainer availability is <availability>")
    public void theTrainerAvailabilityIs(@Named("availability") String availability) {
        this.trainerAvailability = availability.toLowerCase();
        if (this.trainerAvailability.equals("unavailable")) {
            this.expectedTrainerAction = "do not invite";
        }else{
            this.expectedTrainerAction = "invite";
        }
    }

    @Then("the action should be <action>")
    public void determineTheAction(@Named("action") String action) {
        this.trainerAction = action.toLowerCase(); //do not invite or invite
        assertEquals(this.trainerAction,this.expectedTrainerAction);
    }
    /* end scenario 1 and 2*/
    /*---------------------------------------------------------------------------------------------------------------*/
    /* scenario 3 */
    @Given("only two trainers are qualified to give this course")
    public void givenOnlyTwoTrainersAreQualifiedToGiveThisCourse() {
        this.manyQualifiedTrainers = false;
    }

    @Given("the trainer availability is <availability>")
    public void theTwoTrainerAvailabilityIs(@Named("availability") String availability) {
        this.trainerAvailability = availability.toLowerCase();
    }

    @When("the action is <action>")
    public void theActionIs(@Named("action") String action) {
        this.trainerAction = action.toLowerCase();
    }

    @When("the trainer response is <response>")
    public void whenTheTrainerResponseIs(@Named("response") String response) {
        this.trainerResponse = response.toLowerCase();
        if(this.trainerResponse.equals("unavailable")){
            this.expectedNewTrainerAction = "reschedule class";
        }else{
            this.expectedNewTrainerAction = "plan class";
        }
    }

    @Then("the new action is <new_action>")
    public void thenTheNewActionIs(@Named("new_action") String new_action) {
        this.newTrainerAction = new_action.toLowerCase();
        assertEquals(this.newTrainerAction,this.expectedNewTrainerAction);
    }

    /*Scenario 4*/
    @When("the answer to is the trainer available on another moment this day is <available_on_another_moment_this_day>")
    public void whenTheAnswerToIsTheTrainerAvailableOnAnotherMomentThisDayIsavailable_on_another_moment_this_day(@Named("available_on_another_moment_this_day") String available_on_another_moment_this_day) {
        this.availableOnAnotherMomentThisDay = available_on_another_moment_this_day.toLowerCase();
    }
}
