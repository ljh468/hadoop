package extcount;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class ExtMapper extends Mapper<LongWritable, Text, Text, IntWritable>{

	@Override
	public void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		String line = value.toString().toLowerCase();
		String word ="";
		
		if (line.contains(".jpg")){
			word = "jpg";
			
		}else if (line.indexOf(".jpeg") > 0){
			word = "jpeg";
		}else if (line.indexOf(".gif") > 0){
			word = "gif";
		}else if (line.indexOf(".png") > 0){
			word = "png";
		}
		
		context.write(new Text(word), new IntWritable(1));
	}

}
