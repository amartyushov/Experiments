###Found issues
- allure does not work
- (for some unknown reason) if feature file has one scenario, this scenario is executed once.
If feature file contains several scenarios, these scenarios are executed 3 times.
And this is not rerun of failed tests.
- dependency "courgette-jvm" dictates version of cucumber 

Solution looks too stricted, and badly controllable.