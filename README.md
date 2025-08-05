WHAT THIS PROJECT IS ABOUT.

so i am currently learning android development with kotlin with a course by Alex that was posted on YouTube on FreeCodeCamp and also on the tutor's personal YT channel. i am currently at 22 hours out of 60 hours with 100+ hours of learning. so where i am at in the course is the building of a simple quiz app that asks you what the country is of a particular flag. so of course, i copied what the tutor did but i also noticed in the course of my testing in the AVD thaat there is a bug in the app. you can go to the next question without having answered the one currently being shown to you and i wasn't comfortable with that at all so i planned to fix it. Normally, when you click the check answer button, there should be a toast message that pops up at the bottom telling you that you haven't clicked an option and then when you click an option, you can then check the answer and then the text on the button changes from "check answer" to "next" which after clicking is supposed to reload the entire page with a new image of a flag with new options and all. that's the normal course of things but what i came up with has an issue which is that you can do all of the things i mentioned above except for reloading the page and i think the issue comes from something i just can't understand with the setQuestions() function. 

i have made a branch now which is the current version of my solution. i want to come back to this later and solve the issue because i rally have to move forward now.

so two things now which really come down to making new branches. 
1. the first branch would be another solution i currently have in mind which basically would be adding another button.
2. the second branch would be a copy of Alex's solution.

after working on my own fix for the bug, i would then merge it with Alex's code which would be the main application leaving out 1.
