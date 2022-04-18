# Patient service

## Project description

This project designed to work with patient information. 
There are 2 methods:
* Download Excel file with all patient information
* Download PDF file of patient's sick leave by ID number of patient

`Patient.java` class define which information about patient saved.
There is no database connected. So, in this class there is 
`getPatients()` method that return list of 5 predefined patients.

`PatientService.java` class allow us to work with patients in
`Patient.getPatients()`.   
`getPatientsList()` method return Excel file of patients list.  
`getSickLeave(Long id)` method return sick leave of patient by ID number.

`PatientController.java` class allow us to make a requests and
download files.  
`downloadPatientsListExcel()` method allow downloading Excel file.  
`downloadSickLeavePdf(@RequestParam("id") Long id)` method
allow downloading PDF file.

`WriteIntoExcel.java` and `WriteIntoPDF.java` are classes that 
create Excel and PDF files.

You can check how it works by running the application and copy these
URLs to your browser:  
Get a list of patients:
http://localhost:8080/patient/download_patients_list

Get a patient sick leave:  
http://localhost:8080/patient/download_sick_leave?id=770324752349
http://localhost:8080/patient/download_sick_leave?id=561119351938
http://localhost:8080/patient/download_sick_leave?id=990815756819
http://localhost:8080/patient/download_sick_leave?id=120613659043
http://localhost:8080/patient/download_sick_leave?id=530629486927