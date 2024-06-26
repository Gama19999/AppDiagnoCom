package com.gamars.diagnocom.basereglas;

import Rule.*;
import android.view.View;

import java.util.ArrayList;

public class DiagnoComBR {
    // Declaracion BASE DE REGLAS
    private final BooleanRuleBase br = new BooleanRuleBase("diagnocom");
    
    // Declaracion variables HECHOS (CONCLUSIONES)
    private RuleVariable afeccion;
    private RuleVariable enfermedad;
    private String nameHecho;
    
    // Declaracion variables de REGLAS (1-6)
    private RuleVariable afeccionCabeza;
    private RuleVariable afeccionRespiratoria;
    private RuleVariable afeccionDigestiva;
    private RuleVariable afeccionInterna;
    private RuleVariable afeccionUrinaria;
    private RuleVariable afeccionPiel;
    
    // Declaracion variables de REGLAS (7-8)
    private RuleVariable dolorCabeza;
    private RuleVariable presionArterialAlta;
    private RuleVariable fiebre;
    private RuleVariable zumbidoOidos;
    private RuleVariable nauseas;
    private RuleVariable dolorGarganta;
    private RuleVariable dolorOido;
    
    // Declaracion variables de REGLAS (9-17)
    private RuleVariable tos;
    private RuleVariable estornudos;
    private RuleVariable dolorArticulaciones;
    private RuleVariable dolorEspalda;
    private RuleVariable dolorPecho;
    private RuleVariable escurrimientoNasal;
    private RuleVariable fatiga;
    private RuleVariable congestionNasal;
    private RuleVariable dolorCorporal;
    private RuleVariable dificultadRespiratoria;
    
    // Declaracion variables de REGLAS (18-22)
    private RuleVariable dolorAbdominal;
    private RuleVariable evacuacionesConstantes;
    private RuleVariable acidezEstomacal;
    private RuleVariable vomito;
    private RuleVariable hemorragiaRectal;
    private RuleVariable diarrea;
    private RuleVariable evacuacionesConDolor;
    
    // Declaracion variables de REGLAS (23-26)
    
    // Declaracion variables de REGLAS (27)
    private RuleVariable dolorAlOrinar;
    private RuleVariable sangradoAlOrinar;
    
    // Declaracion variables de REGLAS (28)
    private RuleVariable pielEnrogecida;
    private RuleVariable inflamacionZona;
    private RuleVariable altaSensibilidadZona;
    
    
    // Metodos de ENCADENAMIETO
    public String getAfeccion(ArrayList<String> options) {
        starterBR(); // Inicializa la base de reglas
        afeccionCabeza.setValue(options.get(0)); // Establece el valor de esa variable, obtenido de un parametro en el metodo
        afeccionRespiratoria.setValue(options.get(1));
        afeccionDigestiva.setValue(options.get(2));
        afeccionInterna.setValue(options.get(3));
        afeccionUrinaria.setValue(options.get(4));
        afeccionPiel.setValue(options.get(5));
        br.forwardChain(); // Realiza el encadenamiento hacia adelante
        nameHecho = afeccion.getValue(); // Obtiene el HECHO del 1er encadenamiento
        return nameHecho;
    }

    public String getDx_Cabeza(ArrayList<String> options) {
        starterBR();
        afeccion.setValue(options.get(0));
        dolorCabeza.setValue(options.get(1));
        presionArterialAlta.setValue(options.get(2));
        fiebre.setValue(options.get(3));
        zumbidoOidos.setValue(options.get(4));
        nauseas.setValue(options.get(5));
        dolorGarganta.setValue(options.get(6));
        dolorOido.setValue(options.get(7));
        br.forwardChain();
        nameHecho = enfermedad.getValue();
        return nameHecho;
    }

