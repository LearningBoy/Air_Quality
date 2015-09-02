package com.way.HTTP;

/**
 * 调用PM25官网API，所有数据均来自PM25官网
 * PM25官网 http://www.pm25.in/api_doc
 * <p/>
 * Created by Yun on 2015/8/30.
 */
public class URL {

    //公共测试密钥
    public final static String KEY = "5j1znBVAsnSf5xQyNQyq";

    //获取一个城市所有监测点的PM2.5数据
    public final static String PM_2_5_URL = "http://www.pm25.in/api/querys/pm2_5.json";

    //获取一个城市所有监测点的PM10数据
    public final static String PM_10_URL = "http://www.pm25.in/api/querys/pm10.json";

    //获取一个城市所有监测点的CO数据
    public final static String CO_URL = "http://www.pm25.in/api/querys/co.json";

    //获取一个城市所有监测点的NO2数据
    public final static String NO_2_URL = "http://www.pm25.in/api/querys/no2.json";

    //获取一个城市所有监测点的SO2数据
    public final static String SO_2_URL = "http://www.pm25.in/api/querys/so2.json";

    //获取一个城市所有监测点的03数据
    public final static String O_3_URL = "http://www.pm25.in/api/querys/o3.json";

    //获取一个城市所有监测点的AQI数据(详细)
    public final static String AQI_DETAILS_URL = "http://www.pm25.in/api/querys/aqi_details.json";

    //获取一个城市所有监测点的AQI数据(仅AQI)
    public final static String AQI_URL = "http://www.pm25.in/api/querys/only_aqi.json";

    //获取一个监测点的AQI数据(含详情)
    public final static String STATION_AQI_URL = "http://www.pm25.in/api/querys/aqis_by_station.json";

    //获取一个城市的监测点列表
    public final static String STATION_NAME_URL = "http://www.pm25.in/api/querys/station_names.json";

    //获取实施了新《环境空气质量标准》的城市刘表，即有PM2.5数据的城市列表
    public final static String CITY_PM_2_5_URL = "http://www.pm25.in/api/querys.json";

    //获取所有城市的空气质量详细数据
    public final static String ALL_CITY_URL = "http://www.pm25.in/api/querys/all_cities.json";

    //获取全部城市的空气质量指数(AQI)排行榜
    public final static String RANKING_AQI_URL = "http://www.pm25.in/api/querys/aqi_ranking.json";

}
