/**
 *    Copyright 2009-2021 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package java8;

import org.junit.Test;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/** 2020/10/10 下午6:12 aiguoxin 说明: */
public class DateTest {

    @Test
    public void testDate() {
        Clock clock = Clock.systemDefaultZone();
        //        System.out.println(clock.millis()+"||"+System.currentTimeMillis());
        //        获取当前时间
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDateTime);
        System.out.println(new Date());

        // 格式化输出时间
        DateTimeFormatter dateTimeFormatter =
                new DateTimeFormatterBuilder()
                        .appendValue(ChronoField.YEAR)
                        .appendLiteral("/")
                        .appendValue(ChronoField.MONTH_OF_YEAR)
                        .appendLiteral("/")
                        .appendValue(ChronoField.DAY_OF_MONTH)
                        .appendLiteral(" ")
                        .appendValue(ChronoField.HOUR_OF_DAY)
                        .appendLiteral(":")
                        .appendValue(ChronoField.MINUTE_OF_HOUR)
                        .appendLiteral(":")
                        .appendValue(ChronoField.SECOND_OF_MINUTE)
                        .toFormatter();
        System.out.println(localDateTime.format(dateTimeFormatter));

        // 与Date类型互转
        Date date = new Date();
        LocalDateTime ldt = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        Date out = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println("ldt=" + ldt.format(dateTimeFormatter) + "|" + "out=" + out);

        // 求两个时间差
        System.out.println(ldt.with(TemporalAdjusters.firstDayOfMonth()));
        LocalDateTime nextDate = ldt.plusDays(1);
        long days = ChronoUnit.DAYS.between(ldt,nextDate);
        System.out.println("next=" + nextDate.format(dateTimeFormatter) + "| days = " + days);
    }
}
