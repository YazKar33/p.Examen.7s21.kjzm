package com.example.pexamen7s21kjzm;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import DatosExamen.EstructuraDatos;

public class PrincipalActivity extends AppCompatActivity {

    TextView txtpregunta;
    RadioButton respuesta1, respuesta2, respuesta3;
    Button btnant, btnsig, btncal;

    ArrayList<EstructuraDatos> listadatos = new ArrayList<>();

    int rastrear = 0;

    int puntosObtenidos = 0;

    int aciertos = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        txtpregunta = findViewById(R.id.txtpregunta);
        respuesta1 = findViewById(R.id.respuesta1);
        respuesta2 = findViewById(R.id.respuesta2);
        respuesta3 = findViewById(R.id.respuesta3);

        btnant = findViewById(R.id.btnant);
        btnsig = findViewById(R.id.btnsig);
        btncal = findViewById(R.id.btncal);

        EstructuraDatos ed = new EstructuraDatos();

        ed.setPregunta(" 1° ¿Cuál de los siguientes no es un tipo de datos de programación?");
        ed.setRespuesta1("(A) String");
        ed.setRespuesta2("(B) Boolean");
        ed.setRespuesta3("(C) Loop");
        ed.setRespuestaC("C");

        listadatos.add(ed);
        ed = new EstructuraDatos();

        ed.setPregunta(" 2° ¿Que estructura de controlpermite ejecutar un bloque de código repetidamente mientras se cumpla una condición?");
        ed.setRespuesta1("(A) if-else");
        ed.setRespuesta2("(B) while");
        ed.setRespuesta3("(C) switch");
        ed.setRespuestaC("B");

        listadatos.add(ed);
        ed = new EstructuraDatos();

        ed.setPregunta(" 3° ¿En que lenguaje de programación se utiliza la sintaxis echo(hola) para mostrar texto en consola;");
        ed.setRespuesta1("(A) JAVA");
        ed.setRespuesta2("(B) python");
        ed.setRespuesta3("(C) php");
        ed.setRespuestaC("C");

        listadatos.add(ed);
        ed = new EstructuraDatos();

        ed.setPregunta(" 4° ¿Qué significa el acrónimo HTML en el contexto de desarrollo web?");
        ed.setRespuesta1("(A) Hyper Text Markup Languaje");
        ed.setRespuesta2("(B) High-Level Text Management Languaje");
        ed.setRespuesta3("(C) Hyperlink and Text Markup Languaje");
        ed.setRespuestaC("A");

        listadatos.add(ed);
        ed = new EstructuraDatos();

        ed.setPregunta(" 5° ¿Cuál es el operador utilizado para calcular el módulo de una división en la mayoría de los lenguajes de programación?");
        ed.setRespuesta1("(A) %");
        ed.setRespuesta2("(B) /");
        ed.setRespuesta3("(C) *");
        ed.setRespuestaC("A");

        listadatos.add(ed);
        ed = new EstructuraDatos();

        ed.setPregunta(" 6° ¿Cuál de las siguientes no es una estructura de datos lineal");
        ed.setRespuesta1("(A) Stack");
        ed.setRespuesta2("(B) Queue");
        ed.setRespuesta3("(C) Tree");
        ed.setRespuestaC("C");

        listadatos.add(ed);
        ed = new EstructuraDatos();

        ed.setPregunta(" 7° ¿Qué es un algoritmo de ordenamiento?");
        ed.setRespuesta1("(A) Un conjunto de reglas para organizar datos en un orden específico");
        ed.setRespuesta2("(B) Una instrucción que detiene la ejecución del programa");
        ed.setRespuesta3("(C) Una función que realiza cálculos matemáticos");
        ed.setRespuestaC("A");

        listadatos.add(ed);
        ed = new EstructuraDatos();

        ed.setPregunta(" 8° ¿Qué es la recursión en programación");
        ed.setRespuesta1("(A) Una técnica que permite repetir un bloque de código");
        ed.setRespuesta2("(B) Una función que se llama asi misma");
        ed.setRespuesta3("(C) Una estructura de control para tomar decisiones");
        ed.setRespuestaC("B");

        listadatos.add(ed);
        ed = new EstructuraDatos();

        ed.setPregunta(" 9° ¿Qué es un bucle infinito en programación?");
        ed.setRespuesta1("(A) Un bucle que ejecuta un número especifico de veces");
        ed.setRespuesta2("(B) Un bucle que nunca se detiene");
        ed.setRespuesta3("(C) Un bucle que se ejecuta solo una vez");
        ed.setRespuestaC("B");

        listadatos.add(ed);
        ed = new EstructuraDatos();

        ed.setPregunta(" 10° ¿Cuál de los siguientes no es paradigma de programación");
        ed.setRespuesta1("(A) Orientado a objetos");
        ed.setRespuesta2("(B) Funcional");
        ed.setRespuesta3("(C) Secuencial");
        ed.setRespuestaC("C");

        listadatos.add(ed);
        EstructuraDatos edm = listadatos.get(0);
        txtpregunta.setText(edm.getPregunta());
        respuesta1.setText(edm.getRespuesta1());
        respuesta2.setText(edm.getRespuesta2());
        respuesta3.setText(edm.getRespuesta3());

        btnsig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String seleccion = obtenerRespuesta();
                if(seleccion != null){
                    listadatos.get(rastrear).setSeleccion(seleccion);
                }
                rastrear++;

                if(rastrear < listadatos.size()){
                    EstructuraDatos nextQuestion = listadatos.get(rastrear);
                    txtpregunta.setText(nextQuestion.getPregunta());
                    respuesta1.setText(nextQuestion.getRespuesta1());
                    respuesta2.setText(nextQuestion.getRespuesta2());
                    respuesta3.setText(nextQuestion.getRespuesta3());

                    respuesta1.setChecked(false);
                    respuesta2.setChecked(false);
                    respuesta3.setChecked(false);
                }

            }
        });

        btncal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (rastrear >= 0 && rastrear < listadatos.size()){
                    EstructuraDatos preguntaA = listadatos.get(rastrear);
                    String seleccion = obtenerRespuesta();

                    if (seleccion != null){
                        preguntaA.setSeleccion(seleccion);
                    }
                }
                puntosObtenidos = 0;
                aciertos = 0;

                for (EstructuraDatos pregunta : listadatos){
                    String seleccionPregunta = pregunta.getSeleccion();

                    if(seleccionPregunta != null){
                        if(seleccionPregunta.equals(pregunta.getRespuestaC())){
                            puntosObtenidos++;
                            aciertos++;
                        }
                    }
                }
                Toast.makeText(PrincipalActivity.this, "NÚMERO DE ACIETOS" +puntosObtenidos+ "Respuestas correctas" +aciertos , Toast.LENGTH_SHORT).show();
            }
        });
}

      private String obtenerRespuesta(){
        if (respuesta1.isChecked()){
            return "A";
        }else if(respuesta2.isChecked()){
            return "B";
        } else if (respuesta3.isChecked()) {
            return "C";

        }
          return null;
      }
}