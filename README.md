# SPRING-BATCH

A project to demonstrate the use of SPRING-BATCH.

It's a simple process where I get data from a FAKE API ( https://jsonplaceholder.typicode.com/ ), process the data and keep it in memory, H2 database, right after, I'll get that same data , processes them again and creates an EXCEL file and saves it locally, finally, before finishing it sends an email notifying the success of the whole process.
#
You can download and see the whole process working, you only have to change your email and password in the applications.properties file, in the JobListener file ( com/spring/batch/listeners) you will also have to change the email in the afterJob function.
#
I also recommend if you use Avast antivirus that you disable it for 10 minutes and if your google account has two-factor verification you should also temporarily disable it.
