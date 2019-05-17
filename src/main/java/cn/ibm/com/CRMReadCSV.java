package cn.ibm.com;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class CRMReadCSV {

	public final static String FILE_PATH = "/Users/wangyingbo/Desktop/";
	public final static String FILE_NAME = "CMR-Contact-Email";
	public static void main(String[]args) {
		int count = 0;
		
		try {
			@SuppressWarnings("resource")
			BufferedReader reader  = new BufferedReader(new FileReader(FILE_PATH + "membership-contains-errors.csv"));
			int acc = 0;
			String line = reader.readLine();
			while(line!=null) {
				File file = new File(FILE_PATH + FILE_NAME + acc + ".csv");
				@SuppressWarnings("resource")
				BufferedWriter bWriter = new BufferedWriter(new FileWriter(file,true));
				
				bWriter.write(line);
				bWriter.newLine();
				bWriter.close();
		
				line = reader.readLine();
				
				System.out.println("=========>"+line);
				count++;
				if(count%600 == 0 ) {
					acc++;
				}
			}
			reader.close();
		}catch (FileNotFoundException e) {
			// TODO: handle exception
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
