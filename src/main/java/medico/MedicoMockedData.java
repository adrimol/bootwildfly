/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medico;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADRIAN MOLINA
 */
public class MedicoMockedData {
    
    //Lista de medicos
    private List<Medico> medicos;
    
    private static MedicoMockedData instance = null;
    
    public static MedicoMockedData getInstance(){
        if(instance == null){
             instance = new MedicoMockedData();
         }
         return instance;
    }
    
    public MedicoMockedData(){
       medicos = new ArrayList<Medico>(); 
       medicos.add(new Medico(1, "Pedro", "Perez", 33, "Gastroenterologia"));
       medicos.add(new Medico(2, "Luis Ernesto", "Galvis", 29, "Pediatria"));
       medicos.add(new Medico(3, "Olivia", "Bernal", 36, "Medicina General"));
       medicos.add(new Medico(4, "Pablo", "Marquez Reinosa", 25, "Traumatologia"));
       medicos.add(new Medico(5, "Andres", "Molina", 31, "Medicina general"));
    }
    
    
    
    // retornar todos los medicos
    public List<Medico> fetchMedicos() {
        return medicos;
    }

    // return blog by id
    public Medico getMedicoById(int id) {
        for(Medico b: medicos) {
            if(b.getId() == id) {
                return b;
            }
        }
        return null;
    }
    
    
    // buscar medico por nombre o apellido
    public List<Medico> searchMedicos(String searchTerm) {
        List<Medico> searchedMedicos = new ArrayList<Medico>();
        for(Medico b: medicos) {
            if(b.getNombres().toLowerCase().contains(searchTerm.toLowerCase()) ||
               b.getApellidos().toLowerCase().contains(searchTerm.toLowerCase())) {
                searchedMedicos.add(b);
            }
        }
        return searchedMedicos;
    }

    // crear medico
    public Medico createMedico(int id, String nombres, String apellidos,
                        int edad, String especialidad) {
        Medico newMedico = new Medico(id, nombres, apellidos, edad, especialidad);
        medicos.add(newMedico);
        return newMedico;
    }
    
    
    // actualizar medico
    public Medico updateMedico(int id, String nombres, String apellidos, int edad, String especialidad) {
        for(Medico b: medicos) {
            if(b.getId() == id) {
                int medicoIndex = medicos.indexOf(b);
                b.setNombres(nombres);
                b.setApellidos(apellidos);
                b.setEdad(edad);
                b.setEspecialidad(especialidad);
                medicos.set(medicoIndex, b);
                return b;
            }
        }

        return null;
    }

    // borrar medico por id
    public boolean delete(int id){
        int medicoIndex = -1;
        for(Medico b: medicos) {
            if(b.getId() == id) {
                medicoIndex = medicos.indexOf(b);
                continue;
            }
        }
        if(medicoIndex > -1){
            medicos.remove(medicoIndex);
        }
        return true;
    }
}
