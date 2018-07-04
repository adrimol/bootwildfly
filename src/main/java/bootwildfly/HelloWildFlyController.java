package bootwildfly;

import java.util.List;
import java.util.Map;
import medico.Medico;
import medico.MedicoMockedData;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class HelloWildFlyController {


    @RequestMapping("hello")
    public String sayHello(){
        return ("Hola, SpringBoot en Wildfly!");
    }
    
    MedicoMockedData medicoMockedData = MedicoMockedData.getInstance();

    @GetMapping("/medico")
    public List<Medico> index(){
        return medicoMockedData.fetchMedicos();
    }

    @GetMapping("/medico/{id}")
    public Medico show(@PathVariable String id){
        int medicoId = Integer.parseInt(id);
        return medicoMockedData.getMedicoById(medicoId);
    }

    @PostMapping("/medico/search")
    public List<Medico> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return medicoMockedData.searchMedicos(searchTerm);
    }

    @PostMapping("/medico")
    public Medico create(@RequestBody Map<String, String> body){
        int id = Integer.parseInt(body.get("id"));
        String nombres = body.get("title");
        String apellidos = body.get("content");
        int edad = Integer.parseInt(body.get("edad"));
        String especialidad = body.get("especialidad");
        return medicoMockedData.createMedico(id, nombres, apellidos, edad, especialidad);
    }

    @PutMapping("/medico/{id}")
    public Medico update(@PathVariable String id, @RequestBody Map<String, String> body){
        int medicoId = Integer.parseInt(id);
        String nombres = body.get("nombres");
        String apellidos = body.get("apellidos");
        int edad = Integer.parseInt(body.get("edad"));
        String especialidad = body.get("especialidad");
        return medicoMockedData.updateMedico(medicoId, nombres, apellidos, edad, especialidad);
    }

    @DeleteMapping("medico/{id}")
    public boolean delete(@PathVariable String id){
        int medicoId = Integer.parseInt(id);
        return medicoMockedData.delete(medicoId);
    }
}