    public String getDx_Respiratorio(ArrayList<String> options) {
        starterBR();
        afeccion.setValue(options.get(0));
        tos.setValue(options.get(1));
        fiebre.setValue(options.get(2));
        dolorGarganta.setValue(options.get(3));
        dolorPecho.setValue(options.get(4));
        escurrimientoNasal.setValue(options.get(5));
        fatiga.setValue(options.get(6));
        congestionNasal.setValue(options.get(7));
        dolorCabeza.setValue(options.get(8));
        dolorCorporal.setValue(options.get(9));
        dificultadRespiratoria.setValue(options.get(10));
        estornudos.setValue(options.get(11));
        dolorArticulaciones.setValue(options.get(12));
        dolorEspalda.setValue(options.get(13));
        br.forwardChain();
        nameHecho = enfermedad.getValue();
        return nameHecho;
    }

    public String getDx_Digestivo(ArrayList<String> options) {
        starterBR();
        afeccion.setValue(options.get(0));
        fiebre.setValue(options.get(1));
        dolorAbdominal.setValue(options.get(2));
        evacuacionesConstantes.setValue(options.get(3));
        nauseas.setValue(options.get(4));
        acidezEstomacal.setValue(options.get(5));
        vomito.setValue(options.get(6));
        fatiga.setValue(options.get(7));
        hemorragiaRectal.setValue(options.get(8));
        diarrea.setValue(options.get(9));
        evacuacionesConDolor.setValue(options.get(10));
        dolorPecho.setValue(options.get(11));
        br.forwardChain();
        nameHecho = enfermedad.getValue();
        return nameHecho;
    }

    public String getDx_Interno(ArrayList<String> options) {
        starterBR();
        afeccion.setValue(options.get(0));
        fiebre.setValue(options.get(1));
        dolorAbdominal.setValue(options.get(2));
        nauseas.setValue(options.get(3));
        vomito.setValue(options.get(4));
        tos.setValue(options.get(5));
        dolorPecho.setValue(options.get(6));
        acidezEstomacal.setValue(options.get(7));
        dolorEspalda.setValue(options.get(8));
        dificultadRespiratoria.setValue(options.get(9));
        fatiga.setValue(options.get(10));
        evacuacionesConstantes.setValue(options.get(11));
        dolorGarganta.setValue(options.get(12));
        hemorragiaRectal.setValue(options.get(13));
        diarrea.setValue(options.get(14));
        br.forwardChain();
        nameHecho = enfermedad.getValue();
        return nameHecho;
    }

    public String getDx_Urinario(ArrayList<String> options) {
        starterBR();
        afeccion.setValue(options.get(0));
        nauseas.setValue(options.get(1));
        dolorAlOrinar.setValue(options.get(2));
        sangradoAlOrinar.setValue(options.get(3));
        dolorEspalda.setValue(options.get(4));
        fiebre.setValue(options.get(5));
        br.forwardChain();
        nameHecho = enfermedad.getValue();
        return nameHecho;
    }

    public String getDx_Cutaneo(ArrayList<String> options) {
        starterBR();
        afeccion.setValue(options.get(0));
        pielEnrogecida.setValue(options.get(1));
        inflamacionZona.setValue(options.get(2));
        altaSensibilidadZona.setValue(options.get(3));
        br.forwardChain();
        nameHecho = enfermedad.getValue();
        return nameHecho;
    }

