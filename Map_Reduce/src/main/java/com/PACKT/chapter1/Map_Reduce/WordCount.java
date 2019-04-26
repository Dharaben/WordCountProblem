//Defining package of the class
package com.PACKT.chapter1.Map_Reduce;
// Importing java libraries
import java.io.*;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import org.apache.hadoop.conf.*;

//Defining wordcount class for job configuration information
public class WordCount extends Configured implements Tool
{
	public int run(String[] args) throws IOException
	{
		JobConf conf = new JobConf(WordCount.class);
		conf.setJobName("WordCount");
		//For defining the output key format
		conf.setOutputKeyClass(Text.class);
		//For defining the output value format
		conf.setOutputValueClass(IntWritable.class);
		// For defining the Mapper class implementation
		conf.setMapperClass(Map.class);
		//For defining the Reducer class implementation
		conf.setReducerClass(Reduce.class);
		//For defining the type of input format
		conf.setInputFormat(TextInputFormat.class);
		//For defining the type of output format
		conf.setOutputFormat(TextOutputFormat.class);
		//For defining the command line argument sequence for  input dataset path
		FileInputFormat.setInputPaths(conf, new Path(args[0]));
		//For defining the command line argument sequence for output dataset path
		FileOutputFormat.setOutputPath(conf, new Path(args[1]));
		//For submitting the configuration object
		JobClient.runJob(conf);
		return 0;
	}
	 //Defining the main() method to start the execution of the MapReduce program
	 public static void main(String[] args) throws Exception 
	  {
		int exitCode = ToolRunner.run(new WordCount(), args); 
		System.out.println("Exit code:" +exitCode);
		System.exit(exitCode); 
		} 
	}