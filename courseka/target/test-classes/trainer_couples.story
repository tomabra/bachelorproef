Meta:

Narrative:
As a training manager
I want to have the trainers of every class be well considered couples
So that I assure that the class is given as well as possible

Scenario: many trainers are available
Given the trainings manager wants to select <trainer1> and <trainer2> for a class
And <numberOfTrainers> qualified trainers from other projects are available
When <trainer1> works on <trainer1Project>
And <trainer2> works on <trainer2Project>
Then these trainers are <allowedStatus>

Examples:
|trainer1|trainer2|numberOfTrainers|trainer1Project|trainer2Project|allowedStatus|
|Davy|Stijn|10|RSVZ|RSVZ|not allowed to work together|
|Karl|Frank|10|RSVZ|RSVZ|not allowed to work together|
|Davy|Tom|10|RSVZ|Ventouris|allowed to work together|
|Davy|Jos|10|RSVZ|Ventouris|allowed to work together|

Scenario: only qualified trainers from the same project are available
Given the trainings manager wants to select <trainer1> and <trainer2> for a class
And <numberOfTrainers> qualified trainers from other projects are available
When <trainer1> works on <trainer1Project>
And <trainer2> works on <trainer2Project>
Then these trainers are <allowedStatus>

Examples:
|trainer1|trainer2|numberOfTrainers|trainer1Project|trainer2Project|allowedStatus|
|Davy|Stijn|2|RSVZ|RSVZ|allowed to work together|
|Karl|Frank|2|RSVZ|RSVZ|allowed to work together|

