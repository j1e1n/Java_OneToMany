package com.example.FilesHW.components;

import com.example.FilesHW.models.File;
import com.example.FilesHW.models.Folder;
import com.example.FilesHW.models.User;
import com.example.FilesHW.repositories.FileRepository;
import com.example.FilesHW.repositories.FolderRepository;
import com.example.FilesHW.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    FileRepository fileRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args){

        User user = new User("Jen");
        userRepository.save(user);

        Folder coding = new Folder("Coding", user);
        folderRepository.save(coding);
        Folder familyTree = new Folder("Family Tree", user);
        folderRepository.save(familyTree);

        File file1 = new File("Python_Project", ".py", 15, coding);
        fileRepository.save(file1);
        File file2 = new File("JavaScriptApp", ".js", 10, coding);
        fileRepository.save(file2);
        File file3 = new File("JavaNotes", ".java", 8, coding);
        fileRepository.save(file3);

        File photo = new File("Old_Photo", ".png", 20, familyTree);
        fileRepository.save(photo);
        File document = new File("Birth_Record", ".pdf", 7, familyTree);
        fileRepository.save(document);

        user.addFolderToUser(coding);
        user.addFolderToUser(familyTree);
        userRepository.save(user);

        coding.addFileToFolder(file1);
        coding.addFileToFolder(file2);
        coding.addFileToFolder(file3);
        folderRepository.save(coding);
        coding.addFileToFolder(photo);
        coding.addFileToFolder(document);
        folderRepository.save(familyTree);



    }

}
