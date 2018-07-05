package bootwildfly;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String index(){
        /*List<Medico> lstMedicos = new ArrayList<Medico>();
        Medico med = new Medico(0, "Pedro", "Perez", 26, "Gerontologia");
        lstMedicos.add(med);
        return ("Cantidad medicos: "+lstMedicos.size());*/
        List<Medico> lstMedicos = medicoMockedData.fetchMedicos();
        String temp = "";
        for(Medico item:lstMedicos){
            temp += item.getNombres()+item.getApellidos()+item.getEspecialidad()+"<br>";
        }
        return temp;
    }
}