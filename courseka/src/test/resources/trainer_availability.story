Meta:

Narrative:
As a training manager
I want to invite trainers for a class that are available on the agreed date and time
So that I won't invite trainers that are not available

Scenario: >= 1 day training and many trainers are qualified
Given the trainer has a status <status>
When many trainers are qualified to give this course
Then the trainer availability is <availability>
And the action should be <action>

Examples:
|status|availability|action|
|working elsewhere|unavailable|do not invite|
|tentative|unsure|invite|
|busy|unavailable|do not invite|
|out of office|unavailable|do not invite|

Scenario: <= 0.5 day training and many trainers are qualified
Given the trainer has a status <status>
When many trainers are qualified to give this course
Then the trainer availability is <availability>
And the action should be <action>

Examples:
|status|availability|action|
|working elsewhere|unavailable|do not invite|
|tentative|unsure|invite|
|busy|unavailable|do not invite|
|out of office|unavailable|do not invite|

Scenario: >= 1 day training and only two trainers are qualified
Given the trainer has a status <status>
And only two trainers are qualified to give this course
And the trainer availability is <availability>
When the action is <action>
And the trainer response is <response>
Then the new action is <new_action>

Examples:
|status|availability|action|response|new_action|
|working elsewhere|unavailable|invite|unavailable|reschedule class|
|tentative|unsure|invite|unavailable|reschedule class|
|busy|unavailable|invite|unavailable|reschedule class|
|out of office|unavailable|invite|unavailable|reschedule class|
|working elsewhere|unavailable|invite|available|plan class|
|tentative|unsure|invite|available|plan class|
|busy|unavailable|invite|available|plan class|
|out of office|unavailable|invite|available|plan class|

Scenario: <= 0.5 day training and only two trainers are qualified
Given the trainer has a status <status>
And only two trainers are qualified to give this course
And the trainer availability is <availability>
When the answer to is the trainer available on another moment this day is <available_on_another_moment_this_day>
And the action is <action>
And the trainer response is <response>
Then the new action is <new_action>

Examples:
|status|availability|available_on_another_moment_this_day|action|response|new_action|
|working elsewhere|unavailable|no|invite|unavailable|reschedule class|
|tentative|unsure|nvt|invite|unavailable|reschedule class|
|busy|unavailable|no|invite|unavailable|reschedule class|
|out of office|unavailable|no|invite|unavailable|reschedule class|
|working elsewhere|unavailable|yes|invite|available|plan class|
|tentative|unsure|nvt|invite|available|plan class|
|busy|unavailable|yes|invite|available|plan class|
|out of office|unavailable|yes|invite|available|plan class|





