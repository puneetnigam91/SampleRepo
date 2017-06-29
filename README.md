# SampleRepo
My Repo 1
The file inbound channel inspect every 5 second the input folder. If a new file is present a message with a payload of type file will be created and sent to the service activator.
1. Sum all the numbers in the file and create a new file containing the resulting value in the output directory.
2. The output file will have the same name as the input file with .PROCESSED appended to the end of the filename. 
3. Only process files with a .txt extension. 
4. If an error occurs, the input file should be put into the following directory (C:\SITA_TEST_TASK\ERROR).
