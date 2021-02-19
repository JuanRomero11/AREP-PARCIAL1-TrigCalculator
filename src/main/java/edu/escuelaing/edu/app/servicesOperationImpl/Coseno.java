package edu.escuelaing.edu.app.servicesOperationImpl;

import edu.escuelaing.edu.app.servicesOperation.Operations;

public class Coseno implements Operations{

    public double getResult(double numero) {
        return Math.cos(numero);
    }
}
