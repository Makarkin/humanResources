package application;

import controller.ControllerClass;
import model.SQLFunction;

import java.util.logging.Level;

public class ApplicationMain {
        /**
     *This is main method with created exemplar "ControllerClass".
     * It starts console application and create query to database.
     * @see ControllerClass
     */
    public static void main(String[] args) {
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        ControllerClass controllerClass = new ControllerClass();
        controllerClass.getInformation();
    }
}
