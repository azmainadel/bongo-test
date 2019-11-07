## Pseudocode

	Override the onCreate() method of the superclass
		Call onCreate method of superclass passing the Bundle
		Inflate XML into a view object and set it as the content view
		
		If there is a saved state of the instance do
			get video current position from the save
			
			
	Override the onSaveInstanceState() method of the superclass
		Save the current video position on a Bundle


	Find a view that is identified by the id attribute from the XML related to the activity
		Initialize and bind Text view, Video view
		Initialize a Media Controller for the Video view
		Set the Video view as the media player for Media Controller

	Initialize the media player
		Get all the Media file objects on to a list
		Set Uri of Media file to the Video view
		Register a setOnPreparedListener() method for the Video view
			If Media player is prepared do
				Hide buffering text view
				Seek to saved position if available
				Start playing
		Register a setOnCompletionListener() method for the Video view
			Upon completion of the video
				Show Toast message
				Seek to first position of the video
	
	Within onStart() method call
		Start the player
	
	Within onStop() method call
		Stop the player
		
	Within onPause() method call
		Check for SDK version
			Pause the player

## Design Pattern

I have not used any known Design Pattern to implement the video player. It can be treated as a modified version of the popular *MVC* pattern. 

The media files are models here.
The *MainActivity* acts as the View and the Controller. The MediaController object is modified by the user which triggers the changes in the View (Video play/pause)
