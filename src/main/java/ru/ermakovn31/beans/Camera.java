package ru.ermakovn31.beans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component("camera")
public class Camera {

    @Autowired
    private CameraRoll cameraRoll;

    public void makePhoto() {
        System.out.println("Making photo...");
        cameraRoll.makePhoto();
        System.out.println("Done");
    }
}
