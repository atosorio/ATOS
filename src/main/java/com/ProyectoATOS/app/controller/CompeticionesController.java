package com.ProyectoATOS.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ProyectoATOS.app.repositorio.CompeticionesRepositorio;
import com.ProyectoATOS.app.variables.Competiciones;


@Controller
public class CompeticionesController {

    @Autowired
    private CompeticionesRepositorio competicionesRepositorio;

    @GetMapping("/verCompeticiones")
    public String listarCompeticiones(Model model) {
        List<Competiciones> listaCompeticiones = competicionesRepositorio.findAll();
        model.addAttribute("listaCompeticiones", listaCompeticiones);
        return "verCompeticiones";
    }

    @GetMapping("/verCompeticiones/formCompeticion")
    public String mostrarFormulario(Model model) {
        model.addAttribute("competicion", new Competiciones());
        return "formCompeticiones";
    }

    @PostMapping("/guardarCompeticion")
    public String guardarCompeticion(@ModelAttribute("competicion") Competiciones competicion) {
        competicionesRepositorio.save(competicion);
        return "redirect:/verCompeticiones";
    }


    @GetMapping("/competicion/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable("id") Integer id, Model model) {
        Competiciones competicion = competicionesRepositorio.findById(id).orElseThrow(() -> new IllegalArgumentException("Competicion no encontrada"));
        model.addAttribute("competicion", competicion);
        return "editarCompeticion"; // Debes tener una vista llamada editarCompeticion para mostrar el formulario de edición
    }


    @GetMapping("/competicion/eliminar/{id}")
    public String eliminarCompeticion(@PathVariable("id") Integer id) {
        competicionesRepositorio.deleteById(id);
        return "redirect:/verCompeticiones";
    }
}

