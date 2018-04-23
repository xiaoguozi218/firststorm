package org.apache.storm.firststorm;

import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Tuple;

/**
 * @author MintQ
 * 这个类就是用于执行具体的作业，准确的说是execute方法用来执行相关的计算
 */
public class SenqueceBolt extends BaseBasicBolt {

	public void execute(Tuple arg0, BasicOutputCollector arg1) {
		String word = (String) arg0.getValue(0);
		String out = "Hello " + word + "!";
		System.out.println(out);
	}

	public void declareOutputFields(OutputFieldsDeclarer arg0) {
		// TODO Auto-generated method stub
		
	}

}
