package lxq.dockerboot.controller;

import org.omg.CORBA.Current;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 * @Author Yikair
 * @Create 2023/2/23 20:57
 * @Description
 */
@RestController
public class HelloController {
//    @Value("${server.port}")
    private String port;
    @RequestMapping("/docker/hello")
    public String helloDocker(){
        Calendar calendar= Calendar.getInstance();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        return "hello docker : " + dateFormat.format(calendar.getTime());
    }
}