    /**
     * Inicializa los atributos de la clase
     */
    private void starterBR() {
        // Instancias de VARIABLES de regla
        afeccionCabeza = new RuleVariable(br, "AfeccionCabeza");
        afeccionRespiratoria = new RuleVariable(br, "AfeccioRespiratoria");
        afeccionDigestiva = new RuleVariable(br, "AfeccionDigestiva");
        afeccionInterna = new RuleVariable(br, "AfeccionInterna");
        afeccionUrinaria = new RuleVariable(br, "AfeccionUrinaria");
        afeccionPiel = new RuleVariable(br, "AfeccionPiel");
        
        dolorCabeza = new RuleVariable(br, "DolorCabeza");
        presionArterialAlta = new RuleVariable(br, "PresionArterialAlta");
        fiebre = new RuleVariable(br, "Fiebre");
        zumbidoOidos = new RuleVariable(br, "ZumbidoOidos");
        nauseas = new RuleVariable(br, "Nauseas");
        dolorGarganta = new RuleVariable(br, "DolorGarganta");
        dolorOido = new RuleVariable(br, "DolorOido");
        
        tos = new RuleVariable(br, "Tos");
        estornudos = new RuleVariable(br, "Estornudos");
        dolorArticulaciones = new RuleVariable(br, "DolorArticulaciones");
        dolorEspalda = new RuleVariable(br, "DolorEspalda");
        dolorPecho = new RuleVariable(br, "DolorPecho");
        escurrimientoNasal = new RuleVariable(br, "EscurrimientoNasal");
        fatiga = new RuleVariable(br, "Fatiga");
        congestionNasal = new RuleVariable(br, "CongestionNasal");
        dolorCorporal = new RuleVariable(br, "DolorCorporal");
        dificultadRespiratoria = new RuleVariable(br, "DificultadRespiratoria");
        
        dolorAbdominal = new RuleVariable(br, "DolorAbdominal");
        evacuacionesConstantes = new RuleVariable(br, "EvacuacionesConstantes");
        acidezEstomacal = new RuleVariable(br, "AcidezEstomacal");
        vomito = new RuleVariable(br, "Vomito");
        hemorragiaRectal = new RuleVariable(br, "HemorragiaRectal");
        diarrea = new RuleVariable(br, "Diarrea");
        evacuacionesConDolor = new RuleVariable(br, "EvacuacionesConDolor");
        
        dolorAlOrinar = new RuleVariable(br, "DolorAlOrinar");
        sangradoAlOrinar = new RuleVariable(br, "SangradoAlOrinar");
        
        pielEnrogecida = new RuleVariable(br, "PielEnrogecida");
        inflamacionZona = new RuleVariable(br, "InflamacionZona");
        altaSensibilidadZona = new RuleVariable(br, "AltaSensibilidadZona");
        
        // Instancias de CONSECUENTES de regla
        afeccion = new RuleVariable(br, "Afeccion");
        enfermedad = new RuleVariable(br, "Enfermedad");
        
        // Definicion de operadores logicos (condicionales)
        Condition igual = new Condition("=");
        
        // Creacion de reglas de validacion (Base de Reglas)
        // AFECCION
        Rule dCabeza = new Rule(br, "D.CABEZA",
                new Clause[]{new Clause(afeccionCabeza, igual, "si"),
                    new Clause(afeccionRespiratoria, igual, "no"),
                    new Clause(afeccionDigestiva, igual, "no"),
                    new Clause(afeccionInterna, igual, "no"),
                    new Clause(afeccionUrinaria, igual, "no"),
                    new Clause(afeccionPiel, igual, "no")},
                new Clause(afeccion, igual, "Diagnóstico Encefálico"));
        Rule dRespiratorio = new Rule(br, "D.RESPIRATORIO",
                new Clause[]{new Clause(afeccionCabeza, igual, "no"),
                    new Clause(afeccionRespiratoria, igual, "si"),
                    new Clause(afeccionDigestiva, igual, "no"),
                    new Clause(afeccionInterna, igual, "no"),
                    new Clause(afeccionUrinaria, igual, "no"),
                    new Clause(afeccionPiel, igual, "no")},
                new Clause(afeccion, igual, "Diagnóstico Respiratorio"));
        Rule dDigestivo = new Rule(br, "D.DIGESTIVO",
                new Clause[]{new Clause(afeccionCabeza, igual, "no"),
                    new Clause(afeccionRespiratoria, igual, "no"),
                    new Clause(afeccionDigestiva, igual, "si"),
                    new Clause(afeccionInterna, igual, "no"),
                    new Clause(afeccionUrinaria, igual, "no"),
                    new Clause(afeccionPiel, igual, "no")},
                new Clause(afeccion, igual, "Diagnóstico Digestivo"));
        Rule dInterno = new Rule(br, "D.INTERNO",
                new Clause[]{new Clause(afeccionCabeza, igual, "no"),
                    new Clause(afeccionRespiratoria, igual, "no"),
                    new Clause(afeccionDigestiva, igual, "no"),
                    new Clause(afeccionInterna, igual, "si"),
                    new Clause(afeccionUrinaria, igual, "no"),
                    new Clause(afeccionPiel, igual, "no")},
                new Clause(afeccion, igual, "Diagnóstico Interno"));
        Rule dUrinario= new Rule(br, "D.URINARIO",
                new Clause[]{new Clause(afeccionCabeza, igual, "no"),
                    new Clause(afeccionRespiratoria, igual, "no"),
                    new Clause(afeccionDigestiva, igual, "no"),
                    new Clause(afeccionInterna, igual, "no"),
                    new Clause(afeccionUrinaria, igual, "si"),
                    new Clause(afeccionPiel, igual, "no")},
                new Clause(afeccion, igual, "Diagnóstico Urinario"));
        Rule dCutaneo = new Rule(br, "D.CUTANEO",
                new Clause[]{new Clause(afeccionCabeza, igual, "no"),
                    new Clause(afeccionRespiratoria, igual, "no"),
                    new Clause(afeccionDigestiva, igual, "no"),
                    new Clause(afeccionInterna, igual, "no"),
                    new Clause(afeccionUrinaria, igual, "no"),
                    new Clause(afeccionPiel, igual, "si")},
                new Clause(afeccion, igual, "Diagnóstco Cutáneo"));
        
        // ENFERMEDAD CON D.CABEZA
        Rule migrania = new Rule(br, "MIGRAÑA",
                new Clause[]{new Clause(afeccion, igual, "Diagnóstico Encefálico"),
                    new Clause(dolorCabeza, igual, "si"),
                    new Clause(presionArterialAlta, igual, "si"),
                    new Clause(fiebre, igual, "no"),
                    new Clause(zumbidoOidos, igual, "si"),
                    new Clause(nauseas, igual, "si"),
                    new Clause(dolorGarganta, igual, "no"),
                    new Clause(dolorOido, igual, "no")},
                new Clause(enfermedad, igual, "Migraña"));
        Rule infeccionOido = new Rule(br, "INFECCION DE OIDO",
                new Clause[]{new Clause(afeccion, igual, "Diagnóstico Encefálico"),
                    new Clause(dolorCabeza, igual, "no"),
                    new Clause(presionArterialAlta, igual, "no"),
                    new Clause(fiebre, igual, "no"),
                    new Clause(zumbidoOidos, igual, "si"),
                    new Clause(nauseas, igual, "no"),
                    new Clause(dolorGarganta, igual, "si"),
                    new Clause(dolorOido, igual, "si")},
                new Clause(enfermedad, igual, "Infección de oido"));
        
        // ENFERMEDAD CON D.RESPIRATORIO
        Rule gripeComun = new Rule(br, "GRIPE COMUN",
                new Clause[]{new Clause(afeccion, igual, "Diagnóstico Respiratorio"),
                    new Clause(tos, igual, "si"),
                    new Clause(fiebre, igual, "si"),
                    new Clause(dolorGarganta, igual, "si"),
                    new Clause(dolorPecho, igual, "no"),
                    new Clause(escurrimientoNasal, igual, "si"),
                    new Clause(fatiga, igual, "si"),
                    new Clause(congestionNasal, igual, "si"),
                    new Clause(dolorCabeza, igual, "si"),
                    new Clause(dolorCorporal, igual, "si"),
                    new Clause(dificultadRespiratoria, igual, "no"),
                    new Clause(estornudos, igual, "si"),
                    new Clause(dolorArticulaciones, igual, "si"),
                    new Clause(dolorEspalda, igual, "si")},
                new Clause(enfermedad, igual, "Gripe común"));
        Rule bronquitis = new Rule(br, "BRONQUITIS",
                new Clause[]{new Clause(afeccion, igual, "Diagnóstico Respiratorio"),
                    new Clause(tos, igual, "si"),
                    new Clause(fiebre, igual, "no"),
                    new Clause(dolorGarganta, igual, "si"),
                    new Clause(dolorPecho, igual, "si"),
                    new Clause(escurrimientoNasal, igual, "si"),
                    new Clause(fatiga, igual, "si"),
                    new Clause(congestionNasal, igual, "no"),
                    new Clause(dolorCabeza, igual, "no"),
                    new Clause(dolorCorporal, igual, "no"),
                    new Clause(dificultadRespiratoria, igual, "si"),
                    new Clause(estornudos, igual, "no"),
                    new Clause(dolorArticulaciones, igual, "no"),
                    new Clause(dolorEspalda, igual, "si")},
                new Clause(enfermedad, igual, "Bronquitis"));
        Rule tosConFlema = new Rule(br, "TOS CON FLEMA",
                new Clause[]{new Clause(afeccion, igual, "Diagnóstico Respiratorio"),
                    new Clause(tos, igual, "si"),
                    new Clause(fiebre, igual, "no"),
                    new Clause(dolorGarganta, igual, "si"),
                    new Clause(dolorPecho, igual, "no"),
                    new Clause(escurrimientoNasal, igual, "no"),
                    new Clause(fatiga, igual, "no"),
                    new Clause(congestionNasal, igual, "si"),
                    new Clause(dolorCabeza, igual, "no"),
                    new Clause(dolorCorporal, igual, "no"),
                    new Clause(dificultadRespiratoria, igual, "no"),
                    new Clause(estornudos, igual, "no"),
                    new Clause(dolorArticulaciones, igual, "no"),
                    new Clause(dolorEspalda, igual, "no")},
                new Clause(enfermedad, igual, "Tos con flema"));
        Rule sinusitis = new Rule(br, "SINUSITIS",
                new Clause[]{new Clause(afeccion, igual, "Diagnóstico Respiratorio"),
                    new Clause(tos, igual, "no"),
                    new Clause(fiebre, igual, "no"),
                    new Clause(dolorGarganta, igual, "si"),
                    new Clause(dolorPecho, igual, "no"),
                    new Clause(escurrimientoNasal, igual, "si"),
                    new Clause(fatiga, igual, "no"),
                    new Clause(congestionNasal, igual, "si"),
                    new Clause(dolorCabeza, igual, "si"),
                    new Clause(dolorCorporal, igual, "no"),
                    new Clause(dificultadRespiratoria, igual, "no"),
                    new Clause(estornudos, igual, "si"),
                    new Clause(dolorArticulaciones, igual, "no"),
                    new Clause(dolorEspalda, igual, "no")},
                new Clause(enfermedad, igual, "Sinusitis"));
        Rule influenza = new Rule(br, "INFLUENZA",
                new Clause[]{new Clause(afeccion, igual, "Diagnóstico Respiratorio"),
                    new Clause(tos, igual, "si"),
                    new Clause(fiebre, igual, "si"),
                    new Clause(dolorGarganta, igual, "si"),
                    new Clause(dolorPecho, igual, "no"),
                    new Clause(escurrimientoNasal, igual, "si"),
                    new Clause(fatiga, igual, "si"),
                    new Clause(congestionNasal, igual, "si"),
                    new Clause(dolorCabeza, igual, "si"),
                    new Clause(dolorCorporal, igual, "si"),
                    new Clause(dificultadRespiratoria, igual, "si"),
                    new Clause(estornudos, igual, "si"),
                    new Clause(dolorArticulaciones, igual, "si"),
                    new Clause(dolorEspalda, igual, "si")},
                new Clause(enfermedad, igual, "Influenza"));
        Rule sinusitisBacteriana = new Rule(br, "SINUSITIS BACTERIANA",
                new Clause[]{new Clause(afeccion, igual, "Diagnóstico Respiratorio"),
                    new Clause(tos, igual, "si"),
                    new Clause(fiebre, igual, "no"),
                    new Clause(dolorGarganta, igual, "si"),
                    new Clause(dolorPecho, igual, "no"),
                    new Clause(escurrimientoNasal, igual, "si"),
                    new Clause(fatiga, igual, "no"),
                    new Clause(congestionNasal, igual, "si"),
                    new Clause(dolorCabeza, igual, "si"),
                    new Clause(dolorCorporal, igual, "no"),
                    new Clause(dificultadRespiratoria, igual, "no"),
                    new Clause(estornudos, igual, "si"),
                    new Clause(dolorArticulaciones, igual, "no"),
                    new Clause(dolorEspalda, igual, "no")},
                new Clause(enfermedad, igual, "Sinusitis bacteriana"));
        Rule neumonia = new Rule(br, "NEUMONIA",
                new Clause[]{new Clause(afeccion, igual, "Diagnóstico Respiratorio"),
                    new Clause(tos, igual, "si"),
                    new Clause(fiebre, igual, "si"),
                    new Clause(dolorGarganta, igual, "no"),
                    new Clause(dolorPecho, igual, "no"),
                    new Clause(escurrimientoNasal, igual, "no"),
                    new Clause(fatiga, igual, "si"),
                    new Clause(congestionNasal, igual, "no"),
                    new Clause(dolorCabeza, igual, "si"),
                    new Clause(dolorCorporal, igual, "si"),
                    new Clause(dificultadRespiratoria, igual, "si"),
                    new Clause(estornudos, igual, "no"),
                    new Clause(dolorArticulaciones, igual, "si"),
                    new Clause(dolorEspalda, igual, "si")},
                new Clause(enfermedad, igual, "Neumonía"));
        Rule fibrosisPulmonar = new Rule(br, "FIBROSIS PULMONAR",
                new Clause[]{new Clause(afeccion, igual, "Diagnóstico Respiratorio"),
                    new Clause(tos, igual, "si"),
                    new Clause(fiebre, igual, "no"),
                    new Clause(dolorGarganta, igual, "no"),
                    new Clause(dolorPecho, igual, "no"),
                    new Clause(escurrimientoNasal, igual, "no"),
                    new Clause(fatiga, igual, "si"),
                    new Clause(congestionNasal, igual, "no"),
                    new Clause(dolorCabeza, igual, "no"),
                    new Clause(dolorCorporal, igual, "si"),
                    new Clause(dificultadRespiratoria, igual, "si"),
                    new Clause(estornudos, igual, "no"),
                    new Clause(dolorArticulaciones, igual, "si"),
                    new Clause(dolorEspalda, igual, "si")},
                new Clause(enfermedad, igual, "Fibrosis pulmonar"));
        Rule bronquiolitis = new Rule(br, "BRONQUIOLITIS",
                new Clause[]{new Clause(afeccion, igual, "Diagnóstico Respiratorio"),
                    new Clause(tos, igual, "si"),
                    new Clause(fiebre, igual, "no"),
                    new Clause(dolorGarganta, igual, "no"),
                    new Clause(dolorPecho, igual, "no"),
                    new Clause(escurrimientoNasal, igual, "no"),
                    new Clause(fatiga, igual, "no"),
                    new Clause(congestionNasal, igual, "no"),
                    new Clause(dolorCabeza, igual, "si"),
                    new Clause(dolorCorporal, igual, "no"),
                    new Clause(dificultadRespiratoria, igual, "si"),
                    new Clause(estornudos, igual, "no"),
                    new Clause(dolorArticulaciones, igual, "no"),
                    new Clause(dolorEspalda, igual, "no")},
                new Clause(enfermedad, igual, "Bronquiolitis"));
        
        // ENFERMEDAD CON D.DIGESTIVO
        Rule infeccionEstomago = new Rule(br, "INFECCION DE ESTOMAGO",
                new Clause[]{new Clause(afeccion, igual, "Diangnóstico Digestivo"),
                    new Clause(fiebre, igual, "si"),
                    new Clause(dolorAbdominal, igual, "si"),
                    new Clause(evacuacionesConstantes, igual, "si"),
                    new Clause(nauseas, igual, "si"),
                    new Clause(acidezEstomacal, igual, "no"),
                    new Clause(vomito, igual, "si"),
                    new Clause(fatiga, igual, "no"),
                    new Clause(hemorragiaRectal, igual, "no"),
                    new Clause(diarrea, igual, "si"),
                    new Clause(evacuacionesConDolor, igual, "no"),
                    new Clause(dolorPecho, igual, "no")},
                new Clause(enfermedad, igual, "Infección de estómago"));
        Rule estrenimiento = new Rule(br, "ESTREÑIMIENTO",
                new Clause[]{new Clause(afeccion, igual, "Diangnóstico Digestivo"),
                    new Clause(fiebre, igual, "no"),
                    new Clause(dolorAbdominal, igual, "si"),
                    new Clause(evacuacionesConstantes, igual, "no"),
                    new Clause(nauseas, igual, "no"),
                    new Clause(acidezEstomacal, igual, "no"),
                    new Clause(vomito, igual, "no"),
                    new Clause(fatiga, igual, "no"),
                    new Clause(hemorragiaRectal, igual, "no"),
                    new Clause(diarrea, igual, "no"),
                    new Clause(evacuacionesConDolor, igual, "si"),
                    new Clause(dolorPecho, igual, "no")},
                new Clause(enfermedad, igual, "Estreñimiento"));
        Rule indigestion = new Rule(br, "INDIGESTIÓN",
                new Clause[]{new Clause(afeccion, igual, "Diangnóstico Digestivo"),
                    new Clause(fiebre, igual, "no"),
                    new Clause(dolorAbdominal, igual, "si"),
                    new Clause(evacuacionesConstantes, igual, "no"),
                    new Clause(nauseas, igual, "si"),
                    new Clause(acidezEstomacal, igual, "si"),
                    new Clause(vomito, igual, "no"),
                    new Clause(fatiga, igual, "no"),
                    new Clause(hemorragiaRectal, igual, "no"),
                    new Clause(diarrea, igual, "no"),
                    new Clause(evacuacionesConDolor, igual, "no"),
                    new Clause(dolorPecho, igual, "no")},
                new Clause(enfermedad, igual, "Indigestión"));
        Rule gastritis = new Rule(br, "GASTRITIS",
                new Clause[]{new Clause(afeccion, igual, "Diangnóstico Digestivo"),
                    new Clause(fiebre, igual, "no"),
                    new Clause(dolorAbdominal, igual, "si"),
                    new Clause(evacuacionesConstantes, igual, "no"),
                    new Clause(nauseas, igual, "no"),
                    new Clause(acidezEstomacal, igual, "si"),
                    new Clause(vomito, igual, "si"),
                    new Clause(fatiga, igual, "no"),
                    new Clause(hemorragiaRectal, igual, "si"),
                    new Clause(diarrea, igual, "no"),
                    new Clause(evacuacionesConDolor, igual, "si"),
                    new Clause(dolorPecho, igual, "si")},
                new Clause(enfermedad, igual, "Gastritis"));
        Rule colitis = new Rule(br, "COLITIS",
                new Clause[]{new Clause(afeccion, igual, "Diangnóstico Digestivo"),
                    new Clause(fiebre, igual, "no"),
                    new Clause(dolorAbdominal, igual, "si"),
                    new Clause(evacuacionesConstantes, igual, "no"),
                    new Clause(nauseas, igual, "no"),
                    new Clause(acidezEstomacal, igual, "no"),
                    new Clause(vomito, igual, "no"),
                    new Clause(fatiga, igual, "no"),
                    new Clause(hemorragiaRectal, igual, "si"),
                    new Clause(diarrea, igual, "si"),
                    new Clause(evacuacionesConDolor, igual, "no"),
                    new Clause(dolorPecho, igual, "no")},
                new Clause(enfermedad, igual, "Colitis"));
        
        // ENFERMEDAD CON D.INTERNO
        Rule apendicitis = new Rule(br, "APENDICITIS",
                new Clause[]{new Clause(afeccion, igual, "Diangnóstico Interno"),
                    new Clause(fiebre, igual, "si"),
                    new Clause(dolorAbdominal, igual, "si"),
                    new Clause(nauseas, igual, "si"),
                    new Clause(vomito, igual, "si"),
                    new Clause(tos, igual, "no"),
                    new Clause(dolorPecho, igual, "no"),
                    new Clause(acidezEstomacal, igual, "no"),
                    new Clause(dolorEspalda, igual, "no"),
                    new Clause(dificultadRespiratoria, igual, "no"),
                    new Clause(fatiga, igual, "no"),
                    new Clause(evacuacionesConstantes, igual, "si"),
                    new Clause(dolorGarganta, igual, "no"),
                    new Clause(hemorragiaRectal, igual, "no"),
                    new Clause(diarrea, igual, "no")},
                new Clause(enfermedad, igual, "Apendicitis"));
        Rule esofagitis = new Rule(br, "ESOFAGITIS",
                new Clause[]{new Clause(afeccion, igual, "Diangnóstico Interno"),
                    new Clause(fiebre, igual, "no"),
                    new Clause(dolorAbdominal, igual, "si"),
                    new Clause(nauseas, igual, "si"),
                    new Clause(vomito, igual, "si"),
                    new Clause(tos, igual, "no"),
                    new Clause(dolorPecho, igual, "si"),
                    new Clause(acidezEstomacal, igual, "si"),
                    new Clause(dolorEspalda, igual, "no"),
                    new Clause(dificultadRespiratoria, igual, "no"),
                    new Clause(fatiga, igual, "no"),
                    new Clause(evacuacionesConstantes, igual, "no"),
                    new Clause(dolorGarganta, igual, "si"),
                    new Clause(hemorragiaRectal, igual, "no"),
                    new Clause(diarrea, igual, "no")},
                new Clause(enfermedad, igual, "Esofagitis"));
        Rule pancreatitis = new Rule(br, "PANCREATITIS",
                new Clause[]{new Clause(afeccion, igual, "Diangnóstico Interno"),
                    new Clause(fiebre, igual, "no"),
                    new Clause(dolorAbdominal, igual, "si"),
                    new Clause(nauseas, igual, "si"),
                    new Clause(vomito, igual, "si"),
                    new Clause(tos, igual, "no"),
                    new Clause(dolorPecho, igual, "no"),
                    new Clause(acidezEstomacal, igual, "no"),
                    new Clause(dolorEspalda, igual, "si"),
                    new Clause(dificultadRespiratoria, igual, "no"),
                    new Clause(fatiga, igual, "no"),
                    new Clause(evacuacionesConstantes, igual, "no"),
                    new Clause(dolorGarganta, igual, "no"),
                    new Clause(hemorragiaRectal, igual, "si"),
                    new Clause(diarrea, igual, "si")},
                new Clause(enfermedad, igual, "Pancreatitis"));
        Rule anemia = new Rule(br, "ANEMIA",
                new Clause[]{new Clause(afeccion, igual, "Diangnóstico Interno"),
                    new Clause(fiebre, igual, "no"),
                    new Clause(dolorAbdominal, igual, "no"),
                    new Clause(nauseas, igual, "no"),
                    new Clause(vomito, igual, "si"),
                    new Clause(tos, igual, "no"),
                    new Clause(dolorPecho, igual, "no"),
                    new Clause(acidezEstomacal, igual, "no"),
                    new Clause(dolorEspalda, igual, "no"),
                    new Clause(dificultadRespiratoria, igual, "no"),
                    new Clause(fatiga, igual, "si"),
                    new Clause(evacuacionesConstantes, igual, "no"),
                    new Clause(dolorGarganta, igual, "no"),
                    new Clause(hemorragiaRectal, igual, "no"),
                    new Clause(diarrea, igual, "no")},
                new Clause(enfermedad, igual, "Anemia"));
        
        // ENFERMEDAD CON D.URINARIO
        Rule infeccionUrinaria = new Rule(br, "INFECCION URINARIA",
                new Clause[]{new Clause(afeccion, igual, "Diangnóstico Urinario"),
                    new Clause(nauseas, igual, "si"),
                    new Clause(dolorAlOrinar, igual, "si"),
                    new Clause(sangradoAlOrinar, igual, "si"),
                    new Clause(dolorEspalda, igual, "si"),
                    new Clause(fiebre, igual, "si")},
                new Clause(enfermedad, igual, "Infección urinaria"));
        
        // ENFERMEDAD CON D.CUTANEO
        Rule infeccionPiel = new Rule(br, "INFECCION DE LA PIEL",
                new Clause[]{new Clause(afeccion, igual, "Diangnóstico Cutáneo"),
                    new Clause(pielEnrogecida, igual, "si"),
                    new Clause(inflamacionZona, igual, "si"),
                    new Clause(altaSensibilidadZona, igual, "si")},
                new Clause(enfermedad, igual, "Infección de la piel"));
    }
}
