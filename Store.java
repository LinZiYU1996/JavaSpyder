package myspyder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Store {
	
	
	public void store_contents(List<String> contents) throws IOException {
		File file = new File("my6.txt");
		FileWriter fileWriter = new FileWriter(file);
		for(int i=0;i<contents.size();i++) {
			fileWriter.write(contents.get(i));
			/*换行和分隔*/
			fileWriter.write("\r\n");
			fileWriter.write("-----------");
			fileWriter.write("\r\n");
			fileWriter.flush();
		}
		
	}
}
