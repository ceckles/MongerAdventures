/**
 * IDE: IntelliJ IDEA
 * File Name: InputValidation
 * Created by: Chad Eckles.
 * Date: 7/12/2017
 * INFO:
 */
package Validation;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class InputValidation {

    Scanner _input = new Scanner(System.in);

    public String strValid(String message){
        String x = "";
        if(StringUtils.isBlank(x) || StringUtils.isEmpty(x)){
            do
            {
                System.out.println(message);
                x = _input.next();
            }while(StringUtils.isEmpty(x) || StringUtils.isBlank(x));
            return  x;
        }
        else
        {
         return x;
        }
    }

    public Integer intValid(Integer i){
        Integer x = 0;
        if(i <= 0 ){
            return i;
        }
        return i;
    }
}
