package edu.escuelaing.edu.app.servicesOperationImpl;

import edu.escuelaing.edu.app.servicesOperation.Operations;

public class Seno implements Operations {

    public double getResult(double numero) {
        return Math.sin(numero);
    }
}
