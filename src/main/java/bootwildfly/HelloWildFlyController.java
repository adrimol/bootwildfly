package bootwildfly;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    /*
    @PostMapping("/medico/search")
    public List<Medico> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return medicoMockedData.searchMedicos(searchTerm);
    }
    */
    
}