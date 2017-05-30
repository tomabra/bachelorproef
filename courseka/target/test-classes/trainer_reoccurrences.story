Meta:

Narrative:
As a training manager
I want to limit the amount of classes that a trainer can give in a period of time to be limited
So that one trainer does not spend too much time giving classes

Scenario: normal month
Given <trainer> is qualified to give multiple courses
And it is <month>
When <trainer> gave <numberOfClasses> classes this month
Then <trainer> can still give <numberOfClassesLeft> classes this month

Examples:
|trainer|month|numberOfClasses|numberOfClassesLeft|
|Davy|march|0|4|
|Davy|march|1|3|
|Davy|march|2|2|
|Davy|march|3|1|
|Davy|march|4|0|

Scenario: february
Given <trainer> is qualified to give multiple courses
And it is <month>
When <trainer> gave <numberOfClasses> classes this month
Then <trainer> can still give <numberOfClassesLeft> classes this month

Examples:
|trainer|month|numberOfClasses|numberOfClassesLeft|
|Davy|february|0|4|
|Davy|february|1|3|
|Davy|february|2|2|
|Davy|february|3|1|
|Davy|february|4|0|

Scenario: the duration of a course influences the amount of courses one trainer can give in one month
Given <trainer> is qualified to give multiple courses
When the course duration is <course_duration_in_days>
And <trainer> gave <numberOfClasses> classes this month
Then <trainer> can still give <numberOfClassesLeft> classes this month

Examples:
|trainer|course_duration_in_days|numberOfClasses|numberOfClassesLeft|
|Davy|0.5|1|3|
|Davy|1|1|1|
|Davy|2|1|0|
|Davy|3|1|0|
|Davy|4|1|0|

Scenario: holidays
Given <trainer> is qualified to give multiple courses
When the trainer had <holidays> holidays this month
And the course duration is <course_duration_in_days>
And <trainer> gave <numberOfClasses> classes this month
Then <trainer> can still give <numberOfClassesLeft> classes this month

Examples:
|trainer|holidays|course_duration_in_days|numberOfClasses|numberOfClassesLeft|
|Davy|1|0.5|1|3|
|Davy|1|1|1|1|
|Davy|1|2|1|0|
|Davy|1|3|1|0|
|Davy|1|4|1|0|
|Davy|4|0.5|1|2|
|Davy|4|1|1|1|
|Davy|4|2|1|0|
|Davy|4|3|1|0|
|Davy|4|4|1|0|
|Davy|8|0.5|1|0|
|Davy|8|1|1|0|
|Davy|8|2|1|0|
|Davy|8|3|1|0|
|Davy|8|4|1|0|
