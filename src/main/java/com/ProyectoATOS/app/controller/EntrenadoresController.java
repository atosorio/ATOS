package com.ProyectoATOS.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ProyectoATOS.app.repositorio.EntrenadoresRepositorio;
import com.ProyectoATOS.app.variables.Entrenadores;


@Controller
public class EntrenadoresController {

    @Autowired
    private EntrenadoresRepositorio entrenadoresRepositorio;

    @GetMapping({"/verEntrenadores", "/mostrarEntrenadores", "/listarEntrenadores"})
    public String listarEntrenadores(Model model) {
        List<Entrenadores> listaEntrenadores = entrenadoresRepositorio.findAll();
        model.addAttribute("listaEntrenadores", listaEntrenadores);
        return "verEntrenadores";
    }

    @GetMapping("/verEntrenadores/formEntrenadores")
    public String mostrarFormulario(Model model) {
        model.addAttribute("entrenadores", new Entrenadores());
        return "formEntrenadores";
    }

    @PostMapping("/guardarEntrenadores")
    public String guardarEntrenadores(Entrenadores entrenadores) {
        entrenadoresRepositorio.save(entrenadores);
        return "redirect:/verEntrenadores";
    }

    @GetMapping("/entrenadores/editar/{id}")
    public String modificarEntrenadores(@PathVariable("id") Integer id, Model model) {
        Entrenadores entrenadores = entrenadoresRepositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid entrenadores Id:" + id));
        model.addAttribute("entrenadores", entrenadores);
        return "formEntrenadores";
    }

    @GetMapping("/entrenadores/eliminar/{id}")
    public String eliminarEntrenadores(@PathVariable("id") Integer id) {
        entrenadoresRepositorio.deleteById(id);
        return "redirect:/verEntrenadores";
    }
}
