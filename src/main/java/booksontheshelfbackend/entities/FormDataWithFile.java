package booksontheshelfbackend.entities;

import org.springframework.web.multipart.MultipartFile;

public class FormDataWithFile {

    private String name;
    private String email;
    private MultipartFile file;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
