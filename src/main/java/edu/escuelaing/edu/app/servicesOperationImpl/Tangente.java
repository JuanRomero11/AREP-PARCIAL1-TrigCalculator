package edu.escuelaing.edu.app.servicesOperationImpl;

import edu.escuelaing.edu.app.servicesOperation.Operations;

public class Tangente implements Operations {

    public double getResult(double numero) {
        return Math.tan(numero);
    }
}
