package com.rui.es_mysql.dao;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class StatisticsControllerTest {

    @Test
    public void rowkey(){
        String startTimeStr = "2020-09-29 06:57:00";
        String endTimeStr = "2020-09-29 06:57:00";
        String vin = "LNAA2AA31K5010854";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime startTime = LocalDateTime.parse(startTimeStr, df);
        LocalDateTime endTime = LocalDateTime.parse(endTimeStr, df);
        String rVin = new StringBuilder(vin).reverse().toString();
        String startRowKey = rVin + "_" + (Long.MAX_VALUE - endTime.toInstant(ZoneOffset.of("+8")).toEpochMilli());
        String endRowKey = rVin + "_" + (Long.MAX_VALUE - startTime.toInstant(ZoneOffset.of("+8")).toEpochMilli());
        System.out.println("scan 'car_data_en_rt',{STARTROW=>'"+ startRowKey+"',ENDROW=>'"+endRowKey+"',COLUMN=>'d:mrr'}");
        System.out.println("scan 'car_data_en_rt',{STARTROW=>'"+ startRowKey+"',ENDROW=>'"+endRowKey+"'}");
        System.out.println(startRowKey);
        System.out.println(endRowKey);
        System.out.println("get 'car_data_en_rt','"+startRowKey+"'");

    }


    public static void selectHbase(){
        String startTimeStr = "2020-09-29 14:20:00";
        String endTimeStr = "2020-09-29 14:22:00";
        String vin = "LNAB1AB35L5S20591";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime startTime = LocalDateTime.parse(startTimeStr, df);
        LocalDateTime endTime = LocalDateTime.parse(endTimeStr, df);
        String reversed_vin = new StringBuilder(vin).reverse().toString();
        String t1 = reversed_vin + "_" + (Long.MAX_VALUE - startTime.toInstant(ZoneOffset.of("+8")).toEpochMilli()); // row key
        String t2 = reversed_vin + "_" + (Long.MAX_VALUE - endTime.toInstant(ZoneOffset.of("+8")).toEpochMilli());// row key
        System.out.println("Long.MaxValue: " + Long.MAX_VALUE);
        System.out.println("t1: " + t1);
        System.out.println("t2: " + t2);
        System.out.println("echo \"scan 'car_data_en_rt',{STARTROW=>'"+ t2 +"',STOPROW=>'"+t1+"'}\" | hbase shell > hbasedata-"+vin+".txt");
        System.out.println("echo \"scan 'car_data_en_rt',{COLUMNS => 'd:mrr', STARTROW=>'"+ t2 +"',STOPROW=>'"+t1+"'}\" | hbase shell > hbasedata-"+vin+".txt");
        System.out.println("echo \"scan 'car_data_en_rt',{COLUMNS => 'd:tel', STARTROW=>'"+ t2 +"',STOPROW=>'"+t1+"'}\" | hbase shell > hbasedata-"+vin+".txt");
        System.out.println("echo \"scan 'car_data_en_rt',{COLUMNS => 'd:other', STARTROW=>'"+ t2 +"',STOPROW=>'"+t1+"'}\" | hbase shell > hbasedata-"+vin+".txt");
    }

    @Test
    public void hbaseTime(){
        //timestamp=1597288071818
        Date date = new Date(1600499330297L);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println("timestamp: "+format);

        //rowkey = 0001005LX3BA2CANL_9223370439566704807
        String rVin = new StringBuilder("0001005LX3BA2CANL").reverse().toString();
        System.out.println("vin:" + rVin);
        Instant instant = Instant.ofEpochMilli(Long.MAX_VALUE-9223370436175911807L);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String time = localDateTime.format(df);
        System.out.println("rowkey time: "+time);

        //验证
        Long startRowKey = Long.MAX_VALUE - LocalDateTime.parse("2020-08-24 14:15:48", df).toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println(startRowKey);

        //因此，rowkey中的时间错和数据中的timestamp是一样的
    }

    @Test
    public void speed(){
        Map<String, String> map = new LinkedHashMap<>();
        int start = 0;
        int end = 120;
        int interval = 5;
        for (int i = start+interval; i <= end; i+=interval) {
            map.put(i+"",(i-interval)+"~"+ i);
        }
    }

    @Test
    public void getBetweenDay(){
//        StatisticsTemplate statisticsTemplate = new StatisticsTemplate();
//        StatsReqDto statsReqDto = new StatsReqDto();
//        /*statsReqDto.setStartTime("2019-08-24");
//        statsReqDto.setEndTime("2020-08-24");*/
//        /*statsReqDto.setTimeType("year");
//        statisticsTemplate.statsDayTime(statsReqDto);
//        Map<String, Object> yearBetween = statisticsTemplate.betweenTime(statsReqDto);
//        System.out.println(yearBetween);
//        System.out.println(statsReqDto.getStartTime());
//        System.out.println(statsReqDto.getEndTime());*/
//        statisticsTemplate.currentMonth(statsReqDto);
//        System.out.println(statsReqDto.getStartTime());
//        System.out.println(statsReqDto.getEndTime());

    }

    public static void main(String[] args){
        selectHbase();
    }
}
