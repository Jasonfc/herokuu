package com.pit.pasteleria.venta.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public abstract class Utilititarios {

	
	public static byte[] getBytesFromFile(File file) throws IOException {
		if(file!= null){
			InputStream is = new FileInputStream(file);

		    byte[] bytes = new byte[(int)file.length()];


		    int offset = 0;
		    int numRead = 0;
		    while (offset < bytes.length  && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
		        offset += numRead;
		    }
		  
		    is.close();
		    return bytes;
		}else{
			return null;
		}
	    
	   
	}
}
