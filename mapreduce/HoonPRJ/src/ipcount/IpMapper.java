package ipcount;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class IpMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	@Override
	public void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {

		String line = value.toString();
		String ip = "";
		int forCnt = 0;

		for (String word : line.split("\\W+")) {
			if (word.length() > 0) {
				forCnt++;

				ip += (word + ".");
				if (forCnt == 4) {
					context.write(new Text(ip.substring(0, ip.length() - 1)),
							new IntWritable(1));
					break;
				}

			}
		}

	}

}
