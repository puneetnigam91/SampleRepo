package myprj;

import org.springframework.integration.file.FileNameGenerator;
import org.springframework.messaging.Message;


public class ProcessedFileNameGenerator implements FileNameGenerator {

  
    public String generateFileName(Message<?> message) {        
        return message.getHeaders().get("file_name").toString()+".PROCESSED";
    }
}
