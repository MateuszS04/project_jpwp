package project.jpwp.controllers;

import project.jpwp.RequireRole;
import project.jpwp.User;

import java.lang.reflect.Method;

public class AccessController {

    public static  void invokeMethodIfAllowed(Object target, String methodName, User user) {
        try{
            Method method=target.getClass().getMethod(methodName);
            if(method.isAnnotationPresent(RequireRole.class)){
                RequireRole requireRole=method.getAnnotation(RequireRole.class);
                if(user.getRole().equals(requireRole.value())){
                    System.out.println(requireRole.value());
                    return;
                }
            }
            method.invoke(target);
        }catch (NoSuchMethodException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
