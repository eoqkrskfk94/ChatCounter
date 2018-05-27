package edu.handong.csee.java.hw3.chatcounter;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
/**
 * 
 * Runner class</br>
 * 
 * This class contains the following methods:</br>
 * 1. run(String[] args)</br>
 * 2. parseOptions(Options options, String[] args) </br>
 * 3. createOptions()</br>
 * 4. printHelp(Options options)</br> 
 * 
 * @author mjkim
 *
 */
public class Runner {

	boolean help;
	String inputdir;
	String outputdir;

	public void run(String[] args) {
		Options options = createOptions();

		if(parseOptions(options, args)){
			if (help){
				printHelp(options);
				return;
			}


			}
		}

	private boolean parseOptions(Options options, String[] args) {
		CommandLineParser parser = new DefaultParser();

		try {

			CommandLine cmd = parser.parse(options, args);

			inputdir = cmd.getOptionValue("i");
			outputdir = cmd.getOptionValue("o");
			help = cmd.hasOption("h");

		} catch (Exception e) {
			printHelp(options);
			return false;
		}

		return true;
	}

	// Definition Stage
	private Options createOptions() {
		Options options = new Options();

		//add options by using Option Builder
		options.addOption(Option.builder("i").longOpt("inputdir")
				.desc("Set a directory path that contains input files")
				.hasArg()
				.argName("Directory path input")
				.required()
				.build());

		//add options by using Option Builder
		options.addOption(Option.builder("o").longOpt("outputdir")
				.desc("Set a directory path that contains output files")
				.hasArg()
				.argName("Directory path output")
				.required()
				.build());		


		// add options by using OptionBuilder
		options.addOption(Option.builder("h").longOpt("help")
				.desc("Help")
				.build());

		return options;
	}

	private void printHelp(Options options) {
		// automatically generate the help statement
		HelpFormatter formatter = new HelpFormatter();
		String header = "ChatCounter Program";
		String footer ="\nPlease report issues at https://github.com/eoqkrskfk94";
		formatter.printHelp("ChatCounter", header, options, footer, true);
	}

}