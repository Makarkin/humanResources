package application;

import controller.ControllerClass;

public class ApplicationMain {

    /**
     *This is main method with created exemplar "ControllerClass".
     * Exemplar starts console application and create query to database.
     * @see ControllerClass
     */
    public static void main(String[] args) {
        ControllerClass controllerClass = new ControllerClass();
        controllerClass.getInformation();
    }
}
