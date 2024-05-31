package com.ProyectoATOS.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ProyectoATOS.app.repositorio.JugadoresRepositorio;
import com.ProyectoATOS.app.variables.Jugadores;


@Controller
public class JugadoresController {

    @Autowired
    private JugadoresRepositorio jugadoresRepositorio;

    @GetMapping({"/verJugadores", "/mostrarJugadores", "/listarJugadores"})
    public String listarJugadores(Model model) {
        List<Jugadores> listaJugadores = jugadoresRepositorio.findAll();
        model.addAttribute("listaJugadores", listaJugadores);
        return "verJugadores";
    }

    @GetMapping("/verJugadores/formJugadores")
    public String mostrarFormulario(Model model) {
        model.addAttribute("jugadores", new Jugadores());
        return "formJugadores";
    }

    @PostMapping("/guardarJugadores")
    public String guardarJugadores(Jugadores jugadores) {
        jugadoresRepositorio.save(jugadores);
        return "redirect:/verJugadores";
    }

    @GetMapping("/jugadores/editar/{id}")
    public String modificarJugadores(@PathVariable("id") Integer id, Model model) {
        Jugadores jugadores = jugadoresRepositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid jugadores Id:" + id));
        model.addAttribute("jugadores", jugadores);
        return "formJugadores";
    }

    @GetMapping("/jugadores/eliminar/{id}")
    public String eliminarJugadores(@PathVariable("id") Integer id) {
        jugadoresRepositorio.deleteById(id);
        return "redirect:/verJugadores";
    }
}
