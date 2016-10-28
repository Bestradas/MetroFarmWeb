package co.jankins.psf.common.util;

import java.util.ArrayList;
import java.util.Arrays;

import co.janker.dto.objresponse.ObjectResponse;

public class Utilities {
	
    public static Class[] getClassObjectResponse(ObjectResponse obj,Object remoteObject) {
        Class clazz[];
        if (remoteObject instanceof ArrayList) {
        	ArrayList<Class> clases=new ArrayList<Class>();
        	
        	for (Object object : (ArrayList)remoteObject) {
        		boolean exist=false;
        		for (Class class1 : clases) {
					if(object.getClass().equals(class1)){
						exist=true;
						break;
					}
				}
        		if(!exist){
        			clases.add(object.getClass());
        		}
				
			}
        	
        	clazz=new Class[clases.size()+1];
        	for (int i = 0; i < clazz.length-1; i++) {
				clazz[i]=clases.get(i);
			}
        	
            obj.setRecords((ArrayList) remoteObject);
        } else {
            obj.setObj(remoteObject);
            clazz=new Class[2];
            clazz[0] = remoteObject.getClass();
        }
        clazz[clazz.length-1]=ObjectResponse.class;
        
        return clazz;
    }

}
