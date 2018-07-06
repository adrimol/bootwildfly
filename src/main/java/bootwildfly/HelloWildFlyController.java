package bootwildfly;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HelloWildFlyController {


    @RequestMapping("hello")
    public String sayHello(){
        return ("Hello, SpringBoot on Wildfly");
    }
    
    
    @RequestMapping("hola")
    public String sayHola(){
        return ("Hola, SpringBoot en Wildfly!");
    }
    
    MedicoMockedData medicoMockedData = MedicoMockedData.getInstance();
    
    @RequestMapping("/medico")
    @ResponseBody
    public List<Medico> index(){
        List<Medico> lstMedicos = medicoMockedData.fetchMedicos();
        /*String temp = "";
        for(Medico item:lstMedicos){
            temp += item.getNombres()+item.getApellidos()+item.getEspecialidad()+"<br>";
        }
        temp+="<br>Cantidad medicos: "+lstMedicos.size();*/
        return lstMedicos;
    }
    
    
    @RequestMapping("/medico/{id}")
    @ResponseBody
    public Medico show(@PathVariable String id){
        int medicoId = Integer.parseInt(id);
        //return "medicoId: "+medicoId; //
        return medicoMockedData.getMedicoById(medicoId);
    }
   
    @RequestMapping("/medico/search/{text}")
    @ResponseBody
    public List<Medico> search(@PathVariable String text){
        String searchTerm = (String)text;
        return medicoMockedData.searchMedicos(searchTerm);
    }
    
    
    @RequestMapping("/medico/crear/{data}")
    public Medico create(@PathVariable String data){
        String datos[] = data.split("-");
        int id = Integer.parseInt(datos[0]);
        String nombres = datos[1];
        String apellidos = datos[2];
        int edad = Integer.parseInt(datos[3]);
        String especialidad = datos[4];
        //return data.toString();
        return medicoMockedData.createMedico(id, nombres, apellidos, edad, especialidad);
    }
    
    
    @RequestMapping("medico/borrar/{id}")
    public boolean delete(@PathVariable String id){
        int medicoId = Integer.parseInt(id);
        return medicoMockedData.delete(medicoId);
    }
    
}