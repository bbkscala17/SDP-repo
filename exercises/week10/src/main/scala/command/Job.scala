package command
//this is the command interface which is implemented by EmailJob, FileIOJob, LogginJob and SmsJob

trait Job {
    def run
}