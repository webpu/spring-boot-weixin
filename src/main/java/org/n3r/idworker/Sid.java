package org.n3r.idworker;

import org.n3r.idworker.strategy.DefaultWorkerIdStrategy;
import org.n3r.idworker.utils.Utils;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Component
public class Sid {
    private static WorkerIdStrategy workerIdStrategy;
    private static IdWorker idWorker;

    static {
        configure(DefaultWorkerIdStrategy.instance);
    }


    public static synchronized void configure(WorkerIdStrategy custom) {
        if (workerIdStrategy != null) workerIdStrategy.release();
        workerIdStrategy = custom;
        idWorker = new IdWorker(workerIdStrategy.availableWorkerId()) {
            @Override
            public long getEpoch() {
                return Utils.midnightMillis();
            }
        };
    }

    /**
     * 一天最大毫秒86400000，最大占用27比特
     * 27+10+11=48位 最大值281474976710655(15字)，YK0XXHZ827(10字)
     * 6位(YYMMDD)+15位，共21位
     *
     * @return 固定21位数字字符串
     */

    public static String next() {
        long id = idWorker.nextId();
        String yyMMdd = new SimpleDateFormat("yyMMdd").format(new Date());
        return yyMMdd + String.format("%014d", id);
    }


    /**
     * 返回固定16位的字母数字混编的字符串。
     */
    public String nextShort() {
        long id = idWorker.nextId();
        String yyMMdd = new SimpleDateFormat("yyMMdd").format(new Date());
        return yyMMdd + Utils.padLeft(Utils.encode(id), 10, '0');
    }

    /**
     * 返回最少9位的字母数字混编的字符串，可以设置首字母。
     * @param String firstChar
     * @param int num
     * @return firstChar + rnd(num) 小于9 时自动生9个
     */
    public String charShortNo(String firstChar,int num) {
    	if(num<9){
    		num = 9;
    	}
        long id = idWorker.nextId();
        //String yyMMdd = new SimpleDateFormat("yyMMdd").format(new Date());
        return firstChar.toUpperCase() + Utils.padLeft(Utils.encode(id), num, '0');
    }
    
    /**
     * 返回固定32位的大写字母数字混编的字符串。
     */
    public String uuid() {
    	String randNo=java.util.UUID.randomUUID().toString().replace("-","").toUpperCase();
        return randNo;
    }
    
    
    public static void main(String[] args) {
		String aa = new Sid().uuid();
		String bb = new Sid().charShortNo("",10);
		
		System.out.println(aa);
		System.out.println(bb);
	}
}
