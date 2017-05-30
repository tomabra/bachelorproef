package courseka.at;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.junit.Assert.assertEquals;

public class TrainerCouplesSteps {

    private String trainer1;
    private String trainer2;
    private String trainer1Project;
    private String trainer2Project;
    private String allowedStatus;
    private String expectedAllowedStatus;
    private boolean manyTrainers;

    /* Scenario 1*/
    @Given("the trainings manager wants to select <trainer1> and <trainer2> for a class")
    public void givenTheTrainingsManagerWantsToSelectTrainersForAClass(@Named("trainer1") String trainer1, @Named("trainer2") String trainer2) {
        this.trainer1 = trainer1;
        this.trainer2 = trainer2;
    }

    @Given("<numberOfTrainers> qualified trainers from other projects are available")
    public void numberOfTrainersQualifiedTrainersFromOtherProjectsAreAvailable(@Named("numberOfTrainers") int numberOfTrainers) {
        if(numberOfTrainers > 4){
            this.manyTrainers = true;
        }
    }

    @When("<trainer1> works on <trainer1Project>")
    public void projectOfTrainer1(@Named("trainer1") String trainer1, @Named("trainer1Project") String trainer1Project) {
        this.trainer1Project = trainer1Project.toLowerCase();
    }

    @When("<trainer2> works on <trainer2Project>")
    public void projectOfTrainer2(@Named("trainer2") String trainer2, @Named("trainer2Project") String trainer2Project) {
        this.trainer2Project = trainer2Project.toLowerCase();
    }

    @Then("these trainers are <allowedStatus>")
    public void determineAllowedStatus(@Named("allowedStatus") String allowedStatus) {
        this.expectedAllowedStatus = allowedStatus.toLowerCase();
        if(trainer1Project.equals(trainer2Project) && manyTrainers){
            this.allowedStatus = "not allowed to work together";
        }else{
            this.allowedStatus = "allowed to work together";
        }
        assertEquals(this.allowedStatus,this.expectedAllowedStatus);
    }

}
