package mypackage;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;
/**
 * 敬亚霖
 * 201931061165 软件工程
 */

public class WeatherForecastService {

    public static void main(String[] args) throws RemoteException, ServiceException {
        System.out.println("======接下来三天的天气状况为：======");
        String result[] = QueryWeatherForecastInfo("成都");
        for (String r : result) {
            System.out.println(r);
        }
    }

    public static String[] QueryWeatherForecastInfo(String cityName) throws RemoteException, ServiceException {
        WeatherWebServiceLocator locator = new WeatherWebServiceLocator();
        WeatherWebServiceSoap_BindingStub stud = (WeatherWebServiceSoap_BindingStub) locator.getWeatherWebServiceSoap();
        // 输出天气状况
        String[] weather = stud.getWeatherbyCityName("成都");
        return weather;
    }

}