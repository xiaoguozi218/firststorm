package org.apache.storm.firststorm;

import java.util.Map;
import java.util.Random;

import com.sun.xml.internal.bind.v2.model.annotation.FieldLocatable;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;

/**
 * @author MintQ
 *	首先建立RandomSpout类作为数据源，并且继承于父类BaseRichSpout
 */
public class RandomSpout extends BaseRichSpout {
	
	private SpoutOutputCollector collector;
	private static String[] words = {"Hadoop","Storm","Apache","Linux","Nginx","Tomcat","Spark"};

	//nextTuple的作用是把Tuple发送至下游
	public void nextTuple() {
		String word = words[new Random().nextInt(words.length)];
		collector.emit(new Values(word));
	}

	//open方法是数据源的初始化
	public void open(Map arg0, TopologyContext arg1, SpoutOutputCollector arg2) {
		this.collector = arg2;
	}

	//declareOutputFields用来定义输出字段
	public void declareOutputFields(OutputFieldsDeclarer arg0) {
		arg0.declare(new Fields("randomString"));
	}

}
