package edu.escuelaing.edu.app;
import static spark.Spark.*;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import edu.escuelaing.edu.app.servicesOperation.Operations;
import edu.escuelaing.edu.app.servicesOperationImpl.Coseno;
import edu.escuelaing.edu.app.servicesOperationImpl.Seno;
import edu.escuelaing.edu.app.servicesOperationImpl.Tangente;
import spark.Request;
import spark.Response;

public class App {

    public static void main(String args[]){
        port(getPort());
        get("/index",(req,res) -> inputDataPage(req,res));
        
    }
	private static JSONObject  inputDataPage(Request req, Response res) {
		JSONObject  clima = connection(req, res);
		String pagina = "Hola! aqui encontraras la informacion del clima";
		String pagina2 = "el pais ingresado es: ";

		return clima;
	}

	public static JSONObject  connection(Request req, Response res) {
	    String[] listaNormal= req.queryParams("calcular").split("-");
	     double numero = Double.parseDouble(listaNormal[1]);
		String calcular = listaNormal[0];
		double resultadoOperacion = 0;
		Operations calculador;
		JSONObject objetoJson=new JSONObject();
		if (calcular.length() == 0) {
			objetoJson.put("No ingreso ningun valor","null");
		} else if(calcular.equals("cos")) {
			calculador =new Coseno();
			System.out.println();
			resultadoOperacion=calculador.getResult(numero);
			}
		 else if(calcular.equals("sen")) {
			 calculador =new Seno();
				resultadoOperacion=calculador.getResult(numero);
				}
			
		 else if(calcular.equals("tang")) {
			 calculador =new Tangente();
				resultadoOperacion=calculador.getResult(numero);				}
	
		objetoJson.put("Resultado del calculo",resultadoOperacion);
		//res.header("Content-Type", "application/json");
		return objetoJson;
	}

	static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }




}
