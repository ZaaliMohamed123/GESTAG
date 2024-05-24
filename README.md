# GESTAG

The GESTAG application is designed to manage trainees, internships, and registrations for internships. This particular case study focuses on the registration part of the application, which includes creating a trainee if they do not already exist. The application involves the development of a web application using Java/JEE. The relational model will be coded in Oracle, along with the creation of procedures and stored functions to manage trainee registrations.

Collaborators: https://github.com/SEKALDouaa , https://github.com/SinisterPlagueBot

Key Features:

External Data Schema:

The application utilizes an excerpt from the relational database "Gestion Stagiaires" to manage trainees, internships, and registrations.
Processing:

The application starts with a stage selection screen, displaying a list of all available stages. The list can be sorted by type or start date, with the default being sorted by date.
Users can select a stage from the list. If registrations are still open, detailed information about the stage, including the list of registered trainees, is displayed.
They can also return to the beginning to choose another stage. If the selected trainee does not exist in the list, users can create a new trainee . After entering the trainee's information, they return to the registration window, where the list of trainees is updated.
The selected trainee's information is displayed on the window. After selecting the status, users can validate the registration or abandon it.
If the number of registered trainees is equal to or greater than the number of available slots, the trainee's position code in the registration table is set to "3" for waiting list; otherwise, it is set to "2" for registered.
After validation, the registration is recorded in the table, and the stage is updated with the incremented number of registrations.
A message "Registration saved" with an "OK" button appears. Window Overview:

Window 1: Login Page
Window 2: Stage selection screen
Window 3: Detailed information about the selected stage and list of registered trainees
Window 4: Registration for the stage
Window 5: Creation of a new trainee
Window 6: Registration saved Page

This project aims to streamline the process of managing trainee registrations and internships, offering a user-friendly interface for both administrators and trainees.
