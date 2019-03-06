package ru.ermakovn31.beans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component("cameraRoll")
public class CameraRoll {

    public void makePhoto() {
        System.out.println("-1 frame");
    }
}
