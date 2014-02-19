/**
 * 
 */
package com.p92.javacourse.javaplay.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * A simple serialization example.
 * It serializes an object and stores it in the ./tmp/SimpleSerializationExample.bin file then
 * deserialize it and prints the class name of the oject on the standard output.
 * @author BagyuraI
 */
public class SimpleSerializationExample 
{
	/** 
	 * A serializable class
	 * @author BagyuraI
	 */
	private static class CustomType implements Serializable
	{
		/**
		 * Serial version unique identifier.
		 */
		private static final long serialVersionUID = 1L;
		
	}
	
	
	/**
	 * @param args Runs this example.
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException 
	{
		
		serialize( new CustomType() );
		Object o = deserialize();
		System.out.println( o.getClass().getName() );
	}



	/**
	 * Serialize an object into the ./tmp/SimpleSerializationExample.bin file
	 * @param o Object to serialize
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static void serialize( Serializable o) throws FileNotFoundException, IOException 
	{
		try ( ObjectOutputStream out = new ObjectOutputStream( new FileOutputStream( "./tmp/SimpleSerializationExample.bin" ) );)
		{
			out.writeObject( o );
		}
	}
	
	/**
	 * Deserialize an object from the ./tmp/SimpleSerializationExample.bin file
	 * @return The deserialized object
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private static Object deserialize() throws FileNotFoundException, IOException, ClassNotFoundException 
	{
		try ( ObjectInputStream out = new ObjectInputStream( new FileInputStream( "./tmp/SimpleSerializationExample.bin" ) );)
		{
			return out.readObject();
		}
	}
	

}
