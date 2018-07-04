##model 
Dealing with data, represents data  
"What should we show the user?"
  
##view 
Gui  
Knows nothing about the implementation of the Controller  
"How should we show it to the user (what will it look like)?"

##controller 
Logic of application.  
Should know nothing about the implementations of the objects it's talking to  
"How do I figure out which models and views to show the user?"


##other patterns involved:  
- Observer. used by Model and View. When the information stored in the Model 
classes changes, the View classes need to be notified and updated with the 
latest information. In order to retain loose coupling between these Model/View
and also due to the fact that there can be several Views instantiated, 
the Observer pattern is a perfect candidate to accomplish this.

- Strategy: used by the Model.  
The Data Access Object pattern is a form of the strategy pattern 
it is used primarily by the Model to access different form of data-sources.
For example a MySQL/Postgres Database and XML files stored on the filesystem.

- Composite: used by the View.   
There can be several different views within a system designed according to MVC, 
in order for these different implementations to be composed together and exchanged at run time, 
the composite pattern is used.