package vs.korzhina.SpringBootApp.hello;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class HelloController {

    ArrayList arList = null;
    HashMap map = null;

    @GetMapping("/hello")
    public String hello(@RequestParam (value="name", defaultValue="World") String name) {
        return String.format("Hello, %s!", name);
    }

    private boolean isFirstCallArray = true;
    @GetMapping("/update-array")
    public void updateArrayList(@RequestParam (value="s", defaultValue="") String s) {
        if (isFirstCallArray){
            isFirstCallArray=false;
            arList=new ArrayList<String>();
        }
        else {
            arList.add(s);
        }
    }

    @GetMapping("/show-array")
    public String showArrayList() {
        if (arList == null)
        return "ArrayList is not exist";
        else
        return arList.toString();
    }
    
    private boolean isFirstCallHashMap = true;
    private int mapKey=0;
    @GetMapping("/update-map")
    public void updateHashMap(@RequestParam (value="s", defaultValue="") String s) {
        if (isFirstCallHashMap){
            isFirstCallHashMap=false;
            map=new HashMap<Integer, String>();
        }
        else {
            map.put(mapKey, s);
            mapKey++;
        }
    }

    @GetMapping("/show-map")
    public String showHashMap() {
        if (map == null)
        return "HashMap is not exist";
        else
        return map.toString();
    }

    @GetMapping("/show-all-lenght")
    public String showAllLenght() {
        if (map == null && arList==null)
        return "HashMap and ArrayList are not exist";
        if (map == null)
        return "HashMap is not exist, ArrayList lenght = "+arList.size();
        if (arList == null)
        return "ArrayList is not exist, HashMap lenght = "+map.size();
        else
        return  "ArrayList lenght = " +arList.size()+ "; HashMap lenght = "+map.size();
    }
    
}
