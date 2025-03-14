package pe.edu.idat.demo_web_formularios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.idat.demo_web_formularios.model.ImcModel;

@Controller
public class ImcController {
    @GetMapping("/imc")
    public String formularioImc(Model model){
        model.addAttribute("imcmodel",
                new ImcModel());
        return "imc";
    }

    @PostMapping("/calcularimc")
    public String calcularImc(@ModelAttribute("imcmodel")
                                  ImcModel imc,
                              Model model){
        Double tallam = imc.getTalla() / 100;
        Double valorImc = imc.getPeso() / (tallam * tallam);
        String diagnostico = "";
        if(valorImc <= 18.5){
            diagnostico = "Por debajo del peso.";
        } else if(valorImc <= 25){
            diagnostico = "con peso normal";
        } else if(valorImc <= 30){
            diagnostico = "con sobrepeso";
        } else if(valorImc <= 36){
            diagnostico = "obesidad leve";
        } else if(valorImc <= 39){
            diagnostico = "obsidad media";
        }else {
            diagnostico = "obesidad mórbida";
        }
        model.addAttribute("resultado",
                "Su valor IMC = " + valorImc +
                ", usted se encuentra: " +diagnostico);
        return "imc";
    }





}
