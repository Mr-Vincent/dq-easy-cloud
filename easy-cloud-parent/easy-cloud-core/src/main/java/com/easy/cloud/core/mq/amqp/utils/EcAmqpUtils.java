package com.easy.cloud.core.mq.amqp.utils;

import org.springframework.amqp.core.Queue;

import com.easy.cloud.core.mq.amqp.constant.EcAmqpQueueName.DqAmqpQueueNameEnum;

/**
 * DqAmqpUtils工具类
 * @author daiqi
 * 创建日期 2017年12月20日 下午11:46:58
 */
public class EcAmqpUtils {
	/**
	 * 
	 * <p>创建amqp的队列</p>
	 *
	 * <pre>DqAmqpUtils。createQueue(DqAmqpQueueNameEnum.queue_name_test)</pre>
	 *
	 * @param dqAmqpQueueNameEnum : amqp枚举类
	 * @return Queue : amqp队列
	 *
	 * author daiqi
	 * 创建时间  2017年12月20日 下午11:49:24
	 */
	public static Queue createQueue(DqAmqpQueueNameEnum dqAmqpQueueNameEnum){
		return new Queue(dqAmqpQueueNameEnum.getQueueName());
	}
}
