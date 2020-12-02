package hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class LocalFileUpload {

	public static void main(String[] args) throws Exception{
		
		try {
			
			Configuration conf = new Configuration();
			conf.set("fs.defaultFS", "hdfs://192.168.26.131:9000");
			FileSystem hdfs = FileSystem.get(conf);
			
			System.out.println(hdfs.getHomeDirectory());
			System.out.println(hdfs.getWorkingDirectory());
			
			
			Path path = new Path("/localFile");
			Path localPath = new Path("C:\\hadoopTest\\Test.Date.txt");
			
			System.out.println(hdfs.exists(path));
			if(hdfs.exists(path)) {
				hdfs.delete(path, true);
				
			}
			
			// 파일 업로드 끝!
			hdfs.copyFromLocalFile(localPath, path);
			System.out.println("Local File Upload Finished!!");
			
			hdfs.close();
		}catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
