# MobileAppFirstAssignment
First Programming Assignment for Mobile Apps and Services

## Revision History
1. Base sample application pushed with two fragments, button to switch between the two and bottom menu tab
2. Pushed code for flashlight open close on button to bugtest on another device
3. Flashlight code bugged and does nto accept user permissions. Removed from program after confirming need for
  seperate camera channels which does not appear to sucessfully work using bindings
4. Deleted original github repository and created the current one due to issues with pushing code with Git Bash with original repository
5. Added toggle button with counter operation to application
6. Added torch alert to button press
7. Connected application to Firebase database through backend API and allow a single string to be pushed to database
  through 2nd fragment
8. Added notifications to confirm database information is sucessfully pushed.

## Known Bugs
1. Application sometimes does not display / send notification to device correctly
2. Torch message on Firebase data send sometimes loops infinitely leading to application crash

## Running the Application
1. Application code can be downloaded on Github and converted into an APK file using an IDE like Android Studios or
a ZIP file service.
2. Moving the APK to an Android mobile device will allow the application to be run on that device.
