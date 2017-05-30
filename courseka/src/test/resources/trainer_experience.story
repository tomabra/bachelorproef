Meta:

Narrative:
As a training manager
I want to able to manage the trainer experience
So that I know which trainer can give which core, and I know which trainers can give a class together

Scenario: a trainer gives multiple courses
Given <trainer> gave <course> <times_given> times
Then the experience level for this course is <experience_level>

Examples:
|trainer|course|times_given|experience_level|
|Davy|Agile Introduction|4|senior|
|Davy|Agile Project Management|2|senior|
|Davy|Agile Engineering|1|junior|
|Davy|Marketing & Communication|0|junior|

Scenario: a trainer gives only 2 courses
Given <trainer> gave <course> <times_given> times
Then the experience level for this course is <experience_level>

Examples:
|trainer|course|times_given|experience_level|
|Davy|Agile Engineering|1|junior|
|Davy|Agile Testing|1|junior|

Scenario: re-education is needed
Given <trainer> gave <course> <times_given> times
And the experience level for this course is <experience_level>
When <reeducation>
Then the new experience level before the re-education is <experience_level_before_reeducation>

Examples:
|trainer|course|times_given|experience_level|reeducation|experience_level_before_reeducation|
|Davy|Agile Introduction|4|senior|reeducation needed|senior|
|Davy|Agile Project Management|2|senior|reeducation needed|junior|
|Davy|Agile Team Coaching|3|senior|reeducation needed|senior|

